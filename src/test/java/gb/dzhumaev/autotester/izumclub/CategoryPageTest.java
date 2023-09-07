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

        click(SORT_BLOCK);
        click(SORT_PRICE__START_WITH_MIN);
        assertEquals(getAttribute(PRICE_MIN_IN_FILTER, "placeholder"),
                getText(PRICE_ON_CARD, CARD_1).replace(" ", ""));
    }

    @Test
    @DisplayName("Плейсхолдер фильтра максимальной цены соответствует самой высокой цене продукта")
    public void t2() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(SORT_BLOCK);
        click(SORT_PRICE_START_WITH_MAX);
        assertEquals(getAttribute(PRICE_MAX_IN_FILTER, "placeholder"),
                getText(PRICE_ON_CARD, CARD_1).replace(" ", ""));
    }

    @Test
    @DisplayName("При переходе по тегу заголовок категории содержит тег")
    public void t3() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        String tagValue = getText(TAG_1_ON_HEADER);
        click(TAG_1_ON_HEADER);
        String pageTitle = getText(TITLE_CATEGORY_PAGE);
        assertTrue(pageTitle.contains(tagValue));
    }

    @Test
    @DisplayName("Проверка фильтра минимальной цены")
    public void t4() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = Double.parseDouble(getAttribute(PRICE_MIN_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double maxPrice = Double.parseDouble(getAttribute(PRICE_MAX_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double averagePrice = Math.floor((minPrice + maxPrice) / 2);

        click(SORT_BLOCK);
        click(SORT_PRICE__START_WITH_MIN);

        sendKeys(PRICE_MIN_IN_FILTER, String.valueOf(averagePrice));
        sendEnter();
        click(POPUP_SHOW_AFTER_FILTER);

        double priceOnFirstProduct = Double.parseDouble(getText(PRICE_ON_CARD, CARD_1)
                .replace(" ", ""));

        assertTrue(priceOnFirstProduct >= averagePrice);
    }

    @Test
    @DisplayName("Проверка фильтра максимальной цены")
    public void t5() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = Double.parseDouble(getAttribute(PRICE_MIN_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double maxPrice = Double.parseDouble(getAttribute(PRICE_MAX_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double averagePrice = Math.floor((minPrice + maxPrice) / 2);
        click(SORT_BLOCK);
        click(SORT_PRICE_START_WITH_MAX);

        sendKeys(PRICE_MAX_IN_FILTER, String.valueOf(averagePrice));
        sendEnter();
        click(POPUP_SHOW_AFTER_FILTER);

        double priceOnFirstProduct = Double.parseDouble(getText(PRICE_ON_CARD, CARD_1)
                .replace(" ", ""));

        assertTrue(priceOnFirstProduct <= averagePrice);
    }

    @Test
    @DisplayName("Проверка фильтра максимальной цены")
    public void t6() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = Double.parseDouble(getAttribute(PRICE_MIN_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double maxPrice = Double.parseDouble(getAttribute(PRICE_MAX_IN_FILTER, "placeholder")
                .replace(" ", ""));
        double averagePrice = Math.floor((minPrice + maxPrice) / 2);
        minPrice = (minPrice + averagePrice) / 2;
        maxPrice = (averagePrice + maxPrice) / 2;

        sendKeys(PRICE_MIN_IN_FILTER, String.valueOf(minPrice));
        sendKeys(PRICE_MAX_IN_FILTER, String.valueOf(maxPrice));
        click(POPUP_SHOW_AFTER_FILTER);

        click(SORT_BLOCK);
        click(SORT_PRICE__START_WITH_MIN);
        double priceOnFirstCard = Double.parseDouble(getText(PRICE_ON_CARD, CARD_1)
                .replace(" ", ""));
        assertTrue(priceOnFirstCard >= minPrice);

        click(SORT_BLOCK);
        click(SORT_PRICE_START_WITH_MAX);
        priceOnFirstCard = Double.parseDouble(getText(PRICE_ON_CARD, CARD_1)
                .replace(" ", ""));
        assertTrue(priceOnFirstCard <= maxPrice);
    }
}
