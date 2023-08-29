package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ParfumLiderBasePage extends BasePage {
    public ParfumLiderBasePage(WebDriver driver) {
        super(driver);
    }

    private int indexOfProductAddedToFavorite = -1;
    private int indexOfProductAddedToCart = -1;
    private final By inputSearchLocator = By.className("search-main__input");
    private final By btnSearchLocator = By.className("btn--search");
    private final By blockFavoriteLocator = By.className("block-favorite");
    private final By blockCartLocator = By.className("block-cart");
    private final By blockCatalogMenuLocator = By.className("block-catalog-menu");
    private final By blockFavoriteCounterLocator = By.cssSelector(".block-favorite>a>.js-favorite-col");
    private final By blockCartCounterLocator = By.cssSelector(".block-cart>a>.js-basket-col");
    private final By productsListingLocator = By.className("catalog-card");
    private final By favoriteIconOnProductCardLocator = By.className("favorite-icon");
    private final By cartIconOnProductCardLocator = By.className("js-buy-block");

    public ParfumLiderBasePage insertSearchQuery(String query) {
        driver.findElement(inputSearchLocator).clear();
        driver.findElement(inputSearchLocator).sendKeys(query);

        return this;
    }

    public ParfumLiderBasePage pressSearchButton() {
        driver.findElement(btnSearchLocator)
                .click();

        return this;
    }

    public ParfumLiderBasePage goToFavorite() {
        driver.findElement(blockFavoriteLocator).click();

        return this;
    }

    public ParfumLiderBasePage goToCart() {
        driver.findElement(blockCartLocator).click();

        return this;
    }

    public ParfumLiderBasePage addProductToFavorite() {
        driver.findElements(productsListingLocator)
                .get(++indexOfProductAddedToFavorite)
                .findElement(favoriteIconOnProductCardLocator)
                .click();

        return this;
    }

    public ParfumLiderBasePage addProductToCart() {
        driver.findElements(productsListingLocator)
                .get(++indexOfProductAddedToCart)
                .findElement(cartIconOnProductCardLocator)
                .click();

        return this;
    }

    public Boolean favoriteCounterIsPresent() {
        return driver.findElement(blockFavoriteCounterLocator).isDisplayed();
    }

    public Boolean cartCounterIsPresent() {
        return driver.findElement(blockCartCounterLocator).isDisplayed();
    }

    public int getFavoriteCount() {
        return Integer.parseInt(driver.findElement(blockFavoriteCounterLocator).getText());
    }

    public int getCartCount() {
        return Integer.parseInt(driver.findElement(blockCartCounterLocator).getText());
    }
}
