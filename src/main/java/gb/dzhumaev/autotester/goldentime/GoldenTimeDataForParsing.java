package gb.dzhumaev.autotester.goldentime;

import org.openqa.selenium.By;

public class GoldenTimeDataForParsing {



    public static class Base {
        public static final String URL_HOME = "https://golden-time.ru/";
        public static final String URL_FAVORITE = URL_HOME + "favorite/";
        public static final String URL_COMPARE = URL_HOME + "catalog/compare.php";
        public static final String URL_BASKET = URL_HOME + "basket/";
        public static final By LOCATOR_FAVORITE = By.cssSelector("#BxBasketHeader a[href='/favorite/']");
        public static final By LOCATOR_COMPARE = By.cssSelector("#BxBasketHeader a[href='/catalog/compare.php']");
        public static final By LOCATOR_BASKET = By.cssSelector("#BxBasketHeader a[href='/basket/']");
        public static final By LOCATOR_SEARCH_INPUT = By.cssSelector("input.header-main__search-input");
        public static final By LOCATOR_FAVORITE_COUNTER= By.cssSelector("#BxBasketHeader a[href='/favorite/'] .header-main__item-count:not(.hidden)");
        public static final By LOCATOR_FAVORITE_COUNTER_HIDDEN= By.cssSelector("#BxBasketHeader a[href='/favorite/'] .header-main__item-count.hidden");
        public static final By LOCATOR_COMPARE_COUNTER= By.cssSelector("#BxBasketHeader a[href='/catalog/compare.php'] .header-main__item-count:not(.hidden)");
        public static final By LOCATOR_COMPARE_COUNTER_HIDDEN= By.cssSelector("#BxBasketHeader a[href='/catalog/compare.php'] .header-main__item-count.hidden");
        public static final By LOCATOR_BASKET_COUNTER= By.cssSelector("#BxBasketHeader a[href='/basket/'] .header-main__item-count");
    }

    public static class PageProductDetalis {
        public static final String REGEX_PRICE = "^((\\d+ )+руб.)$";
    }


}
