package ui.pages;

import ui.pages.components.Actions;
import ui.pages.components.ElementResolver;

public abstract class BasePage <T extends BasePage<T>> implements ElementResolver, Actions {
    private String url;

    T page(String selector) {
        element(selector).click();
        return  (T) this;
    }



}
