package gb.dzhumaev.autotester;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static gb.dzhumaev.autotester.Configuration.TIMEOUT_AFTER_LOAD_PAGE;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    @Step("Открытие страницы {0}")
    public static void open(String url) throws InterruptedException {
        TestCongicuration.getDriver().get(url);
        Thread.sleep(TIMEOUT_AFTER_LOAD_PAGE.toMillis());
    }

    public static void wait(By locator) {
        TestCongicuration.getWait().until(visibilityOfElementLocated(locator));
    }
    private static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Step("Клик на элемент")
    public static WebElement click(By locator) throws InterruptedException {
        wait(locator);
        WebElement element = TestCongicuration.getDriver().findElement(locator);
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(TIMEOUT_AFTER_LOAD_PAGE.toSeconds());

        return element;
    }

    @Step("Клик на элемент")
    public static WebElement click(By locator, long afterDelayOfSeconds) throws InterruptedException {
        wait(locator);
        WebElement element = TestCongicuration.getDriver().findElement(locator);
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(afterDelayOfSeconds);

        return element;
    }

    public static String getText(By locator) {
        return TestCongicuration.getDriver().findElement(locator).getText();
    }

    public static String getText(WebElement element) {
        return element.getText();
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
