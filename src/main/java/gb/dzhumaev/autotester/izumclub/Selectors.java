package gb.dzhumaev.autotester.izumclub;

public class Selectors {
        public static final String TOP_MENU_LINE = " #top-menu-line";
        public static final String CARDS_BLOCK = " .product-block";
        public static final String CARD = CARDS_BLOCK + " .product-preview";
        public static final String CARD_1 = CARD + ":nth-child(1)";
        public static final String CARD_2 = CARD + ":nth-child(2)";
        public static final String CART_ON_TOP_MENU_LINE = TOP_MENU_LINE + " a[href='/basket/']:not(.cart_text)";
        public static final String CART_COUNTER = CART_ON_TOP_MENU_LINE + " .green_circle";
        public static final String CART_ON_CARD = " .add-to-cart-btn";
        public static final String COMPARE_ON_TOP_MENU_LINE = TOP_MENU_LINE + " a[href='/catalog/compare']";
        public static final String COMPARE_COUNTER = COMPARE_ON_TOP_MENU_LINE + "+.green_circle";
        public static final String COMPARE_ON_CARD = " .compare";
        public static final String FAVORITE_ON_TOP_MENU_LINE = TOP_MENU_LINE + " a[href='/favorite/']";
        public static final String FAVORITE_COUNTER = FAVORITE_ON_TOP_MENU_LINE + "+.green_circle";
        public static final String FAVORIVE_ON_CARD = " .heart_icon";
        public static final String POPUP_SHOW_AFTER_FILTER = " .bx-filter-popup-result a[target]";
        public static final String POPUP_WINDOW = " .popup-window[style^='display: block']";
        public static final String POPUP_WINDOW_CLOSE = POPUP_WINDOW + " .popup-window-close-icon";
        public static final String PRICE_FILTER_BLOCK =  " #filter__form .block-with-two-input";
        public static final String PRICE_MAX_IN_FILTER = PRICE_FILTER_BLOCK + " input#arrFilter_P2_MAX";
        public static final String PRICE_MIN_IN_FILTER = PRICE_FILTER_BLOCK + " input#arrFilter_P2_MIN";
        public static final String PRICE_ON_CARD = " .price";
        public static final String SORT_BLOCK =  " #sort-and-show-form .left-block .cs-select[tabindex='0']";
        public static final String SORT_PRICE_START_WITH_MAX = SORT_BLOCK + " li:nth-child(3) span";
        public static final String SORT_PRICE__START_WITH_MIN =  SORT_BLOCK + " li:nth-child(2) span";
        public static final String TAGS_BLOCK_ON_HEADER = " .tags ul";
        public static final String TAG_1_ON_HEADER = TAGS_BLOCK_ON_HEADER + " li:nth-child(1)>a";
        public static final String TITLE_CATEGORY_PAGE = " .page_title h1";
}
