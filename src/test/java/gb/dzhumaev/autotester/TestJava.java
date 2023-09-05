package gb.dzhumaev.autotester;

import gb.dzhumaev.autotester.izyum.IzyumDataForParsing;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(TestListener.class)
public class TestJava extends TestCongicuration{

    @Test
    public void testIt() throws InterruptedException {
        getDriver().get(IzyumDataForParsing.Base.URL_HOME);
        Thread.sleep(2000);
        PageUtils.click(IzyumDataForParsing.Base.LOCATOR_COMPARE,10);
    }

    @Test
    public void testIt2() throws InterruptedException {
        By l = By.cssSelector(".test");
        System.out.println(l.toString().replace("By.cssSelector: ", ""));
    }
}
