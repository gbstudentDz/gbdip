package gb.dzhumaev.autotester;

import freemarker.template.TemplateHashModelEx2;
import io.qameta.allure.Step;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.*;

import java.util.ArrayList;

import static gb.dzhumaev.autotester.Configuration.TIMEOUT_AFTER_ACTION;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    private static String lastClickedElementName = "";

    @Step("Открытие страницы {0}")
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

    private static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Step
    public static WebElement click(SelectorInfo si) throws InterruptedException {
        WebElement element = wait(By.cssSelector(si.s()));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        lastClickedElementName = si.n();
        element.click();
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        return element;
    }

    @Step
    public static WebElement click(SelectorInfo si, SelectorInfo siP) throws InterruptedException {
        si = new SelectorInfo(siP.s() + si.s(), si.n());// selectorParent + si.s();
        WebElement element = wait(By.cssSelector(si.s()));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        lastClickedElementName = si.n();
        element.click();
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        return element;
    }

    @Step
    public static WebElement tryClick(SelectorInfo si) throws InterruptedException {
        try {
            WebElement element = wait(By.cssSelector(si.s()));
            TestCongicuration.getActions().moveToElement(element);
            TestCongicuration.getActions().perform();
            lastClickedElementName = si.n();
            element.click();
            sleep(TIMEOUT_AFTER_ACTION.toSeconds());
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
        WebElement element = wait(By.cssSelector(selector));
        return element.getAttribute(attribute);
    }

    public static WebElement sendKeys(String selector, String text) throws InterruptedException {
        WebElement input = wait(By.cssSelector(selector));
        input.click();
        input.sendKeys(text);
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        return input;
    }

    public static void sendEnter() throws InterruptedException {
        TestCongicuration.getActions().sendKeys(Keys.ENTER);
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
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

    public static void t() {
    }

    public static String getLastClickedElementName() {
        return lastClickedElementName;
    }
}
