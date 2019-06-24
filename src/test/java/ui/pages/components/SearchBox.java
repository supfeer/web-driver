package ui.pages.components;

import org.openqa.selenium.By;

public interface SearchBox <T extends SearchBox<T>> extends ElementResolver {
    default T searchBox() {
        getDriver().findElement(new By.ByCssSelector(".sticky-sublocation [name=q]"));
        return  (T) this;
    }

    default T setQ(String q) {
        getDriver().findElements(By.name("q")).stream().filter(e-> e.isDisplayed()).findFirst().get().sendKeys(q);
        return  (T) this;
    }

    default T find(){

        getDriver().findElement(By.name("q")).submit();
        return  (T) this;
    }
}

