package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static ui.driver.Configuration.baseUrl;
import static ui.driver.WebDriverRunner.getAndCheckWebDriver;

public class Navigator {

    public static void open(String relativeOrAbsoluteUrl) {
        new Navigator().navigateTo(relativeOrAbsoluteUrl);
    }

    private void navigateTo(String url) {

        url = absoluteUrl(url);

        try {
            WebDriver webdriver = getAndCheckWebDriver();
            webdriver.navigate().to(url);
        } catch (WebDriverException e) {
            e.addInfo("url", url);
            e.addInfo("baseUrl", baseUrl);
            throw e;
        }
    }

    String absoluteUrl(String relativeOrAbsoluteUrl) {
        return isAbsoluteUrl(relativeOrAbsoluteUrl) ? relativeOrAbsoluteUrl : baseUrl + relativeOrAbsoluteUrl;
    }

    boolean isAbsoluteUrl(String relativeOrAbsoluteUrl) {
        return relativeOrAbsoluteUrl.toLowerCase().startsWith("http:") ||
                relativeOrAbsoluteUrl.toLowerCase().startsWith("https:");
    }
}
