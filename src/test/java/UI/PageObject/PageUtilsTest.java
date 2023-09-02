package UI.PageObject;

import com.google.gson.internal.NonNullElementWrapperList;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestListener.class)
//@ExtendWith(TestListenerApi.class)
@Epic("Тесты на вебе")
@Feature("Тесты на сайте IDEA")
class PageUtilsTest {

    public EventFiringWebDriver driver = EventFiringWebDriverBuilder.create();
    public PageUtils pageUtils = new PageUtils(driver);

    @Test
    public void waitElement() {
        driver.get("http://example.com/");
    }

    @Test
    public void testWaitElement() {
    }

    @Test
    public void clickElement() {
    }
}