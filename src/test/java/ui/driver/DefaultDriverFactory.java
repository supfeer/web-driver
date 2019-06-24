package ui.driver;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

import static ui.driver.Configuration.browser;

public class DefaultDriverFactory extends AbstractDriverFactory {

    @Override
    boolean supports() {
        return true;
    }

    @Override
    WebDriver create() {
        return createInstanceOf(browser);
    }
}