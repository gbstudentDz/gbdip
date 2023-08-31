package gb.dzhumaev.autotester.pages.goldentime;

import org.openqa.selenium.WebDriver;

import static gb.dzhumaev.autotester.pages.goldentime.GoldenTimeLocators.BasePage.CART_COUNTER;
import static gb.dzhumaev.autotester.pages.goldentime.GoldenTimeLocators.CartPage.*;

public class GoldenTimeCartPage extends GoldenTimeBasePage {

    public GoldenTimeCartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartCounterValue() {
        return waitElementIsClickableByLocator(CART_COUNTER).getText();
    }

    public int getBasketItemsCount() {
        return driver.findElements(BASKET_ITEM).size();
    }

    public String getBasketItemAmountFiledValue() {
        return waitElementIsClickableByLocator(BASKET_ITEM_AMOUNT_FILED).getAttribute("value");
    }

    public void pushPlusOnBasketItem() {
        waitElementIsClickableByLocator(BASKET_ITEM_AMOUNT_BTN_PLUS).click();
    }

    public void pushMinusOnBasketItem() {
        waitElementIsClickableByLocator(BASKET_ITEM_AMOUNT_BTN_MINUS).click();
    }

    public Double getBasketItemPrice() {
        String s = waitElementIsClickableByLocator(BASKET_ITEM_PRICE)
                .getText()
                .replace("руб", "")
                .replace(" ", "");
        return Double.parseDouble(s);
    }

    public Double getFinalPrice() {
        String s = waitElementIsClickableByLocator(FINAL_ITEM_PRICE)
                .getText()
                .replace("руб", "")
                .replace(" ", "");
        return Double.parseDouble(s);
    }





}
