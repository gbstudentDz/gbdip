package gb.dzhumaev.autotester.pages.parfumlider;

import org.openqa.selenium.By;

public class ParfumLiderBasePageLocators {
    public static final By FAVORITE_LOCATOR = By.cssSelector(".header-top-right>.block-favorite");
    public static final By CART_LOCATOR = By.cssSelector(".header-top-right>.block-cart");
    public static final By FAVORITE_COUNTER_LOCATOR = By.cssSelector(".header-top-right>.block-favorite>a>.counter");
    public static final By CART_COUNTER_LOCATOR = By.cssSelector(".header-top-right>.block-cart>a>.counter");
    public static final By CARD_LOCATOR = By.cssSelector(".goodsSection_tabs>.tabs_list .catalog-card");
    public static final By FAVORITE_ON_CARD_LOCATOR = By.cssSelector(".tabs_list .catalog-card .favorite-icon");
    public static final By CART_ON_CARD_LOCATOR = By.cssSelector(".tabs_list .catalog-card .card-content .button_buy");
    public static final By SEARCH_BLOCK_COLLAPSED_LOCATOR = By.cssSelector(".header-top-right>.block-search-collapsed");
    public static final By SEARCH_POPUP_INPUT_LOCATOR = By.cssSelector("input.l-ss-c-input");
    public static final By SEARCH_POPUP_SUBMIT_BUTTON_LOCATOR = By.cssSelector(".l-ss-c-search-popup button");
}

