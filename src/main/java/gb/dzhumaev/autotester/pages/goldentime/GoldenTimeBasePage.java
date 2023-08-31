package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static gb.dzhumaev.autotester.pages.goldentime.GoldenTimeLocators.BasePage.*;

public class GoldenTimeBasePage extends BasePage {
    public GoldenTimeBasePage(WebDriver driver) {
        super(driver);
    }

    public void goToFavorite() {
        waitElementIsClickableByLocator(FAVORITE_LOCATOR).click();
        System.out.println();
    }

    public void goToCart() {
        waitElementIsClickableByLocator(CART_LOCATOR).click();
    }

    public Boolean favoriteCounterIsDisplayed() {
        try {
            waitElementIsClickableByLocator(FAVORITE_COUNTER_LOCATOR);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean cartCounterIsDisplayed() {
        try {
            waitElementIsClickableByLocator(CART_COUNTER_LOCATOR);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void addProductToFavorite() {
        waitElementIsClickableByLocator(ADD_TO_FAVORITE_LOCATOR).click();

    }

    public void addProductToCart() {
        waitElementIsClickableByLocator(ADD_TO_CART_LOCATOR).click();
    }

    public WebElement insertSearchQuery(String query) {
        try {
            final By CITY_NOTIFICATION_LOCATOR =
                    By.cssSelector(".city-notification--active .city-notification__button--true");
            waitElementIsClickableByLocator(CITY_NOTIFICATION_LOCATOR).click();
        } catch (TimeoutException ignored) {}

        WebElement element = waitElementIsClickableByLocator(SEARCH_INPUT);
        new Actions(driver).moveToElement(element).click().perform();
        element.sendKeys(query);

        return element;
    }

    public void activateSearch() throws InterruptedException {
        try {
            final By CITY_NOTIFICATION_LOCATOR =
                    By.cssSelector(".city-notification--active .city-notification__button--true");
            waitElementIsClickableByLocator(CITY_NOTIFICATION_LOCATOR).click();
        } catch (TimeoutException ignored) {}

        WebElement element = waitElementIsClickableByLocator(SEARCH_INPUT);
        new Actions(driver).moveToElement(element).click().perform();
        element.sendKeys(Keys.ENTER);
    }
}
