package UI.PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Configuration.PLATFORM_AND_BROWSER;

public class EventFiringWebDriverBuilder {
    public static WebDriverWait wait;
    public static Actions actions;
    private static EventFiringWebDriver driver;

    public static EventFiringWebDriver create() {
        switch (PLATFORM_AND_BROWSER) {
            case "WINDOWS_CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("window-size=1920, 1080");
                driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
                driver.manage().window().maximize();
                driver.register(new Custom(driver));
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                actions = new Actions(driver);
                break;
            case "WINDOWS_FIREFOX":
                break;
            default:
                //Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }

        return driver;
    }
}
