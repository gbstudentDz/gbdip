package UI.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {
    private final StubForReturningPageUtils pu = new StubForReturningPageUtils();
    private static EventFiringWebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public PageUtils(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public static EventFiringWebDriver getDriver() {
        return driver;
    }

    // @Step("Ожидание появления эдемента {0}")
    public WebElementAdvanced waitElement(By locator) {
        return new WebElementAdvanced(wait.until(visibilityOfElementLocated(locator)));
    }

    // @Step("Ожидание появления эдемента {0}")
    public PageUtils waitElement(By locator, StubForReturningPageUtils stubForReturningPageUtils) {
        wait.until(visibilityOfElementLocated(locator));
        return this;
    }

    // @Step("Нажимаем на элемент")
    public void clickElement(By locator) {
        waitElement(locator)
                .findElement(locator)
                .moveToElement(driver)
                .perform(driver)
                .click();
    }
}
