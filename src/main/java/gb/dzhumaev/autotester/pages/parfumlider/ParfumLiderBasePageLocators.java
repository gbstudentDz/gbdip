package gb.dzhumaev.autotester.pages.parfumlider;

import org.openqa.selenium.By;

public class ParfumLiderBasePageLocators {
    public static final By FAVORITE_LOCATOR = By.className("block-favorite");
    public static final By CART_LOCATOR = By.className("block-cart");
    public static final By FAVORITE_COUNTER_LOCATOR = By.cssSelector(".block-favorite>a>.js-favorite-col");
    public static final By CART_COUNTER_LOCATOR = By.cssSelector(".block-cart>a>.js-basket-col");
    public static final By CARD_LOCATOR = By.cssSelector(".catalog-card");
    public static final By FAVORITE_ON_CARD_LOCATOR = By.className("favorite-icon");
    public static final By CART_ON_CARD_LOCATOR = By.className("js-buy-block");
    public static final By INPUT_SEARCH_COMPRESSED_LOCATOR = By.className("search-main__input");
    public static final By INPUT_SEARCH_UNCOMPRESSED_LOCATOR = By.className("digi-search-form__input");
    public static final By BTN_SEARCH_LOCATOR = By.className("btn--search");
}

