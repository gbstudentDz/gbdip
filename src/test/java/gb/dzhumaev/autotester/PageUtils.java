package gb.dzhumaev.autotester;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static gb.dzhumaev.autotester.Configuration.TIMEOUT_AFTER_LOAD_PAGE;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    public static void open(String url) throws InterruptedException {
        TestCongicuration.getDriver().get(url);
        Thread.sleep(TIMEOUT_AFTER_LOAD_PAGE.toMillis());
    }

    @Step("Ожидание элемента {0}")
    public static void wait(By locator) {
        TestCongicuration.getWait().until(visibilityOfElementLocated(locator));
    }

    private static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
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

    public static By joinLocators(By... locators) {
        StringBuilder cssSelector = new StringBuilder();
        for (By locator : locators
        ) {
            cssSelector.append(" ")
                    .append(locator.toString().replace("By.cssSelector: ", ""));
        }

        return By.cssSelector(cssSelector.toString().trim());
    }
}
