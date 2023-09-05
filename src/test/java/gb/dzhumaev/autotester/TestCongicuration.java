package gb.dzhumaev.autotester;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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

        WebDriverManager.getInstance(Configuration.BROWSER_NAME).setup();

        switch (Configuration.BROWSER_NAME) {
            case "chrome":
                driver = new EventFiringWebDriver(new ChromeDriver(configureChrome()));
                break;
            case "firefox":
                driver = new EventFiringWebDriver(new FirefoxDriver(configureFirefox()));
                break;
            default:
                throw new IllegalArgumentException("Incorrect browser name: " + Configuration.BROWSER_NAME);
        }

        driver.manage().window().maximize();
        driver.register(new RegisteringTestCongicuration());
        wait = new WebDriverWait(driver, Configuration.EXPLICIT_TIMEOUT);
        actions = new Actions(driver);
    }

    private static ChromeOptions configureChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));

        return chromeOptions;
    }

    private static FirefoxOptions configureFirefox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);

        FirefoxOptions options = new FirefoxOptions()
                .setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setBinary("C:\\Users\\dzhum\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        options.setProfile(profile);

        return options;
    }

    @BeforeAll
    public static void init() throws Exception {
        setUp();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }

    @AfterEach
    public void clearBrowser() {
        getDriver().manage().deleteAllCookies();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        javascriptExecutor.executeScript("window.localStorage.clear()");
        //getDriver().get("https://example.com");
    }
}
