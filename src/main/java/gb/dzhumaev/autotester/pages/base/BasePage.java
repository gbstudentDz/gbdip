package gb.dzhumaev.autotester.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static gb.dzhumaev.autotester.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisibleByLocator(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitElementsIsVisibleByLocator(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
