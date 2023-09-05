package gb.dzhumaev.autotester.izyum;

public class IzyumDataForParsing {
    public static class Base {
        public static final String URL_HOME = "https://izumclub.ru/";
        public static final String URL_COMPARE = URL_HOME + "catalog/compare/";
        public static final String URL_FAVORITE = URL_HOME + "favorite/";
        public static final String URL_CART = URL_HOME + "basket/";
        public static final String URL_CATEGORY_SMARTPHONES = URL_HOME + "catalog/smartfony_telefony/";
        public static final String SELECTOR_TOP_MENU_LINE = " #top-menu-line";
        public static final String SELECTOR_COMPARE = SELECTOR_TOP_MENU_LINE + " a[href='/catalog/compare']";
        public static final String SELECTOR_FAVORITE = SELECTOR_TOP_MENU_LINE + " a[href='/favorite/']";
        public static final String SELECTOR_CART = SELECTOR_TOP_MENU_LINE + " a[href='/basket/']:not(.cart_text)";
        public static final String SELECTOR_COMPARE_COUNTER= SELECTOR_COMPARE + "+.green_circle";
        public static final String SELECTOR_FAVORITE_COUNTER= SELECTOR_FAVORITE + "+.green_circle";
        public static final String SELECTOR_CART_COUNTER = SELECTOR_CART + " .green_circle";
        public static final String SELECTOR_SEARCH_INPUT = " input#title-search-input_main";

    }

    public static class Popups {
        public static final String SELECTOR_POPUP_WINDOW = "  .popup-window[style^='display: block']";
        public static final String SELECTOR_POPUP_WINDOW_CLOSE_ICON = SELECTOR_POPUP_WINDOW + " .popup-window-close-icon";
    }

    public static class Category {
        public static final String SELECTOR_PRODUCTS_BLOCK = " .product-block";
        public static final String SELECTOR_PRODUCT_CARD = SELECTOR_PRODUCTS_BLOCK + " .product-preview";
        public static final String SELECTOR_PRODUCT_CARD_1 = SELECTOR_PRODUCTS_BLOCK + " .product-preview:nth-child(1)";
        public static final String SELECTOR_PRODUCT_CARD_2 = SELECTOR_PRODUCTS_BLOCK + " .product-preview:nth-child(2)";
    }

    public static class ProductCard {
        public static final String SELECTOR_BUY_BUTTON = " .add-to-cart-btn";
        public static final String SELECTOR_COMPARE_BUTTON = " .compare";
        public static final String SELECTOR_FAVORIVE_BUTTON = " .heart_icon";
    }

    public static class ProductDetails {
        public static final String SELECTOR_TOP_BLOCK = " .top_block";
        public static final String SELECTOR_COMPARE_BUTTON = SELECTOR_TOP_BLOCK + " .compare";
        public static final String SELECTOR_FAVORIVE_BUTTON = SELECTOR_TOP_BLOCK + " .heart_icon";
        public static final String SELECTOR_ADD_TO_CART_BLOCK = " #add-to-cart-block";
        public static final String SELECTOR_BUY_BUTTON = SELECTOR_ADD_TO_CART_BLOCK + " [id$='add_basket_link']";
        public static final String SELECTOR_FAST_ORDER = SELECTOR_ADD_TO_CART_BLOCK + " a.fast_order";
    }


}
