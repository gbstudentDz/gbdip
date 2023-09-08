package gb.dzhumaev.autotester.izumclub;

import gb.dzhumaev.autotester.PageUtils;
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
import static gb.dzhumaev.autotester.izumclub.Selectors.*;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_CATEGORY_SMARTPHONES;
import static gb.dzhumaev.autotester.izumclub.Urls.URL_HOME;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование UI сайта " + URL_HOME)
@Feature("Форма быстрого заказа товара")
@ExtendWith(TestListener.class)
public class FastOrderTest extends TestCongicuration {

    private final String correctTelNumber = "+79093146051";
    private final String incorrectTelNumber = "+79O!93146O51";
    private final String correctCityName = "Москва";
    private final String incorrectCityName = "$Москва";
    private final String correctFullName = "Иванов Иван Иванович";
    private final String incorrectFullName = "!Иванов @Иван #Иванович";
    private final String correctEmail = "example@mail.com";
    private final String incorrectEmail = "example&mail.com";

    @Test
    @DisplayName("Форма быстрого заказа: вcе обязательные поля заполнены валидными значениями")
    public void t1() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertTrue(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: поле ввода города пустое")
    public void t2() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        //sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: поле ФИО города пустое")
    public void t3() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        //sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: поле ввода номера пустое")
    public void t4() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        //sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: поле ввода email пустое")
    public void t5() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        //sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: в поле ввода города введено некоррекное значение")
    public void t6() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, incorrectCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: в поле ввода ФИО введено некоррекное значение")
    public void t7() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, incorrectFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: в поле ввода телефона введено некоррекное значение")
    public void t8() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, incorrectTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, correctEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }

    @Test
    @DisplayName("Форма быстрого заказа: в поле ввода email введено некоррекное значение")
    public void t9() throws InterruptedException {
        PageUtils.open(URL_CATEGORY_SMARTPHONES);
        click(CARD_1);
        click(DETAIL_PAGE_FAST_ORDER);
        sendKeys(FORM_FAST_ORDER_CITY, correctCityName);
        sendKeys(FORM_FAST_ORDER_FULLNAME, correctFullName);
        sendKeys(FORM_FAST_ORDER_PHONE, correctTelNumber);
        sendKeys(FORM_FAST_ORDER_EMAIL, incorrectEmail);
        click(FORM_FAST_ORDER_SUBMIT);
        WebElement element = PageUtils.wait(By.cssSelector(FORM_FAST_ORDER.s()));
        assertFalse(asList(element.getAttribute("class").split(" ")).contains("load"));
    }
}
