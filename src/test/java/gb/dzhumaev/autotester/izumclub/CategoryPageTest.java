package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.TestCongicuration;
import gb.dzhumaev.autotester.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static gb.dzhumaev.autotester.PageUtils.*;
import static gb.dzhumaev.autotester.izumclub.Selectors.*;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_CATEGORY_SMARTPHONES;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_HOME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование UI сайта " + URL_HOME)
@Feature("Тестирование страницы категории")
@ExtendWith(TestListener.class)
public class CategoryPageTest extends TestCongicuration {

    @Test
    @DisplayName("Плейсхолдер фильтра минимальной цены соответствует самой низкой цене продукта")
    public void t1() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MIN[0]);

        double priceMinInFilrer = extractDouble(getAttribute(PRICE_MIN_IN_FILTER[0], "placeholder"));
        double priceOnFirstCard = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));
        assertEquals(priceMinInFilrer, priceOnFirstCard);
    }

    @Test
    @DisplayName("Плейсхолдер фильтра максимальной цены соответствует самой высокой цене продукта")
    public void t2() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MAX[0]);

        double priceMaxInFilrer = extractDouble(getAttribute(PRICE_MAX_IN_FILTER[0], "placeholder"));
        double priceOnFirstCard = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));
        assertEquals(priceMaxInFilrer, priceOnFirstCard);
    }

    @Test
    @DisplayName("При переходе по тегу заголовок категории содержит тег")
    public void t3() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        String tagValue = getText(TAG_1_ON_HEADER[0]);
        click(TAG_1_ON_HEADER[0]);
        String pageTitle = getText(TITLE_CATEGORY_PAGE[0]);
        assertTrue(pageTitle.contains(tagValue));
    }

    @Test
    @DisplayName("Проверка фильтра минимальной цены")
    public void t4() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = extractDouble(getAttribute(PRICE_MIN_IN_FILTER[0], "placeholder"));
        double maxPrice = extractDouble(getAttribute(PRICE_MAX_IN_FILTER[0], "placeholder"));
        double averagePrice = (minPrice + maxPrice) / 2;

        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MIN[0]);

        sendKeys(PRICE_MIN_IN_FILTER[0], String.valueOf(averagePrice));
        sendEnter();
        click(POPUP_SHOW_AFTER_FILTER[0]);

        double priceOnFirstProduct = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));

        assertTrue(priceOnFirstProduct >= averagePrice);
    }

    @Test
    @DisplayName("Проверка фильтра максимальной цены")
    public void t5() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = extractDouble(getAttribute(PRICE_MIN_IN_FILTER[0], "placeholder"));
        double maxPrice = extractDouble(getAttribute(PRICE_MAX_IN_FILTER[0], "placeholder"));
        double averagePrice = (minPrice + maxPrice) / 2;
        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MAX[0]);

        sendKeys(PRICE_MAX_IN_FILTER[0], String.valueOf(averagePrice));
        sendEnter();
        click(POPUP_SHOW_AFTER_FILTER[0]);

        double priceOnFirstProduct = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));

        assertTrue(priceOnFirstProduct <= averagePrice);
    }

    @Test
    @DisplayName("Проверка фильтра максимальной цены")
    public void t6() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = extractDouble(getAttribute(PRICE_MIN_IN_FILTER[0], "placeholder"));
        double maxPrice = extractDouble(getAttribute(PRICE_MAX_IN_FILTER[0], "placeholder"));
        double averagePrice = (minPrice + maxPrice) / 2;
        minPrice = (minPrice + averagePrice) / 2;
        maxPrice = (averagePrice + maxPrice) / 2;

        sendKeys(PRICE_MIN_IN_FILTER[0], String.valueOf(minPrice));
        sendKeys(PRICE_MAX_IN_FILTER[0], String.valueOf(maxPrice));
        click(POPUP_SHOW_AFTER_FILTER[0]);

        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MIN[0]);
        double priceOnFirstCard = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));
        assertTrue(priceOnFirstCard >= minPrice);

        click(SORT_BLOCK[0]);
        click(SORT_PRICE_START_WITH_MAX[0]);
        priceOnFirstCard = extractDouble(getText(PRICE_ON_CARD[0], CARD_1[0]));
        assertTrue(priceOnFirstCard <= maxPrice);
    }
}
