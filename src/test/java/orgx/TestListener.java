package orgx;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;

import static orgx.Configuration.BROWSER_NAME;
import static orgx.TestCongicuration.getDriver;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        doIt();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        doIt();
    }

    public void doIt() {
        Allure.getLifecycle().addAttachment(
                "Скриншот", "image/png", "png",
                ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)
        );

        Allure.addAttachment("Логи", String.valueOf(getDriver().manage().logs().get(LogType.BROWSER).getAll()));
        //WebDriverManager.chromedriver().quit();
        WebDriverManager.getInstance(BROWSER_NAME).quit();
        TestCongicuration.quit();
    }
}
