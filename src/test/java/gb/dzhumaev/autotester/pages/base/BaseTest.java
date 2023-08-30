package gb.dzhumaev.autotester.pages.base;

import gb.dzhumaev.autotester.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static gb.dzhumaev.autotester.common.Configuration.CLEAR_COOKIES;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);


    @BeforeMethod
    public void switchToNextTab() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void clearCookiesAndStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            //javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}