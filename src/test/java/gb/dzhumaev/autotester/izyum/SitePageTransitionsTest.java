package gb.dzhumaev.autotester.izyum;

import gb.dzhumaev.autotester.TestCongicuration;
import gb.dzhumaev.autotester.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static gb.dzhumaev.autotester.PageUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование UI сайта " + IzyumData.Base.URL_HOME)
@Feature("Переходы по основным разделам")
@ExtendWith(TestListener.class)
public class SitePageTransitionsTest extends TestCongicuration {

    @Test
    @DisplayName("Открытие главной страницы")
    public void openHomepage() throws InterruptedException {
        open(IzyumData.Base.URL_HOME);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_HOME);
    }

    @Test
    @DisplayName("Открытие страницы сравнения")
    public void openCompare() throws InterruptedException {
        open(IzyumData.Base.URL_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного")
    public void openFavorite() throws InterruptedException {
        open(IzyumData.Base.URL_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины")
    public void openCart() throws InterruptedException {
        open(IzyumData.Base.URL_CART);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_CART);
    }

    // ---
    @Test
    @DisplayName("Открытие страницы сравнения с главной по клику на иконку в шапке")
    public void openCompareFromHomePageTest() throws InterruptedException {
        open(IzyumData.Base.URL_HOME);
        click(IzyumData.Base.SELECTOR_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного с главной по клику на иконку в шапке")
    public void openFavoriteFromHomePageTest() throws InterruptedException {
        open(IzyumData.Base.URL_HOME);
        click(IzyumData.Base.SELECTOR_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины с главной по клику на иконку в шапке")
    public void openCartFromHomePageTest() throws InterruptedException {
        open(IzyumData.Base.URL_HOME);
        click(IzyumData.Base.SELECTOR_CART);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы сравнения по клику на иконку в шапке")
    public void openCompareFromCompareTest() throws InterruptedException {
        open(IzyumData.Base.URL_COMPARE);
        click(IzyumData.Base.SELECTOR_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы сравнения по клику на иконку в шапке")
    public void openFavoriteFromCompareTest() throws InterruptedException {
        open(IzyumData.Base.URL_COMPARE);
        click(IzyumData.Base.SELECTOR_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы сравнения по клику на иконку в шапке")
    public void openCartFromCompareTest() throws InterruptedException {
        open(IzyumData.Base.URL_COMPARE);
        click(IzyumData.Base.SELECTOR_CART);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы избранного по клику на иконку в шапке")
    public void openCompareFromFavoriveTest() throws InterruptedException {
        open(IzyumData.Base.URL_FAVORITE);
        click(IzyumData.Base.SELECTOR_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы избранного по клику на иконку в шапке")
    public void openFavoriteFromFavoriveTest() throws InterruptedException {
        open(IzyumData.Base.URL_FAVORITE);
        click(IzyumData.Base.SELECTOR_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы избранного по клику на иконку в шапке")
    public void openCartFromFavoriveTest() throws InterruptedException {
        open(IzyumData.Base.URL_FAVORITE);
        click(IzyumData.Base.SELECTOR_CART);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы корзины по клику на иконку в шапке")
    public void openCompareFromCartTest() throws InterruptedException {
        open(IzyumData.Base.URL_CART);
        click(IzyumData.Base.SELECTOR_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы корзины по клику на иконку в шапке")
    public void openFavoriteFromCartTest() throws InterruptedException {
        open(IzyumData.Base.URL_CART);
        click(IzyumData.Base.SELECTOR_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы корзины по клику на иконку в шапке")
    public void openCartFromCartTest() throws InterruptedException {
        open(IzyumData.Base.URL_CART);
        click(IzyumData.Base.SELECTOR_CART);
        assertEquals(getDriver().getCurrentUrl(), IzyumData.Base.URL_CART);
    }
}
