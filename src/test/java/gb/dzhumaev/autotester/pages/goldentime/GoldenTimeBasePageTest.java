package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BasePage;
import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.common.Configuration.CLEAR_COOKIES;
import static gb.dzhumaev.autotester.pages.goldentime.Urls.*;
import static org.testng.Assert.*;

public class GoldenTimeBasePageTest extends BaseTest {
    GoldenTimeBasePage goldenTimeBasePage = new GoldenTimeBasePage(driver);

    @Test
    public void a_goToFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        goldenTimeBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_FAVORITE_URL);
    }

    @Test
    public void goToCartTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        goldenTimeBasePage.goToCart();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_CART_URL);
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasNotFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        assertFalse(goldenTimeBasePage.favoriteCounterIsDisplayed());
    }

    @Test
    public void cartCounterIsDisplayedWhenHasNotFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        assertFalse(goldenTimeBasePage.cartCounterIsDisplayed());
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasFavoriteTest() {
        driver.get(GOOD_1_AVAILABLE_TO_SALE_URL);
        goldenTimeBasePage.addGoodToFavorite();
        assertTrue(goldenTimeBasePage.favoriteCounterIsDisplayed());
    }

    @Test()
    public void b_testCartCounterWhenGoodAddedToCart() {
        driver.get(GOOD_1_AVAILABLE_TO_SALE_URL);
        goldenTimeBasePage.addGoodToCart();
        assertTrue(goldenTimeBasePage.cartCounterIsDisplayed());
    }

    @Test
    public void testInsertSearchQuery() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        String query = "Query";
        WebElement inputElement = goldenTimeBasePage.insertSearchQuery(query);
        assertEquals(inputElement.getAttribute("value"), query);
    }

    @Test
    public void testPressSearchButton() throws InterruptedException {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        goldenTimeBasePage.activateSearch();
        Thread.sleep(20000);
        assertEquals(driver.getCurrentUrl(), "https://golden-time.ru/catalog/search/?q=");
    }
}