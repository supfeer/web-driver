package ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ui.driver.Configuration;
import ui.driver.Navigator;

import static ui.driver.WebDriverRunner.*;

public abstract class UITest {

    @BeforeClass
    public void beforeClass(){
        Configuration.baseUrl = "https://www.upwork.com/";
    }

    @After
    public void after() {
        clearBrowserCache();
    }

    @AfterClass
    public void afterClass(){
        closeWebDriver();
    }
}
