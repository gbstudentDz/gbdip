package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.SelectorInfo;

public class Selectors {
        public static final SelectorInfo TOP_MENU_LINE = new SelectorInfo(" #top-menu-line", "NAME");
        public static final SelectorInfo CARDS_BLOCK = new SelectorInfo(" .product-block", "NAME");
        public static final SelectorInfo CARD = new SelectorInfo(CARDS_BLOCK.s() + " .product-preview", "NAME");
        public static final SelectorInfo CARD_1 = new SelectorInfo(CARD.s() + ":nth-child(1)", "NAME");
        public static final SelectorInfo CARD_2 = new SelectorInfo(CARD.s() + ":nth-child(2)", "NAME");
        public static final SelectorInfo CART_ON_TOP_MENU_LINE = new SelectorInfo(TOP_MENU_LINE.s() + " a[href='/basket/']:not(.cart_text)", "NAME");
        public static final SelectorInfo CART_COUNTER = new SelectorInfo(CART_ON_TOP_MENU_LINE.s() + " .green_circle", "NAME");
        public static final SelectorInfo CART_ON_CARD = new SelectorInfo(" .add-to-cart-btn", "NAME");
        public static final SelectorInfo COMPARE_ON_TOP_MENU_LINE = new SelectorInfo(TOP_MENU_LINE.s() + " a[href='/catalog/compare']", "NAME");
        public static final SelectorInfo COMPARE_COUNTER = new SelectorInfo(COMPARE_ON_TOP_MENU_LINE.s() + "+.green_circle", "NAME");
        public static final SelectorInfo COMPARE_ON_CARD = new SelectorInfo(" .compare", "NAME");
        public static final SelectorInfo FAVORITE_ON_TOP_MENU_LINE = new SelectorInfo(TOP_MENU_LINE.s() + " a[href='/favorite/']", "NAME");
        public static final SelectorInfo FAVORITE_COUNTER = new SelectorInfo(FAVORITE_ON_TOP_MENU_LINE.s() + "+.green_circle", "NAME");
        public static final SelectorInfo FAVORIVE_ON_CARD = new SelectorInfo(" .heart_icon", "NAME");
        public static final SelectorInfo POPUP_SHOW_AFTER_FILTER = new SelectorInfo(" .bx-filter-popup-result a[target]", "NAME");
        public static final SelectorInfo POPUP_WINDOW = new SelectorInfo(" .popup-window[style^='display: block']", "NAME");
        public static final SelectorInfo POPUP_WINDOW_CLOSE = new SelectorInfo(POPUP_WINDOW.s() + " .popup-window-close-icon", "NAME");
        public static final SelectorInfo PRICE_FILTER_BLOCK = new SelectorInfo(" #filter__form .block-with-two-input", "NAME");
        public static final SelectorInfo PRICE_MAX_IN_FILTER = new SelectorInfo(PRICE_FILTER_BLOCK.s() + " input#arrFilter_P2_MAX", "NAME");
        public static final SelectorInfo PRICE_MIN_IN_FILTER = new SelectorInfo(PRICE_FILTER_BLOCK.s() + " input#arrFilter_P2_MIN", "NAME");
        public static final SelectorInfo PRICE_ON_CARD = new SelectorInfo(" .price", "NAME");
        public static final SelectorInfo SORT_BLOCK = new SelectorInfo(" #sort-and-show-form .left-block .cs-select[tabindex='0']", "NAME");
        public static final SelectorInfo SORT_PRICE_START_WITH_MAX = new SelectorInfo(SORT_BLOCK.s() + " li:nth-child(3) span", "NAME");
        public static final SelectorInfo SORT_PRICE_START_WITH_MIN =  new SelectorInfo(SORT_BLOCK.s() + " li:nth-child(2) span", "NAME");
        public static final SelectorInfo TAGS_BLOCK_ON_HEADER = new SelectorInfo(" .tags ul", "NAME");
        public static final SelectorInfo TAG_1_ON_HEADER = new SelectorInfo(TAGS_BLOCK_ON_HEADER.s() + " li:nth-child(1)>a", "NAME");
        public static final SelectorInfo TITLE_CATEGORY_PAGE = new SelectorInfo(" .page_title h1", "NAME");
}
