package ui.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static ui.driver.Configuration.*;
import static ui.driver.WebDriverRunner.isChrome;

public class WebDriverFactory {

    private static final Logger log = Logger.getLogger(WebDriverFactory.class.getName());

    protected List<AbstractDriverFactory> factories = asList(
            new ChromeDriverFactory()
    );

    public WebDriver createWebDriver() {
        log.config("Configuration.browser=" + browser);
        log.config("Configuration.browser.version=" + browserVersion);

        WebDriver webdriver = factories.stream()
                .filter(AbstractDriverFactory::supports)
                .findAny()
                .map(driverFactory -> driverFactory.create())
                .orElseGet(() -> new DefaultDriverFactory().create());

        webdriver = adjustBrowserSize(webdriver);

        return webdriver;
    }

    protected WebDriver adjustBrowserSize(WebDriver driver) {
        if (browserSize != null) {
            log.info("Set browser size to " + browserSize);
            String[] dimension = browserSize.split("x");
            int width = Integer.parseInt(dimension[0]);
            int height = Integer.parseInt(dimension[1]);
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
        } else if (startMaximized) {
            try {
                if (isChrome()) {
                    maximizeChromeBrowser(driver.manage().window());
                } else {
                    driver.manage().window().maximize();
                }
            } catch (Exception cannotMaximize) {
                log.warning("Cannot maximize ");
            }
        }
        return driver;
    }

    protected void maximizeChromeBrowser(WebDriver.Window window) {
        // Chrome driver does not yet support maximizing. Let' apply black magic!
        org.openqa.selenium.Dimension screenResolution = getScreenSize();

        window.setSize(screenResolution);
        window.setPosition(new org.openqa.selenium.Point(0, 0));
    }

    Dimension getScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        return new Dimension(
                (int) toolkit.getScreenSize().getWidth(),
                (int) toolkit.getScreenSize().getHeight());
    }
}
