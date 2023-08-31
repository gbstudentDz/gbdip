package gb.dzhumaev.autotester.pages.goldentime;

import org.openqa.selenium.By;

public class GoldenTimeLocators {

    public static class BasePage {
        public static final By FAVORITE = By.cssSelector("#BxBasketHeader>li:nth-child(1)>a");
        public static final By CART = By.cssSelector("#BxBasketHeader>li:nth-child(4)>a");
        public static final By FAVORITE_COUNTER = By.cssSelector("#BxBasketHeader>li:nth-child(1)>a .header-main__item-count:not(.hidden)");
        public static final By CART_COUNTER = By.cssSelector("#BxBasketHeader>li:nth-child(4)>a .header-main__item-count:not(.hidden)");
        public static final By ADD_TO_FAVORITE = By.cssSelector(".favorite-btn");
        public static final By ADD_TO_CART = By.cssSelector(".three-columns>div>button.add-to-basket");
        public static final By SEARCH_INPUT = By.cssSelector("#search_form>input");
    }

    public static class CartPage {
        public static By BASKET_ITEM = By.cssSelector("tr[id^=basket-item]");
        public static By BASKET_ITEM_AMOUNT_FILED = By.cssSelector("input.basket-item-amount-filed");
        public static By BASKET_ITEM_AMOUNT_BTN_MINUS = By.cssSelector(".basket-item-amount-btn-minus");
        public static By BASKET_ITEM_AMOUNT_BTN_PLUS = By.cssSelector(".basket-item-amount-btn-plus");
        public static By BASKET_ITEM_PRICE = By.cssSelector(".basket-item-price-current-text");
        public static By FINAL_ITEM_PRICE = By.cssSelector("#bx-soa-total .bx-soa-cart-d");
    }
}

