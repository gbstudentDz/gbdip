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
        assertFalse(parfumLiderBasePage.favoriteCounterIsDisplayed());
    }

    @Test
    public void testCartCounterIsPresentWhenCartIsEmpty() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        assertFalse(parfumLiderBasePage.cartCounterIsDisplayed());
    }

    @Test
    public void testFavoriteCounterWhenGoodAddedToFavorite() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.addGoodToFavorite();
        assertTrue(parfumLiderBasePage.favoriteCounterIsDisplayed());
    }

    @Test
    public void testCartCounterWhenGoodAddedToCart() {
        driver.get(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.addGoodToCart();
        assertTrue(parfumLiderBasePage.cartCounterIsDisplayed());
    }

    @Test /////////////////////////////////////////////
    public void testInsertSearchQuery() throws InterruptedException {
        String query = "Query";
        driver.get(PARFUMLIDER_HOMEPAGE);
        Thread.sleep(2000);
        WebElement inputElement = parfumLiderBasePage.insertSearchQuery(query);
        assertEquals(inputElement.getAttribute("value"), query);
    }

    //@Test
    public void testPressSearchButton() {
    }
}