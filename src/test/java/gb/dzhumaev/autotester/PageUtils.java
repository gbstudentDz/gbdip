package gb.dzhumaev.autotester;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    @Step("Ожидание элемента {0}")
    private static void wait(By locator) {
        TestCongicuration.getWait().until(visibilityOfElementLocated(locator));
    }

    @Step("Клик на элемент")
    public static void click(By locator, int afterDelayOfSeconds) throws InterruptedException {
        wait(locator);
        WebElement element = TestCongicuration.getDriver().findElement(locator);
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(afterDelayOfSeconds);
    }

    private static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
