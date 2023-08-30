package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.Format;

public class ParfumLiderBasePage extends BasePage {
    public ParfumLiderBasePage(WebDriver driver) {
        super(driver);
    }

    private int indexOfProductAddedToFavorite = 0;
    private int indexOfProductAddedToCart = 0;
    private final By inputSearchLocator = By.className("search-main__input");
    private final By btnSearchLocator = By.className("btn--search");
    private final By blockFavoriteLocator = By.className("block-favorite");
    private final By blockCartLocator = By.className("block-cart");
    private final By blockCatalogMenuLocator = By.className("block-catalog-menu");
    private final By blockFavoriteCounterLocator = By.cssSelector(".block-favorite>a>.js-favorite-col");
    private final By blockCartCounterLocator = By.cssSelector(".block-cart>a>.js-basket-col");
    private final By catalogCardLocator = By.cssSelector(".catalog-card");
    private final By favoriteIconOnProductCardLocator = By.className("favorite-icon");
    private final By cartIconOnProductCardLocator = By.className("js-buy-block");

    public ParfumLiderBasePage goToFavorite() {
        _waitElementIsVisibleByLocator(blockFavoriteLocator).click();

        return this;
    }

    public ParfumLiderBasePage goToCart() {
        _waitElementIsVisibleByLocator(blockCartLocator).click();

        return this;
    }

    public Boolean favoriteCounterIsPresent() {
        return driver.findElement(blockFavoriteCounterLocator).isDisplayed();
    }

    public Boolean cartCounterIsPresent() {
        return driver.findElement(blockCartCounterLocator).isDisplayed();
    }

    public ParfumLiderBasePage addNextProductToFavorite() {
        String cssSelector = catalogCardLocator.toString()
                .replace("By.cssSelector: ", "")
                + ":nth-child(" + (++indexOfProductAddedToFavorite) + ")";
        By catalogCardLocatorWithPosinion = By.cssSelector(cssSelector);

        _waitElementIsVisibleByLocator(catalogCardLocatorWithPosinion)
                .findElement(favoriteIconOnProductCardLocator)
                .click();

        return this;
    }

    public ParfumLiderBasePage addNextProductToCart() {
        String cssSelector = catalogCardLocator.toString()
                .replace("By.cssSelector: ", "")
                + ":nth-child(" + (++indexOfProductAddedToCart) + ")";
        By catalogCardLocatorWithPosinion = By.cssSelector(cssSelector);

        _waitElementIsVisibleByLocator(catalogCardLocatorWithPosinion)
                .findElement(cartIconOnProductCardLocator)
                .click();

        return this;
    }

    public int getFavoriteCount() {
        return Integer.parseInt(driver.findElement(blockFavoriteCounterLocator).getText());
    }

    public int getCartCount() {
        return Integer.parseInt(driver.findElement(blockCartCounterLocator).getText());
    }

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
}
