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

@Epic("Тестирование UI сайта " + URL_HOME)
@Feature("Изменение счетчиков в шапке для разделов: сравнение   ,    избранное   ,    корзина")
@ExtendWith(TestListener.class)
public class ChangingCountersTest extends TestCongicuration {

    @Test
    @DisplayName("Счетчик сравнения увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t1() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(COMPARE_ON_CARD[0], CARD_1[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("1", getText(COMPARE_COUNTER[0]));
    }

    @Test
    @DisplayName("Счетчик сравнения уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t2() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(COMPARE_ON_CARD[0], CARD_1[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("1", getText(COMPARE_COUNTER[0]));

        click(COMPARE_ON_CARD[0], CARD_2[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("2", getText(COMPARE_COUNTER[0]));

        click(COMPARE_ON_CARD[0], CARD_2[0]);
        assertEquals("1", getText(COMPARE_COUNTER[0]));
    }


    @Test
    @DisplayName("Счетчик избранного увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t3() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(FAVORIVE_ON_CARD[0], CARD_1[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("1", getText(FAVORITE_COUNTER[0]));
    }

    @Test
    @DisplayName("Счетчик избранного уменьшается при нажатии соответствующей иконки в карточке товара")
    public void t4() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);

        click(FAVORIVE_ON_CARD[0], CARD_1[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("1", getText(FAVORITE_COUNTER[0]));

        click(FAVORIVE_ON_CARD[0], CARD_2[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("2", getText(FAVORITE_COUNTER[0]));

        click(FAVORIVE_ON_CARD[0], CARD_2[0]);
        assertEquals("1", getText(FAVORITE_COUNTER[0]));
    }

    @Test
    @DisplayName("Счетчик корзины увеличивается при нажатии соответствующей иконки в карточке товара")
    public void t5() throws InterruptedException {
        getDriver().get(URL_CATEGORY_SMARTPHONES);
        assertEquals("0", getText(CART_COUNTER[0]));

        click(CART_ON_CARD[0], CARD_1[0]);
        tryClick(POPUP_WINDOW_CLOSE[0]);
        assertEquals("1", getText(CART_COUNTER[0]));
    }
}
