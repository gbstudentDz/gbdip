package gb.dzhumaev.autotester;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class TestCongicuration {
    private static EventFiringWebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    public static EventFiringWebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static Actions getActions() {
        return actions;
    }

    private static void setUp() throws Exception {
        switch (Configuration.BROWSER_NAME) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new EventFiringWebDriver(new ChromeDriver(configureChrome()));
                driver.manage().window().maximize();
                driver.register(new RegisteringTestCongicuration());
                break;
            default:
                throw new IllegalArgumentException("Incorrect browser name: " + Configuration.BROWSER_NAME);
        }

        wait = new WebDriverWait(driver, Configuration.EXPLICIT_TIMEOUT);
        actions = new Actions(driver);
    }
    private static ChromeOptions configureChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);

        return chromeOptions;
    }

    @BeforeAll
    public static void init() throws Exception {
        setUp();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
