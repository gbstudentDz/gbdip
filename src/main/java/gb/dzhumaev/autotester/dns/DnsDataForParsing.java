package gb.dzhumaev.autotester.dns;

import org.openqa.selenium.By;

public class DnsDataForParsing {
    public static class Base {
        public static final String URL_HOME = "https://www.dns-shop.ru/";
        public static final String URL_FAVORITE = URL_HOME + "wishlist/index/";
        public static final String URL_COMPARE = URL_HOME + "compare/";
        public static final String URL_CART = URL_HOME + "cart/";
        public static final String URL_CATEGORY_SMARTPHONES = URL_HOME + "catalog/17a8a01d16404e77/smartfony/";
        public static final By LOCATOR_COMPARE = By.cssSelector(".compare-link-counter");
        public static final By LOCATOR_FAVORITE = By.cssSelector(".wishlist-link-counter");
        public static final By LOCATOR_CART = By.cssSelector(".cart-button");
        public static final By LOCATOR_COMPARE_COUNTER= By.cssSelector(".compare-link-counter__badge");
        public static final By LOCATOR_FAVORITE_COUNTER= By.cssSelector(".wishlist-link-counter__badge");
        public static final By LOCATOR_CART_COUNTER = By.cssSelector("cart-link-counter__badge");
        public static final By LOCATOR_SEARCH_INPUT = By.cssSelector("");

    }

    public static class Category {
        public static final By LOCATOR_PRODUCT_CARD = By.cssSelector("div.catalog-product");
        public static final By LOCATOR_PRODUCT_CARD_1 = By.cssSelector(".catalog-product:nth-child(1)");
        public static final By LOCATOR_PRODUCT_CARD_2 = By.cssSelector(".catalog-product:nth-child(2)");
    }

    public static class ProductCard {
        public static final By LOCATOR_BUY_BUTTON = By.cssSelector(".buy-btn");
        public static final By LOCATOR_COMPARE_CHECKBOX = By.cssSelector(".compare-checkbox");
        public static final By LOCATOR_FAVORIVE_BUTTON = By.cssSelector(".wishlist-btn");
    }

    public static class ProductDetails {
        public static final By LOCATOR_BUY_BUTTON = By.cssSelector(".buy-btn");
        public static final By LOCATOR_COMPARE_CHECKBOX = By.cssSelector(".compare-checkbox");
        public static final By LOCATOR_FAVORIVE_BUTTON = By.cssSelector(".wishlist-btn");
    }


}
