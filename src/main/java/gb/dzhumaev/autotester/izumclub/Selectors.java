package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.SelectorInfo;

public class Selectors {
    public static final SelectorInfo TOP_MENU_LINE = new SelectorInfo(" #top-menu-line", "____");
    public static final SelectorInfo CARDS_BLOCK = new SelectorInfo(" .product-block", "____");
    public static final SelectorInfo CARD
            = new SelectorInfo(CARDS_BLOCK.s() + " .product-preview", "____");
    public static final SelectorInfo CARD_1
            = new SelectorInfo(CARD.s() + ":nth-child(1)", "Карточка товара №1");
    public static final SelectorInfo CARD_2
            = new SelectorInfo(CARD.s() + ":nth-child(2)", "Карточка товара №2");
    public static final SelectorInfo CART_ON_TOP_MENU_LINE
            = new SelectorInfo(TOP_MENU_LINE.s()
            + " a[href='/basket/']:not(.cart_text)", "Иконка корзины в верхнем меню");
    public static final SelectorInfo CART_COUNTER
            = new SelectorInfo(CART_ON_TOP_MENU_LINE.s() + " .green_circle", "____");
    public static final SelectorInfo CART_ON_CARD_1
            = new SelectorInfo(CARD_1.s() + " .add-to-cart-btn", "Иконка корзины в карточке товара №1");
    public static final SelectorInfo CART_ON_CARD_2
            = new SelectorInfo(CARD_2.s() + " .add-to-cart-btn", "Иконка корзины в карточке товара №2");
    public static final SelectorInfo COMPARE_ON_TOP_MENU_LINE = new SelectorInfo(TOP_MENU_LINE.s()
            + " a[href='/catalog/compare']", "Иконка сравнения в верхнем меню");
    public static final SelectorInfo COMPARE_COUNTER
            = new SelectorInfo(COMPARE_ON_TOP_MENU_LINE.s() + "+.green_circle", "____");
    public static final SelectorInfo COMPARE_ON_CARD_1
            = new SelectorInfo(CARD_1.s() + " .compare", "Иконка сравнения в карточке товара №1");
    public static final SelectorInfo COMPARE_ON_CARD_2
            = new SelectorInfo(CARD_2.s() + " .compare", "Иконка сравнения в карточке товара №2");
    public static final SelectorInfo FAVORITE_ON_TOP_MENU_LINE
            = new SelectorInfo(TOP_MENU_LINE.s()
            + " a[href='/favorite/']", "Иконка избранного в верхнем меню");
    public static final SelectorInfo FAVORITE_COUNTER
            = new SelectorInfo(FAVORITE_ON_TOP_MENU_LINE.s() + "+.green_circle", "____");
    public static final SelectorInfo FAVORIVE_ON_CARD_1
            = new SelectorInfo(CARD_1.s() + " .heart_icon", "Иконка избранного в карточке товара №1");
    public static final SelectorInfo FAVORIVE_ON_CARD_2
            = new SelectorInfo(CARD_2.s() + " .heart_icon", "Иконка избранного в карточке товара №2");
    public static final SelectorInfo POPUP_SHOW_AFTER_FILTER
            = new SelectorInfo(" .bx-filter-popup-result a[target]", "\"Показать\" в попапе");
    public static final SelectorInfo POPUP_WINDOW
            = new SelectorInfo(" .popup-window[style^='display: block']", "____");
    public static final SelectorInfo POPUP_WINDOW_CLOSE
            = new SelectorInfo(POPUP_WINDOW.s()
            + " .popup-window-close-icon", "крестик закрытия в модальном окне");
    public static final SelectorInfo PRICE_FILTER_BLOCK
            = new SelectorInfo(" #filter__form .block-with-two-input", "____");
    public static final SelectorInfo PRICE_MAX_IN_FILTER
            = new SelectorInfo(PRICE_FILTER_BLOCK.s()
            + " input#arrFilter_P2_MAX", "Поле ввода максимальной цены");
    public static final SelectorInfo PRICE_MIN_IN_FILTER
            = new SelectorInfo(PRICE_FILTER_BLOCK.s()
            + " input#arrFilter_P2_MIN", "Поле ввода минимальной цены");
    public static final SelectorInfo PRICE_ON_CARD = new SelectorInfo(" .price", "____");
    public static final SelectorInfo SORT_BLOCK
            = new SelectorInfo(" #sort-and-show-form .left-block .cs-select[tabindex='0']", "Раскрывющийся список сортировки");
    public static final SelectorInfo SORT_PRICE_START_WITH_MAX
            = new SelectorInfo(SORT_BLOCK.s() + " li:nth-child(3) span", "По убыванию цены");
    public static final SelectorInfo SORT_PRICE_START_WITH_MIN
            = new SelectorInfo(SORT_BLOCK.s() + " li:nth-child(2) span", "По возрастанию цены");
    public static final SelectorInfo TAGS_BLOCK_ON_HEADER
            = new SelectorInfo(" .tags ul", "____");
    public static final SelectorInfo TAG_1_ON_HEADER
            = new SelectorInfo(TAGS_BLOCK_ON_HEADER.s() + " li:nth-child(1)>a", "Тэг №1");
    public static final SelectorInfo TITLE_CATEGORY_PAGE = new SelectorInfo(" .page_title h1", "____");

    public static final SelectorInfo DETAIL_PAGE_FAST_ORDER = new SelectorInfo("a.fast_order", "Кнопка \"Быстрый заказ\"");
    public static final SelectorInfo FORM_FAST_ORDER = new SelectorInfo("#fast_order_form", "____");
    public static final SelectorInfo FORM_FAST_ORDER_CITY = new SelectorInfo("#CITY", "Поле ввода города");
    public static final SelectorInfo FORM_FAST_ORDER_FULLNAME = new SelectorInfo("#FIO", "Поле ввода ФИО");
    public static final SelectorInfo FORM_FAST_ORDER_PHONE = new SelectorInfo("#PHONE", "Поле ввода телефона");
    public static final SelectorInfo FORM_FAST_ORDER_EMAIL = new SelectorInfo("#EMAIL", "Поле ввода email");
    public static final SelectorInfo FORM_FAST_ORDER_SUBMIT = new SelectorInfo("button.btn-blue[type='submit']", "кнопка \"Заказать\"");
}
