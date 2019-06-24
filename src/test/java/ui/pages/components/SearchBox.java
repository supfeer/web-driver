package ui.pages.components;

public interface SearchBox<T> {
    default SearchBox searchBox() {
        return this;
    }
}

