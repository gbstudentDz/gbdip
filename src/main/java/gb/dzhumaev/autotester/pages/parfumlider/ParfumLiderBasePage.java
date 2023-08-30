package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.common.Configuration;
import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static gb.dzhumaev.autotester.common.Configuration.CLICK_ATTEMPTS;
import static gb.dzhumaev.autotester.pages.parfumlider.ParfumLiderBasePageLocators.*;

public class ParfumLiderBasePage extends BasePage {
    public ParfumLiderBasePage(WebDriver driver) {
        super(driver);
    }

    private int indexOfAddedToFavorite = 0;
    private int indexOfAddedToCart = 0;

    public void goToFavorite() {
        waitElementIsClickableByLocator(FAVORITE_LOCATOR).click();
    }

    public void goToCart() {
        waitElementIsClickableByLocator(CART_LOCATOR).click();
    }

    public Boolean favoriteCounterIsPresent() {
        return driver.findElement(FAVORITE_COUNTER_LOCATOR).isDisplayed();
    }

    public Boolean cartCounterIsPresent() {
        return driver.findElement(CART_COUNTER_LOCATOR).isDisplayed();
    }

    public void addNextProductToFavorite() {
        String cssSelector = CARD_LOCATOR.toString()
                .replace("By.cssSelector: ", "")
                + ":nth-child(" + (++indexOfAddedToFavorite) + ")";
        By catalogCardLocatorWithPosinion = By.cssSelector(cssSelector);

        waitElementIsClickableByLocator(catalogCardLocatorWithPosinion)
                .findElement(FAVORITE_ON_CARD_LOCATOR)
                .click();
    }

    public void addNextProductToCart() {
        String cssSelector = CARD_LOCATOR.toString()
                .replace("By.cssSelector: ", "")
                + ":nth-child(" + (++indexOfAddedToCart) + ")";
        By catalogCardLocatorWithPosinion = By.cssSelector(cssSelector);

        waitElementIsClickableByLocator(catalogCardLocatorWithPosinion)
                .findElement(CART_ON_CARD_LOCATOR)
                .click();
    }

    public WebElement insertSearchQuery(String query) {
        WebElement element = waitElementIsClickableByLocator(INPUT_SEARCH_COMPRESSED_LOCATOR);
        element.click();
        element = waitElementIsClickableByLocator(INPUT_SEARCH_UNCOMPRESSED_LOCATOR);
        element.sendKeys(query);

        return element;
    }

    public void pressSearchButton() {
        waitElementIsClickableByLocator(BTN_SEARCH_LOCATOR).clear();
    }
}
