package ui.specifications;

import org.junit.Assert;
import org.junit.Test;
import ui.UITest;
import ui.driver.Configuration;
import ui.pages.MainPage;

import static ui.pages.BasePage.open;

public class FreelancersFilterSpec extends UITest {

    /**
     * As unassigned user
     * I want to element freelancers
     * filtering by Category
     * and hourly rate
     */
    @Test
    public void freelancerShouldHaveSearchedText(){
        Configuration.baseUrl = "https://www.upwork.com";
        Configuration.baseUrl = "https://wellmax.eu";
        open("/");

        new MainPage().searchBox().setQ("Ruby").find();


        type(".search", "Ruby")
                .pressEnter(".search")
                .click(".filter")
                .applyFilter("Hourly rate", "$10 hours and below")
                .applyFilter("Category", "Web Development")
                .assertTitleContains("Ruby");

        page().click("second profile");

        String actualTitle = element("title").getText().toLowwerCase();
        String actualDescription = element("title").getText().toLowwerCase();
        Assert.assertTrue((actualTitle + actualDescription).contains("Ruby"));
    }
}
