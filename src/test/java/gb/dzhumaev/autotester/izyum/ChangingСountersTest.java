package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.TestCongicuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static gb.dzhumaev.autotester.PageUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование UI сайта " + IzyumDataForParsing.Base.URL_HOME)
@Feature("Изменение счетчиков в шапке для разделов: сравнение, избранное, корзина")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangingСountersTest extends TestCongicuration {

    @Test
    @DisplayName("Счетчик сравнения увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t1() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        String selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.SELECTOR_COMPARE_BUTTON);
        click(selector);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_COMPARE_COUNTER));
    }

    @Test
    @DisplayName("Счетчик сравнения уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t2() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        String selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.SELECTOR_COMPARE_BUTTON);
        click(selector);
        tryClick(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_COMPARE_COUNTER));

        selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_2,
                IzyumDataForParsing.ProductCard.SELECTOR_COMPARE_BUTTON);
        click(selector);
        tryClick(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("2", getText(IzyumDataForParsing.Base.SELECTOR_COMPARE_COUNTER));

        click(selector);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_COMPARE_COUNTER));
    }

    // ---

    @Test
    @DisplayName("Счетчик избранного увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t3() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        String selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.SELECTOR_FAVORIVE_BUTTON);
        click(selector);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_FAVORITE_COUNTER));
    }

    @Test
    @DisplayName("Счетчик избранного уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t4() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        String selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.SELECTOR_FAVORIVE_BUTTON);
        click(selector);
        tryClick(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_FAVORITE_COUNTER));

        selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_2,
                IzyumDataForParsing.ProductCard.SELECTOR_FAVORIVE_BUTTON);
        click(selector);
        tryClick(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("2", getText(IzyumDataForParsing.Base.SELECTOR_FAVORITE_COUNTER));

        click(selector);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_FAVORITE_COUNTER));
    }

    // ---

    @Test
    @DisplayName("Счетчик корзины увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t5() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        assertEquals("0", getText(IzyumDataForParsing.Base.SELECTOR_CART_COUNTER));

        String selector = joinSelectors(IzyumDataForParsing.Category.SELECTOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.SELECTOR_BUY_BUTTON);
        click(selector);
        assertEquals("1", getText(IzyumDataForParsing.Base.SELECTOR_CART_COUNTER));
    }
}
