package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private final By productsListingLocator = By.className("owl-item");
    private final By favoriteIconOnProductCardLocator = By.className("js-favorite-icon");
    private final By cartIconOnProductCardLocator = By.className("js-buy-block");

    public void insertSearchQuery(String query) {
        driver.findElement(inputSearchLocator).clear();
        driver.findElement(inputSearchLocator).sendKeys(query);
    }

    public void pressSearchButton() {
        driver.findElement(btnSearchLocator).click();
    }

    public void goToFavorite() {
        driver.findElement(blockFavoriteLocator).click();
    }

    public void goToCart() {
        driver.findElement(blockCartLocator).click();
    }

    public Boolean favoriteCounterExists() {
        return !driver.findElements(blockFavoriteCounterLocator).isEmpty();
    }

    public Boolean cartCounterExists() {
        return !driver.findElements(blockCartCounterLocator).isEmpty();
    }

    public int getFavoriteCount() {
        return Integer.parseInt(driver.findElement(blockFavoriteCounterLocator).getText());
    }

    public int getCartCount() {
        return Integer.parseInt(driver.findElement(blockCartCounterLocator).getText());
    }

    public WebElement getProductCard() {
        return driver.findElement(productsListingLocator)
    }

    public void addProductToFavorite() {
        WebElement element = driver.findElements(productsListingLocator).get(++indexOfProductAddedToFavorite);
        element.findElement(favoriteIconOnProductCardLocator).click();
    }

    public void addProductToCart() {
        WebElement element = driver.findElements(cartIconOnProductCardLocator).get(++indexOfProductAddedToCart);
        element.findElement(favoriteIconOnProductCardLocator).click();
    }


}
