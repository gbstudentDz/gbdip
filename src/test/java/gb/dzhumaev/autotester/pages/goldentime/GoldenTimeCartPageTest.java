package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.pages.goldentime.Urls.PRODUCT_FOR_SALE_URL_1;
import static gb.dzhumaev.autotester.pages.goldentime.Urls.PRODUCT_FOR_SALE_URL_2;
import static org.testng.AssertJUnit.assertEquals;

public class GoldenTimeCartPageTest extends BaseTest {

    private GoldenTimeCartPage page = new GoldenTimeCartPage(driver);

    @Test
    public void getCartCounterValueTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        assertEquals("1", page.getCartCounterValue());
    }

    @Test
    public void getCartCounterValueWhenSameProductAddedTwoTimesTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.addProductToCart();
        assertEquals("2", page.getCartCounterValue());
    }

    @Test
    public void getCartCounterValueWhenDifferentProductsAddedTwoTimesTest() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        driver.get(PRODUCT_FOR_SALE_URL_2);
        page.addProductToCart();
        Thread.sleep(3000);
        assertEquals("2", page.getCartCounterValue());
    }

    @Test
    public void getBasketItemsCountWhenSameProductAddedTwoTimesTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.addProductToCart();
        page.goToCart();
        assertEquals(1, page.getBasketItemsCount());
    }

    @Test
    public void getBasketItemsCountWhenDifferentProductsAddedTwoTimesTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        driver.get(PRODUCT_FOR_SALE_URL_2);
        page.addProductToCart();
        page.goToCart();
        assertEquals(2, page.getBasketItemsCount());
    }

    @Test
    public void getBasketItemAmountFiledValueWhenSameProductAddedTwoTimesTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.addProductToCart();
        page.goToCart();
        assertEquals("2", page.getBasketItemAmountFiledValue());
    }

    @Test
    public void getBasketItemAmountFiledValueWhenDifferentProductsAddedTwoTimesTest() {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        driver.get(PRODUCT_FOR_SALE_URL_2);
        page.addProductToCart();
        page.goToCart();
        assertEquals("1", page.getBasketItemAmountFiledValue());
    }

    @Test
    public void getBasketItemPriceWhenPushedPlus() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        Double oldPrice = page.getBasketItemPrice();
        page.pushPlusOnBasketItem();
        Thread.sleep(3000);
        assertEquals(oldPrice * 2, page.getBasketItemPrice());
    }

    @Test
    public void getFinalPriceWhenPushedPlusTest() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        Double oldPrice = page.getFinalPrice();
        page.pushPlusOnBasketItem();
        Thread.sleep(5000);
        assertEquals(oldPrice * 2, page.getFinalPrice());
    }

    @Test
    public void getBasketItemPriceWhenPushedMinus() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        Double price = page.getBasketItemPrice();
        page.pushPlusOnBasketItem();
        Thread.sleep(5000);
        page.pushMinusOnBasketItem();
        Thread.sleep(5000);
        assertEquals(price, page.getBasketItemPrice());
    }

    @Test
    public void getFinalPriceWhenPushedMinus() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        Double price = page.getFinalPrice();
        page.pushPlusOnBasketItem();
        Thread.sleep(3000);
        page.pushMinusOnBasketItem();
        Thread.sleep(5000);
        assertEquals(price, page.getFinalPrice());
    }

    @Test
    public void getCartCounterValueWhenPushedPlusTest() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        page.pushPlusOnBasketItem();
        Thread.sleep(5000);
        assertEquals("2", page.getCartCounterValue());
    }

    @Test
    public void getCartCounterValueWhenPushedMinusTest() throws InterruptedException {
        driver.get(PRODUCT_FOR_SALE_URL_1);
        page.addProductToCart();
        page.goToCart();
        page.pushPlusOnBasketItem();
        Thread.sleep(2000);
        page.pushMinusOnBasketItem();
        Thread.sleep(5000);
        assertEquals("1", page.getCartCounterValue());
    }
}

