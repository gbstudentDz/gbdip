package gb.dzhumaev.autotester.izumclub;

public class Selectors {
        public static final String[] TOP_MENU_LINE = {" #top-menu-line", "NAME"};
        public static final String[] CARDS_BLOCK = {" .product-block", "NAME"};
        public static final String[] CARD = {CARDS_BLOCK[0] + " .product-preview", "NAME"};
        public static final String[] CARD_1 = {CARD[0] + ":nth-child(1)", "NAME"};
        public static final String[] CARD_2 = {CARD[0] + ":nth-child(2)", "NAME"};
        public static final String[] CART_ON_TOP_MENU_LINE = {TOP_MENU_LINE[0] + " a[href='/basket/']:not(.cart_text)", "NAME"};
        public static final String[] CART_COUNTER = {CART_ON_TOP_MENU_LINE[0] + " .green_circle", "NAME"};
        public static final String[] CART_ON_CARD = {" .add-to-cart-btn", "NAME"};
        public static final String[] COMPARE_ON_TOP_MENU_LINE = {TOP_MENU_LINE[0] + " a[href='/catalog/compare']", "NAME"};
        public static final String[] COMPARE_COUNTER = {COMPARE_ON_TOP_MENU_LINE[0] + "+.green_circle", "NAME"};
        public static final String[] COMPARE_ON_CARD = {" .compare", "NAME"};
        public static final String[] FAVORITE_ON_TOP_MENU_LINE = {TOP_MENU_LINE[0] + " a[href='/favorite/']", "NAME"};
        public static final String[] FAVORITE_COUNTER = {FAVORITE_ON_TOP_MENU_LINE[0] + "+.green_circle", "NAME"};
        public static final String[] FAVORIVE_ON_CARD = {" .heart_icon", "NAME"};
        public static final String[] POPUP_SHOW_AFTER_FILTER = {" .bx-filter-popup-result a[target]", "NAME"};
        public static final String[] POPUP_WINDOW = {" .popup-window[style^='display: block']", "NAME"};
        public static final String[] POPUP_WINDOW_CLOSE = {POPUP_WINDOW[0] + " .popup-window-close-icon", "NAME"};
        public static final String[] PRICE_FILTER_BLOCK = {" #filter__form .block-with-two-input", "NAME"};
        public static final String[] PRICE_MAX_IN_FILTER = {PRICE_FILTER_BLOCK[0] + " input#arrFilter_P2_MAX", "NAME"};
        public static final String[] PRICE_MIN_IN_FILTER = {PRICE_FILTER_BLOCK[0] + " input#arrFilter_P2_MIN", "NAME"};
        public static final String[] PRICE_ON_CARD = {" .price", "NAME"};
        public static final String[] SORT_BLOCK = {" #sort-and-show-form .left-block .cs-select[tabindex='0']", "NAME"};
        public static final String[] SORT_PRICE_START_WITH_MAX = {SORT_BLOCK[0] + " li:nth-child(3) span", "NAME"};
        public static final String[] SORT_PRICE_START_WITH_MIN =  {SORT_BLOCK[0] + " li:nth-child(2) span", "NAME"};
        public static final String[] TAGS_BLOCK_ON_HEADER = {" .tags ul", "NAME"};
        public static final String[] TAG_1_ON_HEADER = {TAGS_BLOCK_ON_HEADER[0] + " li:nth-child(1)>a", "NAME"};
        public static final String[] TITLE_CATEGORY_PAGE = {" .page_title h1", "NAME"};
}
