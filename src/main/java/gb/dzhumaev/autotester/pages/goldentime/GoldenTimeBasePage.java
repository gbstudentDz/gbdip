package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static gb.dzhumaev.autotester.pages.goldentime.Locators.GoldenTimeLocators.*;

public class GoldenTimeBasePage extends BasePage {
    public GoldenTimeBasePage(WebDriver driver) {
        super(driver);
    }

    public void goToFavorite() {
        waitElementIsClickableByLocator(FAVORITE_LOCATOR).click();
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

    public void addGoodToFavorite() {
        waitElementIsClickableByLocator(CARD_LOCATOR).click();
        waitElementIsClickableByLocator(ADD_TO_FAVORITE_LOCATOR).click();

    }

    public void addGoodToCart() {
        waitElementIsClickableByLocator(CARD_LOCATOR).click();
        waitElementIsClickableByLocator(ADD_TO_CART_LOCATOR).click();
    }

    public WebElement insertSearchQuery(String query) {
        WebElement element = waitElementIsClickableByLocator(SEARCH_INPUT);
        new Actions(driver).moveToElement(element).click().perform();
        element.sendKeys(query);

        return element;
    }

    public void activateSearch() {
        WebElement element = waitElementIsClickableByLocator(SEARCH_INPUT);
        new Actions(driver).moveToElement(element).click().perform();
        element.sendKeys(Keys.ENTER);
    }
}
