package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static gb.dzhumaev.autotester.pages.parfumlider.ParfumLiderBasePageLocators.*;

public class ParfumLiderBasePage extends BasePage {
    public ParfumLiderBasePage(WebDriver driver) {
        super(driver);
    }

    public void goToFavorite() {
        waitElementIsClickableByLocator(FAVORITE_LOCATOR).click();
    }

    public void goToCart() {
        waitElementIsClickableByLocator(CART_LOCATOR).click();
    }

    public Boolean favoriteCounterIsDisplayed() {
        return waitElementIsClickableByLocator(FAVORITE_COUNTER_LOCATOR).isDisplayed();
    }

    public Boolean cartCounterIsDisplayed() {
        return waitElementIsClickableByLocator(CART_COUNTER_LOCATOR).isDisplayed();
    }

    public void addGoodToFavorite() {
        waitElementIsClickableByLocator(FAVORITE_ON_CARD_LOCATOR).click();
    }

    public void addGoodToCart() {
        waitElementIsClickableByLocator(CART_ON_CARD_LOCATOR).click();
        try {
            final By ADD_TO_CART_IN_POPUP_LOCATOR = By.cssSelector(".mfp-content .add-to-cart");
            final By CLOSE_POPUP_LOCATOR = By.cssSelector(".mfp-content .mfp-close");
            waitElementIsClickableByLocator(ADD_TO_CART_IN_POPUP_LOCATOR).click();
            waitElementIsClickableByLocator(CLOSE_POPUP_LOCATOR).click();
        } catch (TimeoutException ignored) {}
    }

    public WebElement insertSearchQuery(String query) {
        waitElementIsClickableByLocator(SEARCH_BLOCK_COLLAPSED_LOCATOR).click();
        WebElement inputElement = driver.findElement(SEARCH_POPUP_INPUT_LOCATOR);
                // waitElementIsClickableByLocator(SEARCH_POPUP_INPUT_LOCATOR);
        inputElement.click();
        inputElement.sendKeys(query);

        return inputElement;
    }

    public void pressSearchButton() {
        waitElementIsClickableByLocator(SEARCH_POPUP_SUBMIT_BUTTON_LOCATOR).clear();
    }
}
