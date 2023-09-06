package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.PageUtils;
import gb.dzhumaev.autotester.TestCongicuration;
import gb.dzhumaev.autotester.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static gb.dzhumaev.autotester.PageUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование UI сайта " + IzyumData.Base.URL_HOME)
@Feature("Изменение счетчиков в шапке для разделов: сравнение, избранное, корзина")
@ExtendWith(TestListener.class)
public class ChangingСountersTest extends TestCongicuration {

    @Test
    @DisplayName("Счетчик сравнения увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t1() throws InterruptedException {
        getDriver().get(IzyumData.Base.URL_CATEGORY_SMARTPHONES);

        click(IzyumData.ProductCard.SELECTOR_COMPARE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_1);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_COMPARE_COUNTER));
    }

    @Test
    @DisplayName("Счетчик сравнения уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t2() throws InterruptedException {
        getDriver().get(IzyumData.Base.URL_CATEGORY_SMARTPHONES);

        click(IzyumData.ProductCard.SELECTOR_COMPARE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_1);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_COMPARE_COUNTER));

        click(IzyumData.ProductCard.SELECTOR_COMPARE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_2);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("2", getText(IzyumData.Base.SELECTOR_COMPARE_COUNTER));

        click(IzyumData.ProductCard.SELECTOR_COMPARE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_2);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_COMPARE_COUNTER));
    }


    @Test
    @DisplayName("Счетчик избранного увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t3() throws InterruptedException {
        getDriver().get(IzyumData.Base.URL_CATEGORY_SMARTPHONES);

        click(IzyumData.ProductCard.SELECTOR_FAVORIVE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_1);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_FAVORITE_COUNTER));
    }

    @Test
    @DisplayName("Счетчик избранного уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t4() throws InterruptedException {
        getDriver().get(IzyumData.Base.URL_CATEGORY_SMARTPHONES);

        click(IzyumData.ProductCard.SELECTOR_FAVORIVE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_1);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_FAVORITE_COUNTER));

        click(IzyumData.ProductCard.SELECTOR_FAVORIVE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_2);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("2", getText(IzyumData.Base.SELECTOR_FAVORITE_COUNTER));

        click(IzyumData.ProductCard.SELECTOR_FAVORIVE_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_2);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_FAVORITE_COUNTER));
    }

    @Test
    @DisplayName("Счетчик корзины увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t5() throws InterruptedException {
        getDriver().get(IzyumData.Base.URL_CATEGORY_SMARTPHONES);
        assertEquals("0", getText(IzyumData.Base.SELECTOR_CART_COUNTER));

        click(IzyumData.ProductCard.SELECTOR_BUY_BUTTON, IzyumData.Category.SELECTOR_PRODUCT_CARD_1);
        tryClick(IzyumData.Popups.SELECTOR_POPUP_WINDOW_CLOSE_ICON);
        assertEquals("1", getText(IzyumData.Base.SELECTOR_CART_COUNTER));
    }
}
