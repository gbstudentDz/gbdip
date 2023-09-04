package gb.dzhumaev.autotester.izyum;

import org.openqa.selenium.By;

public class IzyumDataForParsing {
    public static class Base {
        public static final String URL_HOME = "https://izumclub.ru/";
        public static final String URL_COMPARE = URL_HOME + "catalog/compare";
        public static final String URL_FAVORITE = URL_HOME + "favorite/";
        public static final String URL_CART = URL_HOME + "basket/";
        public static final String URL_CATEGORY_SMARTPHONES = URL_HOME + "catalog/smartfony_telefony/";
        public static final By LOCATOR_COMPARE = By.cssSelector("#top-menu-line a[href='/catalog/compare']");
        public static final By LOCATOR_FAVORITE = By.cssSelector("#top-menu-line a[href='/favorite/']");
        public static final By LOCATOR_CART = By.cssSelector("#top-menu-line a[href='/basket/']:not(.cart_text)");
        public static final By LOCATOR_COMPARE_COUNTER= By.cssSelector("#top-menu-line a[href='/catalog/compare']+.green_circle");
        public static final By LOCATOR_FAVORITE_COUNTER= By.cssSelector("#top-menu-line a[href='/favorite/']+.green_circle");
        public static final By LOCATOR_CART_COUNTER = By.cssSelector("#top-menu-line a[href='/basket/'] .green_circle");
        public static final By LOCATOR_SEARCH_INPUT = By.cssSelector("input#title-search-input_main");

    }

    public static class Category {
        public static final By LOCATOR_PRODUCT_CARD = By.cssSelector(".product-block>.product-preview");
        public static final By LOCATOR_PRODUCT_CARD_1 = By.cssSelector(".product-block>.product-preview:nth-child(1)");
        public static final By LOCATOR_PRODUCT_CARD_2 = By.cssSelector(".product-block>.product-preview:nth-child(2)");
    }

    public static class ProductCard {
        public static final By LOCATOR_BUY_BUTTON = By.cssSelector(".add-to-cart-btn");
        public static final By LOCATOR_COMPARE_BUTTON = By.cssSelector(".compare");
        public static final By LOCATOR_FAVORIVE_BUTTON = By.cssSelector(".heart_icon");
    }

    public static class ProductDetails {
        public static final By LOCATOR_BUY_BUTTON = By.cssSelector(".btn-block [id$='add_basket_link']");
        public static final By LOCATOR_FAST_ORDER = By.cssSelector(".btn-block a.fast_order");
        public static final By LOCATOR_COMPARE_BUTTON = By.cssSelector(".compare");
        public static final By LOCATOR_FAVORIVE_BUTTON = By.cssSelector(".heart_icon");
    }


}
