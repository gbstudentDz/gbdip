package gb.dzhumaev.autotester.izyum;

public class IzyumData {
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
    }

    public static class Popups {
        public static final String SELECTOR_POPUP_WINDOW = "  .popup-window[style^='display: block']";
        public static final String SELECTOR_POPUP_WINDOW_CLOSE_ICON = SELECTOR_POPUP_WINDOW + " .popup-window-close-icon";
        public static final String SELECTOR_POPUP_SHOW_AFTER_FILTER = " .bx-filter-popup-result a[target]";
    }

    public static class Category {
        public static final String SELECTOR_PAGE_TITLE = " .page_title h1";
        public static final String SELECTOR_TAGS_BLOCK = " .tags ul";
        public static final String SELECTOR_TAG_1 = SELECTOR_TAGS_BLOCK + " li:nth-child(1)>a";
        public static final String SELECTOR_SORT_BLOCK=  " #sort-and-show-form .left-block .cs-select[tabindex='0']";
        public static final String SELECTOR_SORT_PRICE_UP =  SELECTOR_SORT_BLOCK + " li:nth-child(2) span";
        public static final String SELECTOR_SORT_PRICE_DOWN = SELECTOR_SORT_BLOCK + " li:nth-child(3) span";
        public static final String SELECTOR_PRICE_FILTER_BLOCK =  " #filter__form .block-with-two-input";
        public static final String SELECTOR_PRICE_MIN = SELECTOR_PRICE_FILTER_BLOCK + " input#arrFilter_P2_MIN";
        public static final String SELECTOR_PRICE_MAX = SELECTOR_PRICE_FILTER_BLOCK + " input#arrFilter_P2_MAX";
        public static final String SELECTOR_PRODUCTS_BLOCK = " .product-block";
        public static final String SELECTOR_PRODUCT_CARD = SELECTOR_PRODUCTS_BLOCK + " .product-preview";
        public static final String SELECTOR_PRODUCT_CARD_1 = SELECTOR_PRODUCT_CARD + ":nth-child(1)";
        public static final String SELECTOR_PRODUCT_CARD_2 = SELECTOR_PRODUCT_CARD + ":nth-child(2)";
    }

    public static class ProductCard {
        public static final String SELECTOR_BUY_BUTTON = " .add-to-cart-btn";
        public static final String SELECTOR_PRICE_ON_CARD = " .price";
        public static final String SELECTOR_COMPARE_BUTTON = " .compare";
        public static final String SELECTOR_FAVORIVE_BUTTON = " .heart_icon";
    }
}
