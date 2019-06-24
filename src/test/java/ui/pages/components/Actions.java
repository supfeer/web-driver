package ui.pages.components;

public interface Actions<T extends Actions<T>> extends ElementResolver {

    default T click(String selector) {
        element(selector).click();
        return  (T) this;
    }

    default T type(String selector, String value) {
        element(selector).click();
        return  (T) this;
    }


}
