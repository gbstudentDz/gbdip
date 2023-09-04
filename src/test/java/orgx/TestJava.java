package orgx;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(TestListener.class)
public class TestJava extends TestCongicuration{

    @Test
    public void testIt() {
        getDriver().get("https://example.com/");
        assertEquals("Example Domain", getDriver().findElement(By.tagName("h1")).getText());
    }
}
