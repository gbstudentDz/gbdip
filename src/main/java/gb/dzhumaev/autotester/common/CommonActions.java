package gb.dzhumaev.autotester.common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import static gb.dzhumaev.autotester.common.Configuration.PLATFORM_AND_BROWSER;
import static gb.dzhumaev.autotester.common.Configuration.WINDOW_POSITION;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "WINDOWS_CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "WINDOWS_FIREFOX":
                FirefoxOptions options = new FirefoxOptions()
                        .setPageLoadStrategy(PageLoadStrategy.NORMAL);
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.cache.disk.enable", false);
                profile.setPreference("browser.cache.memory.enable", false);
                profile.setPreference("browser.cache.offline.enable", false);
                profile.setPreference("network.http.use-cache", false);
                options.setProfile(profile);
                driver = new FirefoxDriver(options);
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }

        driver.manage().window().setPosition(WINDOW_POSITION);
        driver.manage().window().maximize();

        return driver;
    }
}
