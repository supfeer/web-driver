package ui.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.Configuration;

import static ui.driver.WebDriverRunner.getWebDriver;

public interface ElementResolver {

    default WebElement element(String selector){
        if (isXpath(selector)) return findByXpath(selector);
        else return findByCss(selector);
    }

    default boolean isXpath(String selector){
        return selector.startsWith("/");
    }

    default WebElement findByXpath(String selector){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Configuration.timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
    }

    default WebElement findByCss(String selector){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Configuration.timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector(selector)));
    }
}
