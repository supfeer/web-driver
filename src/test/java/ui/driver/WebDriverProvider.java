package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface WebDriverProvider {

    WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}
