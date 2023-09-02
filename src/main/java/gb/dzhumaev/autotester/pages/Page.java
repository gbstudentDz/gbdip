package gb.dzhumaev.autotester.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

import static gb.dzhumaev.autotester.common.Configuration.EXPLICIT_WAIT_OF_SECONDS;

public class Page {

    private WebDriver driver = null;
    private WebElement lastCashedElement = null;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElementIsClickableByLocator(By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_OF_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(locator));
        lastCashedElement = element;
        return element;
    }

    public WebElement getLastCashedElement() {
        return lastCashedElement;
    }


}
