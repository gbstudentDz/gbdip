package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.TestCongicuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static gb.dzhumaev.autotester.PageUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование UI сайта " + IzyumDataForParsing.Base.URL_HOME)
@Feature("Изменение счетчиков в шапке для разделов: сравнение, избранное, корзина")
public class ChangingСountersTest extends TestCongicuration {

    @Test
    @DisplayName("Счетчик сравнения увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t1() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        By locator = joinLocators(IzyumDataForParsing.Category.LOCATOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.LOCATOR_COMPARE_BUTTON);
        click(locator);
        assertEquals("1", getText(IzyumDataForParsing.Base.LOCATOR_CART_COUNTER));
    }

    @Test
    @DisplayName("Счетчик сравнения уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t2() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        By locator = joinLocators(IzyumDataForParsing.Category.LOCATOR_PRODUCT_CARD_1,
                IzyumDataForParsing.ProductCard.LOCATOR_COMPARE_BUTTON);
        click(locator);
        click(By.cssSelector(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON));
        assertEquals("1", getText(IzyumDataForParsing.Base.LOCATOR_COMPARE_COUNTER));

        locator = joinLocators(IzyumDataForParsing.Category.LOCATOR_PRODUCT_CARD_2,
                IzyumDataForParsing.ProductCard.LOCATOR_COMPARE_BUTTON);
        click(locator);
        click(By.cssSelector(IzyumDataForParsing.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON));
        assertEquals("2", getText(IzyumDataForParsing.Base.LOCATOR_COMPARE_COUNTER));

        click(locator);
        assertEquals("1", getText(IzyumDataForParsing.Base.LOCATOR_COMPARE_COUNTER));
    }
}
