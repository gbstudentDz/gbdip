package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.PageUtils;
import gb.dzhumaev.autotester.SelectorInfo;
import gb.dzhumaev.autotester.TestCongicuration;
import gb.dzhumaev.autotester.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static gb.dzhumaev.autotester.PageUtils.click;
import static gb.dzhumaev.autotester.PageUtils.sendKeys;
import static gb.dzhumaev.autotester.izumclub.Selectors.CARD_1;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_CATEGORY_SMARTPHONES;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_HOME;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование UI сайта " + URL_HOME)
@Feature("Форма быстрого заказа товара")
@ExtendWith(TestListener.class)
public class FastOrderTest extends TestCongicuration {

    private final String correctTelNumber = "+79093146051";
    private final String incorrectTelephoneNumber = "+79O93146O51";
    private final String correctCityName = "Москва";
    private final String incorrectCityName = "$Москва";
    private final String correctFullName = "Иванов Иван Иванович";
    private final String incorrectFullName = "!Иванов @Иван #Иванович";
    private final String correctEmail = "example@mail.com";
    private final String incorrectEmail = "example&mail.com";

    @Test
    @DisplayName("Ве поля заполнены валидными значениями")
    public void t1() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(new SelectorInfo("a.fast_order", "Кнопка быстрого заказа"));
        sendKeys(new SelectorInfo("#CITY", "поле ввода города"), correctCityName);
        sendKeys(new SelectorInfo("#FIO", "поле ввода ФИО"), correctFullName);
        sendKeys(new SelectorInfo("#PHONE", "поле ввода телефона"), correctTelNumber);
        sendKeys(new SelectorInfo("#EMAIL", "поле ввода email"), correctEmail);
        click(new SelectorInfo("button.btn-blue[type='submit']", "кнопка Заказать"));
        WebElement element = PageUtils.wait(By.cssSelector("#fast_order_form"));
        assertTrue(asList(element.getAttribute("class").split(" ")).contains("load"));
    }
}
