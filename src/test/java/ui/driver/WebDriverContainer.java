package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public interface WebDriverContainer {
    WebDriver setWebDriver(WebDriver webDriver);
    WebDriver getWebDriver();
    WebDriver getAndCheckWebDriver();
    void closeWebDriver();
    boolean hasWebDriverStarted();

    void clearBrowserCache();
    String getPageSource();
    String getCurrentUrl();
    String getCurrentFrameUrl();
}
