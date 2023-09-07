package gb.dzhumaev.autotester;

import org.openqa.selenium.*;


import static gb.dzhumaev.autotester.Configuration.TIMEOUT_AFTER_ACTION;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    private static String lastInvolvedElementName;
    private static String lastOpenedUrl;
    private static String lastInsertedText;

    //@Step("Открытие страницы {0}")
    public static void open(String url) throws InterruptedException {
        lastOpenedUrl = url;
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

    //@Step
    public static WebElement click(SelectorInfo si) throws InterruptedException {
        WebElement element = wait(By.cssSelector(si.s()));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        lastInvolvedElementName = si.n();
        element.click();
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        return element;
    }

    //@Step
    public static WebElement click(SelectorInfo si, SelectorInfo siP) throws InterruptedException {
        si = new SelectorInfo(siP.s() + si.s(), si.n());// selectorParent + si.s();
        WebElement element = wait(By.cssSelector(si.s()));
        TestCongicuration.getActions().moveToElement(element);
        TestCongicuration.getActions().perform();
        lastInvolvedElementName = si.n();
        element.click();
        sleep(TIMEOUT_AFTER_ACTION.toSeconds());
        return element;
    }

    //@Step
    public static WebElement tryClick(SelectorInfo si) throws InterruptedException {
        try {
            WebElement element = wait(By.cssSelector(si.s()));
            TestCongicuration.getActions().moveToElement(element);
            TestCongicuration.getActions().perform();
            lastInvolvedElementName = si.n();
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

    public static WebElement sendKeys(SelectorInfo si, String text) throws InterruptedException {
        WebElement input = wait(By.cssSelector(si.s()));
        lastInvolvedElementName = si.n();
        input.click();
        lastInsertedText = text;
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

    //

    public static String getLastInvolvedElementName() {
        return lastInvolvedElementName;
    }

    public static String getLastOpenedUrl() {
        return lastOpenedUrl;
    }

    public static String getLastInsertedText() {
        return lastInsertedText;
    }
}
