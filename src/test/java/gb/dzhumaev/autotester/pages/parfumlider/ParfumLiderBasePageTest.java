package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.constants.Constant.Urls.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ParfumLiderBasePageTest extends BaseTest {
    ParfumLiderBasePage parfumLiderBasePage = new ParfumLiderBasePage(driver);

    @Test
    public void testGoToFavorite() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), PARFUMLIDER_FAVORITE);
    }

    @Test
    public void testGoToCart() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.goToCart();
        assertEquals(driver.getCurrentUrl(), PARFUMLIDER_CART);
    }


    @Test
    public void testFavoriteCounterIsPresentWhenFavoritesIsEmpty() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        assertFalse(parfumLiderBasePage.favoriteCounterIsPresent());
    }

    @Test
    public void testCartCounterIsPresentWhenCartIsEmpty() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        assertFalse(parfumLiderBasePage.cartCounterIsPresent());
    }

    @Test
    public void testFavoriteCounterIsPresentWhenProductAddedToFavorite() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.addProductToFavorite();
        assertTrue(parfumLiderBasePage.favoriteCounterIsPresent());
    }
}