package ui.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import static ui.driver.WebDriverRunner.CHROME;

public class Configuration {

    /**
     * Base url for open() function calls
     * Can be configured either programmatically or by system property "-Dselenide.baseUrl=http://myhost".
     * Default value: http://localhost:8080
     */
    public static String baseUrl = System.getProperty("baseUrl", "http://localhost:8080");

    /**
     * Which browser to use.
     * Can be configured either programmatically or by system property "-Dselenide.browser=ie" or "-Dbrowser=ie".
     * Supported values: "chrome", "firefox", "legacy_firefox", "ie", "htmlunit", "phantomjs", "opera", "safari", "edge", "jbrowser"
     * <br>
     * Default value: "firefox"
     */
    public static String browser = System.getProperty("browser", System.getProperty("browser", CHROME));

    /**
     * Defines if Selenide takes screenshots on failing tests.
     * Can be configured either programmatically or by system property "-Dselenide.screenshots=false".
     *
     * Default value: true
     */
    public static boolean screenshots = Boolean.parseBoolean(System.getProperty("screenshots", "true"));

    /**
     * Which browser version to use (for Internet Explorer).
     * Can be configured either programmatically or by system property "-Dselenide.browserVersion=8" or "-Dbrowser.version=8".
     * <br>
     * Default value: none
     */
    public static String browserVersion = System.getProperty("browserVersion",
            System.getProperty("browser.version", System.getProperty("browser.version")));

    /**
     * Browser capabilities.
     * Warning: this capabilities will override capabilities were set by system properties.
     * <br>
     * Default value: DesiredCapabilities::new
     */
    public static DesiredCapabilities browserCapabilities = new DesiredCapabilities();

    /**
     * Timeout (in milliseconds) for closing/killing browser.
     * <br>
     * Sometimes we have problems with calling driver.close() or driver.quit() method, and test always is suspended too long.
     * <br>
     * Can be configured either programmatically or by system property "-Dselenide.closeBrowserTimeout=10000"
     * Default value: 5000 (milliseconds)
     */
    public static long closeBrowserTimeoutMs = Long.parseLong(System.getProperty("selenide.closeBrowserTimeout", "5000"));

    /**
     * The browser window size.
     * Can be configured either programmatically or by system property "-Dselenide.browserSize=1024x768".
     *
     * Default value: none (browser size will not be set explicitly)
     */
    public static String browserSize = System.getProperty("selenide.browserSize",
            System.getProperty("selenide.browser-size"));

    /**
     * The browser window is maximized when started.
     * Can be configured either programmatically or by system property "-Dselenide.startMaximized=true".
     * <p>
     * Default value: true
     */
    public static boolean startMaximized = Boolean.parseBoolean(System.getProperty("selenide.startMaximized",
            System.getProperty("selenide.start-maximized", "false")));

    /**
     * Sets the path to browser executable.
     * Works only for Chrome, Firefox and Opera.
     */
    public static String browserBinary = System.getProperty("browserBinary", "/usr/bin/chromedriver");

    /**
     * Timeout in milliseconds to fail the test, if conditions still not met
     * Can be configured either programmatically or by system property "-Dselenide.timeout=10000"
     * Default value: 4000 (milliseconds)
     */
    public static long timeout = Long.parseLong(System.getProperty("timeout", "30"));

}
