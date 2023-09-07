package gb.dzhumaev.autotester;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "Скриншот", "image/png", "png",
                ((TakesScreenshot) TestCongicuration.getDriver()).getScreenshotAs(OutputType.BYTES)
        );
        Allure.addAttachment("Логи", String.valueOf(TestCongicuration.getDriver().manage().logs().get(LogType.BROWSER).getAll()));
        WebDriverManager.getInstance(Configuration.BROWSER_NAME).quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.addAttachment("Логи", String.valueOf(TestCongicuration.getDriver().manage().logs().get(LogType.BROWSER).getAll()));
        WebDriverManager.getInstance(Configuration.BROWSER_NAME).quit();
    }
}
