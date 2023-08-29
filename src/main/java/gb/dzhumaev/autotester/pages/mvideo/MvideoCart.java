package gb.dzhumaev.autotester.pages.mvideo;

import gb.dzhumaev.autotester.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MvideoCart extends BasePage {

    public MvideoCart(WebDriver driver) {
        super(driver);
    }

    private final By priceMainValue = By.className("price__main-value");

    public double getPriceMainValue() {
        WebElement element = driver.findElement(priceMainValue);
        return Double.parseDouble(waitElementIsVisible(element).getText());
    }
}
