package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import static ui.driver.Configuration.browser;

public class WebDriverRunner {
    public static WebDriverContainer webdriverContainer = new WebDriverThreadLocalContainer();

    public static final String CHROME = "chrome";

    /**
     * Is configured to use Chrome browser
     */
    public static boolean isChrome() {
        return CHROME.equalsIgnoreCase(browser);
    }

    /**
     * Get the underlying instance of Selenium WebDriver.
     * This can be used for any operations directly with WebDriver.
     */
    public static WebDriver getWebDriver() {
        return webdriverContainer.getWebDriver();
    }

    /**
     * Get the underlying instance of Selenium WebDriver, and assert that it's still alive.
     * @return new instance of WebDriver if the previous one has been closed meanwhile.
     */
    public static WebDriver getAndCheckWebDriver() {
        return webdriverContainer.getAndCheckWebDriver();
    }

    /**
     * Delete all the browser cookies
     */
    public static void clearBrowserCache() {
        webdriverContainer.clearBrowserCache();
    }

    /**
     * Close the browser if it's open
     */
    public static void closeWebDriver() {
        webdriverContainer.closeWebDriver();
    }

}
