package gb.dzhumaev.autotester.pages.base;

import gb.dzhumaev.autotester.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);

    @BeforeMethod
    public void prepareWindow() throws InterruptedException {
        //driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.manage().deleteAllCookies();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        javascriptExecutor.executeScript("window.localStorage.clear()");
        driver.quit();
    }
}