package ui.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import static org.openqa.selenium.remote.CapabilityType.*;
import static ui.driver.Configuration.browserVersion;

abstract class AbstractDriverFactory {

    private static final Logger log = Logger.getLogger(AbstractDriverFactory.class.getName());

    abstract boolean supports();

    abstract WebDriver create();

    WebDriver createInstanceOf(final String className) {
        try {
            DesiredCapabilities capabilities = createCommonCapabilities();
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability(TAKES_SCREENSHOT, true);
            capabilities.setCapability(SUPPORTS_ALERTS, true);

            Class<?> clazz = Class.forName(className);
            if (WebDriverProvider.class.isAssignableFrom(clazz)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                return ((WebDriverProvider) constructor.newInstance()).createDriver(capabilities);
            } else {
                Constructor<?> constructor = Class.forName(className).getConstructor(Capabilities.class);
                return (WebDriver) constructor.newInstance(capabilities);
            }
        } catch (InvocationTargetException e) {
            throw runtime(e.getTargetException());
        } catch (Exception invalidClassName) {
            throw new IllegalArgumentException(invalidClassName);
        }
    }

    private RuntimeException runtime(Throwable exception) {
        return exception instanceof RuntimeException ? (RuntimeException) exception : new RuntimeException(exception);
    }

    DesiredCapabilities createCommonCapabilities() {
        DesiredCapabilities browserCapabilities = new DesiredCapabilities();

        if (browserVersion != null && !browserVersion.isEmpty()) {
            browserCapabilities.setVersion(browserVersion);
        }
        return browserCapabilities;
    }
}
