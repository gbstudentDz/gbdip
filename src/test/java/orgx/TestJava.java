package orgx;

import org.junit.jupiter.api.Test;

public class TestJava extends TestCongicuration{

    @Test
    public void test() {
        driver.get("https://ya.ru/");
    }

    @Test
    public void test2() {
        driver.get("https://google.com/");
    }
}
