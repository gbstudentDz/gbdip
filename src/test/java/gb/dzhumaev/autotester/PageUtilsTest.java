package gb.dzhumaev.autotester;

import gb.dzhumaev.autotester.izyum.IzyumDataForParsing;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

class PageUtilsTest extends TestCongicuration{

    @Test
    void splitLocatorsAsSequenceOfDescendants() {
        By locator1 = By.cssSelector("div");
        By locator2 = By.cssSelector(".some");
        By locator3 = PageUtils.joinLocators(locator1, locator2);
        assertEquals("div .some", locator3.toString().replace("By.cssSelector: ", ""));
    }

    @Test
    void click() throws InterruptedException {
        PageUtils.open(IzyumDataForParsing.Base.URL_CATEGORY_SMARTPHONES);
        PageUtils.click(IzyumDataForParsing.Category.LOCATOR_PRODUCT_CARD, 2);
    }
}