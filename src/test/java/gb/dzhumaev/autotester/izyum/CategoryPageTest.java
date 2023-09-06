package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.TestCongicuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static gb.dzhumaev.autotester.PageUtils.*;
import static gb.dzhumaev.autotester.izyum.IzyumData.Base.URL_CATEGORY_SMARTPHONES;
import static gb.dzhumaev.autotester.izyum.IzyumData.Category.*;
import static gb.dzhumaev.autotester.izyum.IzyumData.ProductCard.SELECTOR_PRICE_ON_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
