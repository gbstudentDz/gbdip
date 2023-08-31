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

    @BeforeMethod
    public void preparePage() throws InterruptedException {
        Thread.sleep(5000);
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        BasePage page = new BasePage(driver);

        while (true) {
            try {
                final By CITY_NOTIFICATION_LOCATOR = By.cssSelector(".city-notification--active .city-notification__button--true");
                page.waitElementIsClickableByLocator(CITY_NOTIFICATION_LOCATOR).click();
                break;
            } catch (TimeoutException ignored) {}

            try {
                final By CITY_PICKER_ACTIVE_LOCATOR = By.cssSelector(".city-picker--active");
                WebElement cityPickerActiveElement = page.waitElementIsClickableByLocator(CITY_PICKER_ACTIVE_LOCATOR);
                WebElement parentOfCityPickerActiveElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", cityPickerActiveElement);
                parentOfCityPickerActiveElement.click();
            } catch (TimeoutException ignored) {}
            break;
        }

    }

    @AfterMethod(alwaysRun = true)
    public void clearCookiesAndStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @Test
    public void a_goToFavoriteTest() {
        goldenTimeBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_FAVORITE_URL);
    }

    @Test
    public void goToCartTest() {
        goldenTimeBasePage.goToCart();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_CART_URL);
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasNotFavoriteTest() {
        assertFalse(goldenTimeBasePage.favoriteCounterIsDisplayed());
    }

    @Test
    public void cartCounterIsDisplayedWhenHasNotFavoriteTest() {
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
        String query = "Query";
        WebElement inputElement = goldenTimeBasePage.insertSearchQuery(query);
        assertEquals(inputElement.getAttribute("value"), query);
    }

    @Test
    public void testPressSearchButton() throws InterruptedException {
        goldenTimeBasePage.activateSearch();
        Thread.sleep(20000);
        assertEquals(driver.getCurrentUrl(), "https://golden-time.ru/catalog/search/?q=");
    }
}