package gb.dzhumaev.autotester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;


import static gb.dzhumaev.autotester.common.Configuration.*;

public class WebDriverBuilder {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "WINDOWS_FIREFOX":
                System.setProperty("webdriver.firefox.driver", PATH_TO_DRIVER_EXE);

                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.cache.disk.enable", false);
                profile.setPreference("browser.cache.memory.enable", false);
                profile.setPreference("browser.cache.offline.enable", false);
                profile.setPreference("network.http.use-cache", false);

                FirefoxOptions options = new FirefoxOptions().setProfile(profile);
                driver = new FirefoxDriver(options);
                break;
            default:
                throw new CreateDriverException
                        ("WebDriver is not created. Incorrect platform or browser name: "
                                + PLATFORM_AND_BROWSER);
        }

        driver.manage().window().setPosition(WINDOW_POSITION);
        driver.manage().window().maximize();

        return driver;
    }
}