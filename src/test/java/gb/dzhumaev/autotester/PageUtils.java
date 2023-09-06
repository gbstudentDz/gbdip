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

    public static WebElement wait(By selector) {
        try {
            return TestCongicuration.getWait().until(visibilityOfElementLocated(selector));
        } catch (TimeoutException e) {
            return null;
        }
    }

    private static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Step("Клик на элемент")
    public static WebElement click(String selector) throws InterruptedException {
        WebElement element = wait(By.cssSelector(selector));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(TIMEOUT_AFTER_LOAD_PAGE.toSeconds());

        return element;
    }

    @Step("Клик на элемент")
    public static WebElement click(String selector, String selectorParent) throws InterruptedException {
        selector = selectorParent + selector;
        WebElement element = wait(By.cssSelector(selector));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(TIMEOUT_AFTER_LOAD_PAGE.toSeconds());

        return element;
    }

    @Step("Клик на элемент (если существует)")
    public static WebElement tryClick(String selector) throws InterruptedException {
        try {
            WebElement element = wait(By.cssSelector(selector));
            TestCongicuration.getActions().moveToElement(element);
            TestCongicuration.getActions().perform();
            element.click();
            sleep(TIMEOUT_AFTER_LOAD_PAGE.toSeconds());

            return element;
        } catch (TimeoutException e) {
            return null;
        }
    }

    public static String getText(String selector) {
        return wait(By.cssSelector(selector)).getText();
    }

    public static String getText(String selector, String selectorParent) {
        selector = selectorParent + selector;
        return wait(By.cssSelector(selector)).getText();
    }

    public static String getAttribute(String selector,String attribute) {
        return wait(By.cssSelector(selector)).getAttribute(attribute);
    }

    public static String joinSelectors(String... selectors) {
        StringBuilder cssSelector = new StringBuilder();
        
        for (String selector : selectors
        ) {
            cssSelector.append(selector);
        }

        return cssSelector.toString();
    }
}
