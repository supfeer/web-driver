package ui.specifications;

import org.junit.Test;
import ui.UITest;

public class FreelancerFilter extends UITest {
    DriverManager driverManager;
    WebDriver driver;
    /**
     * As unassigned user
     * I want to find freelancers
     * filtering by Category
     * and hourly rate
     */
    @Test
    public void freelancerShouldHaveSearchedText(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }
}
