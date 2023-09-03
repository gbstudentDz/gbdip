package orgx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class TestCongicuration {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void setUp() throws Exception {
        switch (Configuration.BROWSER) {
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                setUpChrome(driver);
                break;
            default:
                throw new Exception("bad browser");
        }

        wait = new WebDriverWait(driver, Configuration.EXPLICIT_TIMEOUT);
        actions = new Actions(driver);
    }
    private static void  setUpChrome(WebDriver driver) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("window-size=1920, 1080");

        driver.manage().window().maximize();
        // driver.register(new Custom());

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
