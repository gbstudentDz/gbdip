package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.TestCongicuration;
import gb.dzhumaev.autotester.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static gb.dzhumaev.autotester.PageUtils.click;
import static gb.dzhumaev.autotester.PageUtils.open;
import static gb.dzhumaev.autotester.izumclub.Selectors.*;
import static gb.dzhumaev.autotester.izumclub.Urls.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование UI сайта " + URL_HOME)
@Feature("Переходы по основным разделам")
@ExtendWith(TestListener.class)
public class SitePageTransitionsTest extends TestCongicuration {

    @Test
    @DisplayName("Открытие главной страницы")
    public void openHomepage() throws InterruptedException {
        open(URL_HOME);
        assertEquals(getDriver().getCurrentUrl(), URL_HOME);
    }

    /*@Test
    @DisplayName("Открытие страницы сравнения")
    public void openCompare() throws InterruptedException {
        open(URL_COMPARE);
        assertEquals(getDriver().getCurrentUrl(), URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного")
    public void openFavorite() throws InterruptedException {
        open(URL_FAVORITE);
        assertEquals(getDriver().getCurrentUrl(), URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины")
    public void openCart() throws InterruptedException {
        open(URL_CART);
        assertEquals(getDriver().getCurrentUrl(), URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения с главной по клику на иконку в шапке")
    public void openCompareFromHomePageTest() throws InterruptedException {
        open(URL_HOME);
        click(COMPARE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного с главной по клику на иконку в шапке")
    public void openFavoriteFromHomePageTest() throws InterruptedException {
        open(URL_HOME);
        click(FAVORITE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины с главной по клику на иконку в шапке")
    public void openCartFromHomePageTest() throws InterruptedException {
        open(URL_HOME);
        click(CART_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы сравнения по клику на иконку в шапке")
    public void openCompareFromCompareTest() throws InterruptedException {
        open(URL_COMPARE);
        click(COMPARE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы сравнения по клику на иконку в шапке")
    public void openFavoriteFromCompareTest() throws InterruptedException {
        open(URL_COMPARE);
        click(FAVORITE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы сравнения по клику на иконку в шапке")
    public void openCartFromCompareTest() throws InterruptedException {
        open(URL_COMPARE);
        click(CART_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы избранного по клику на иконку в шапке")
    public void openCompareFromFavoriveTest() throws InterruptedException {
        open(URL_FAVORITE);
        click(COMPARE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы избранного по клику на иконку в шапке")
    public void openFavoriteFromFavoriveTest() throws InterruptedException {
        open(URL_FAVORITE);
        click(FAVORITE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы избранного по клику на иконку в шапке")
    public void openCartFromFavoriveTest() throws InterruptedException {
        open(URL_FAVORITE);
        click(CART_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_CART);
    }

    // ---

    @Test
    @DisplayName("Открытие страницы сравнения со страницы корзины по клику на иконку в шапке")
    public void openCompareFromCartTest() throws InterruptedException {
        open(URL_CART);
        click(COMPARE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_COMPARE);
    }

    @Test
    @DisplayName("Открытие страницы избранного со страницы корзины по клику на иконку в шапке")
    public void openFavoriteFromCartTest() throws InterruptedException {
        open(URL_CART);
        click(FAVORITE_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_FAVORITE);
    }

    @Test
    @DisplayName("Открытие страницы корзины со страницы корзины по клику на иконку в шапке")
    public void openCartFromCartTest() throws InterruptedException {
        open(URL_CART);
        click(CART_ON_TOP_MENU_LINE);
        assertEquals(getDriver().getCurrentUrl(), URL_CART);
    }*/
}
