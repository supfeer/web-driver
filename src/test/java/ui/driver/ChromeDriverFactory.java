package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;

import static ui.driver.Configuration.browser;
import static ui.driver.WebDriverRunner.CHROME;

class ChromeDriverFactory extends AbstractDriverFactory {

    private static final Logger log = Logger.getLogger(ChromeDriverFactory.class.getName());

    WebDriver create() {
        ChromeOptions options = createChromeOptions();
        return new ChromeDriver(options);
    }

    @Override
    boolean supports() {
        return CHROME.equalsIgnoreCase(browser);
    }

    ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        log.config("Chrome options:" + options.toString());
        return options;
    }
}
