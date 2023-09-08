package gb.dzhumaev.autotester;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static gb.dzhumaev.autotester.Configuration.TIMEOUT_AFTER_ACTION;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    @Step("Открытие страницы {url}")
    public static void open(String url) throws InterruptedException {
        TestCongicuration.getDriver().get(url);
        Thread.sleep(TIMEOUT_AFTER_ACTION.toMillis());
    }

    public static WebElement wait(By selector) {
        try {
            return TestCongicuration.getWait().until(visibilityOfElementLocated(selector));
        } catch (TimeoutException e) {
            return null;
        }
    }

    @Step("Клик на элемент: {si.name}")
    public static void click(SelectorInfo si) throws InterruptedException {
        WebElement element = wait(By.cssSelector(si.s()));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        element.click();
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
    }

    @Step("Клик на элемент: {si.name}")
    public static void tryClick(SelectorInfo si) throws InterruptedException {
        try {
            WebElement element = wait(By.cssSelector(si.s()));
            TestCongicuration.getActions().moveToElement(element);
            TestCongicuration.getActions().perform();
            element.click();
            sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        } catch (TimeoutException e) {
        }
    }

    @Step("Печать в {si.name}: {text}")
    public static void sendKeys(SelectorInfo si, String text) throws InterruptedException {
        WebElement input = wait(By.cssSelector(si.s()));
        input.click();
        input.sendKeys(text);
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
    }

    @Step("Нажатие ENTER")
    public static void sendEnter() throws InterruptedException {
        TestCongicuration.getActions().sendKeys(Keys.ENTER);
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
    }

    public static String getText(String selector) {
        return wait(By.cssSelector(selector)).getText();
    }

    public static String getText(String selector, String selectorParent) {
        selector = selectorParent + selector;
        return wait(By.cssSelector(selector)).getText();
    }

    public static String getAttribute(String selector, String attribute) {
        WebElement element = wait(By.cssSelector(selector));
        return element.getAttribute(attribute);
    }

    public static Double extractDouble(String s) {
        StringBuilder sb = new StringBuilder();
        boolean dotAlreadyAppend = false;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> sb.append(ch);
                case '.' -> {
                    if (!dotAlreadyAppend) {
                        sb.append(ch);
                        dotAlreadyAppend = true;
                    }
                }
                default -> {
                }
            }
        }

        return Double.parseDouble(sb.toString());
    }

    private static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
