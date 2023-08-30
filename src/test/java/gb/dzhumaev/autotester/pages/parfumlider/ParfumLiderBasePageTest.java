package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.pages.Urls.*;
import static org.testng.Assert.*;

public class ParfumLiderBasePageTest extends BaseTest {
    ParfumLiderBasePage parfumLiderBasePage = new ParfumLiderBasePage(driver);

    @Test
    public void testGoToFavorite() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), PARFUMLIDER_FAVORITE);
    }

    @Test
    public void testGoToCart() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.goToCart();
        assertEquals(driver.getCurrentUrl(), PARFUMLIDER_CART);
    }

    @Test
    public void testFavoriteCounterIsPresentWhenFavoritesIsEmpty() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        assertFalse(parfumLiderBasePage.favoriteCounterIsPresent());
    }

    @Test
    public void testCartCounterIsPresentWhenCartIsEmpty() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        assertFalse(parfumLiderBasePage.cartCounterIsPresent());
    }

    @Test
    public void testFavoriteCounterIsPresentWhenNextProductAddedToFavorite() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.addNextProductToFavorite();
        assertTrue(parfumLiderBasePage.favoriteCounterIsPresent());
    }

    @Test
    public void testAddNextProductToCart() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.addNextProductToCart();
        assertTrue(parfumLiderBasePage.cartCounterIsPresent());
    }

    @Test
    public void testInsertSearchQuery() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        WebElement element = parfumLiderBasePage.insertSearchQuery("Смартфон");
        assertEquals(element.getAttribute("value"), "Смартфон");
    }

    //@Test
    public void testPressSearchButton() {
    }
}