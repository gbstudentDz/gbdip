package gb.dzhumaev.autotester.pages.goldentime;

import org.openqa.selenium.By;

public class Locators {

    public static class GoldenTimeLocators {
        public static final By FAVORITE_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(1)>a");
        public static final By CART_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(4)>a");
        public static final By FAVORITE_COUNTER_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(1)>a .header-main__item-count:not(.hidden)");
        public static final By FAVORITE_COUNTER_HIDDEN_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(1)>a .header-main__item-count.hidden");
        public static final By CART_COUNTER_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(4)>a .header-main__item-count:not(.hidden)");
        public static final By CART_COUNTER_HIDDEN_LOCATOR = By.cssSelector("#BxBasketHeader>li:nth-child(4)>a .header-main__item-count.hidden");
        public static final By CARD_LOCATOR = By.cssSelector(".products .owl-item.active");
        public static final By ADD_TO_FAVORITE_LOCATOR = By.cssSelector(".favorite-btn");
        public static final By ADD_TO_CART_LOCATOR = By.cssSelector(".three-columns>div>button.add-to-basket");
        public static final By SEARCH_INPUT = By.cssSelector("#search_form>input");
    }

}

