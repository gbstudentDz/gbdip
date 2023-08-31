package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.pages.goldentime.Urls.*;
import static org.testng.Assert.*;

public class GoldenTimeBasePageTest extends BaseTest {
    private GoldenTimeBasePage page = new GoldenTimeBasePage(driver);

    @Test
    public void goToFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        page.goToFavorite();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_FAVORITE_URL);
    }

    @Test
    public void goToCartTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        page.goToCart();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_CART_URL);
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasNotFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        assertFalse(page.favoriteCounterIsDisplayed());
    }

    @Test
    public void cartCounterIsDisplayedWhenHasNotFavoriteTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        assertFalse(page.cartCounterIsDisplayed());
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasFavoriteTest() {
        driver.get(PRODUCT_FOR_SALE_1);
        page.addProductToFavorite();
        assertTrue(page.favoriteCounterIsDisplayed());
    }

    @Test()
    public void cartCounterIsDisplayedWhenHasFavoriteTest() {
        driver.get(PRODUCT_FOR_SALE_1);
        page.addProductToCart();
        assertTrue(page.cartCounterIsDisplayed());
    }

    @Test
    public void insertSearchQueryTest() {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        String query = "Query";
        WebElement inputElement = page.insertSearchQuery(query);
        assertEquals(inputElement.getAttribute("value"), query);
    }

    @Test
    public void activateSearchTest() throws InterruptedException {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        page.activateSearch();
        Thread.sleep(20000);
        assertEquals(driver.getCurrentUrl(), "https://golden-time.ru/catalog/search/?q=");
    }
}