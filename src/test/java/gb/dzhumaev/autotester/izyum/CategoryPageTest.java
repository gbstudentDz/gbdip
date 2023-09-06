package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.TestCongicuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static gb.dzhumaev.autotester.PageUtils.*;
import static gb.dzhumaev.autotester.izyum.IzyumData.Base.URL_CATEGORY_SMARTPHONES;
import static gb.dzhumaev.autotester.izyum.IzyumData.Category.*;
import static gb.dzhumaev.autotester.izyum.IzyumData.Popups.SELECTOR_POPUP_SHOW_AFTER_FILTER;
import static gb.dzhumaev.autotester.izyum.IzyumData.ProductCard.SELECTOR_PRICE_ON_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование UI сайта " + IzyumData.Base.URL_HOME)
@Feature("Тестирование страницы категории")
public class CategoryPageTest extends TestCongicuration {

    @Test
    @DisplayName("Плейсхолдер фильтра минимальной цены соответствует самой низкой цене продукта")
    public void t1() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(IzyumData.Category.SELECTOR_SORT_BLOCK);
        click(SELECTOR_SORT_PRICE_UP);
        assertEquals(getAttribute(SELECTOR_PRICE_MIN, "placeholder"),
                getText(SELECTOR_PRICE_ON_CARD, SELECTOR_PRODUCT_CARD_1).replace(" ", ""));
    }

    @Test
    @DisplayName("Плейсхолдер фильтра максимальной цены соответствует самой высокой цене продукта")
    public void t2() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(IzyumData.Category.SELECTOR_SORT_BLOCK);
        click(SELECTOR_SORT_PRICE_DOWN);
        assertEquals(getAttribute(SELECTOR_PRICE_MAX, "placeholder"),
                getText(SELECTOR_PRICE_ON_CARD, SELECTOR_PRODUCT_CARD_1).replace(" ", ""));
    }

    @Test
    @DisplayName("При переходе по тегу заголовок категории содержит тег")
    public void t3() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        String tagValue = getText(SELECTOR_TAG_1);
        click(SELECTOR_TAG_1);
        String pageTitle = getText(SELECTOR_PAGE_TITLE);
        assertTrue(pageTitle.contains(tagValue));
    }

    @Test
    @DisplayName("Проверка фильтра минимальной цены")
    public void t4() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = Double.parseDouble(getAttribute(SELECTOR_PRICE_MIN, "placeholder")
                .replace(" ", ""));
        double maxPrice = Double.parseDouble(getAttribute(SELECTOR_PRICE_MAX, "placeholder")
                .replace(" ", ""));
        double averagePrice = Math.floor((minPrice + maxPrice) / 2);
        click(IzyumData.Category.SELECTOR_SORT_BLOCK);
        click(SELECTOR_SORT_PRICE_UP);

        sendKeys(SELECTOR_PRICE_MIN, String.valueOf(averagePrice));
        sendEnter();
        click(SELECTOR_POPUP_SHOW_AFTER_FILTER);
        double priceOnFirstProduct = Double.parseDouble(getText(SELECTOR_PRICE_ON_CARD, SELECTOR_PRODUCT_CARD_1)
                .replace(" ", ""));

        assertTrue(priceOnFirstProduct >= averagePrice);
    }

    @Test
    @DisplayName("Проверка фильтра максимальной цены")
    public void t5() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        double minPrice = Double.parseDouble(getAttribute(SELECTOR_PRICE_MIN, "placeholder")
                .replace(" ", ""));
        double maxPrice = Double.parseDouble(getAttribute(SELECTOR_PRICE_MAX, "placeholder")
                .replace(" ", ""));
        double averagePrice = Math.floor((minPrice + maxPrice) / 2);
        click(IzyumData.Category.SELECTOR_SORT_BLOCK);
        click(SELECTOR_SORT_PRICE_DOWN);

        sendKeys(SELECTOR_PRICE_MAX, String.valueOf(averagePrice));
        sendEnter();
        click(SELECTOR_POPUP_SHOW_AFTER_FILTER);
        double priceOnFirstProduct = Double.parseDouble(getText(SELECTOR_PRICE_ON_CARD, SELECTOR_PRODUCT_CARD_1)
                .replace(" ", ""));

        assertTrue(priceOnFirstProduct <= averagePrice);
    }
}
