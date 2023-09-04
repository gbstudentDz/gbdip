package orgx;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static orgx.TestCongicuration.*;

public class PageUtils {

    @Step("Ожидание элемента {0}")
    public void wait(By locator) {
        getWait().until(visibilityOfElementLocated(locator));
    }

    @Step("Клик на элемент")
    public void click(By locator, int afterDelayOfSeconds) throws InterruptedException {
        wait(locator);
        WebElement element = getDriver().findElement(locator);
        getActions().moveToElement(element);
        getActions().perform();
        element.click();
        sleep(afterDelayOfSeconds);
    }

    private void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
