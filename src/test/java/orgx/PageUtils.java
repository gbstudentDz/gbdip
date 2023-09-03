package orgx;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public PageUtils(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    @Step("Ожидание появления эдемента {0}")
    public void wait(By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    @Step("Нажимаем на элемент")
    public void click(By locator, int afterDelayOfSeconds) throws InterruptedException {
        wait(locator);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element);
        actions.perform();
        element.click();
        sleep(afterDelayOfSeconds);
    }

    @Step("Ввод текста под Shadow root")
    public void inputWord(WebElement element, String word) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+word+"'", element);
        element.sendKeys(Keys.BACK_SPACE);
    }

    private void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
