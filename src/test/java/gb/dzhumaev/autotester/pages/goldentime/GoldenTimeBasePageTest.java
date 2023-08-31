package gb.dzhumaev.autotester.pages.goldentime;

import gb.dzhumaev.autotester.pages.base.BasePage;
import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.pages.goldentime.Urls.*;
import static org.testng.Assert.*;

public class GoldenTimeBasePageTest extends BaseTest {
    GoldenTimeBasePage parfumLiderBasePage = new GoldenTimeBasePage(driver);

    @BeforeMethod
    public void preparePage() throws InterruptedException {
        driver.get(GOLDENTIME_HOMEPAGE_URL);
        BasePage page = new BasePage(driver);

        try {
            final By CITY_NOTIFICATION_LOCATOR = By.cssSelector(".city-notification--active .city-notification__button--true");
            page.waitElementIsClickableByLocator(CITY_NOTIFICATION_LOCATOR).click();
        } catch (TimeoutException ignored) {}

        try {
            final By CITY_PICKER_ACTIVE_LOCATOR = By.cssSelector(".city-picker--active");
            WebElement cityPickerActiveElement = page.waitElementIsClickableByLocator(CITY_PICKER_ACTIVE_LOCATOR);
            WebElement parentOfCityPickerActiveElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].parentNode;", cityPickerActiveElement);
            parentOfCityPickerActiveElement.click();
        } catch (TimeoutException ignored) {}

    }

    @Test
    public void goToFavoriteTest() {
        parfumLiderBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_FAVORITE_URL);
    }

    @Test
    public void goToCartTest() {
        parfumLiderBasePage.goToCart();
        assertEquals(driver.getCurrentUrl(), GOLDENTIME_CART_URL);
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasNotFavoriteTest() {
        assertFalse(parfumLiderBasePage.favoriteCounterIsDisplayed());
    }

    @Test
    public void cartCounterIsDisplayedWhenHasNotFavoriteTest() {
        assertFalse(parfumLiderBasePage.cartCounterIsDisplayed());
    }

    @Test
    public void favoriteCounterIsDisplayedWhenHasFavoriteTest() {
        parfumLiderBasePage.addGoodToFavorite();
        assertTrue(parfumLiderBasePage.favoriteCounterIsDisplayed());
    }

    @Test /////////////////////////////////////////////
    public void testCartCounterWhenGoodAddedToCart() {
        parfumLiderBasePage.addGoodToCart();
        assertTrue(parfumLiderBasePage.cartCounterIsDisplayed());
    }

    @Test
    public void testInsertSearchQuery() {
        String query = "Query";
        WebElement inputElement = parfumLiderBasePage.insertSearchQuery(query);
        assertEquals(inputElement.getAttribute("value"), query);
    }

    @Test
    public void testPressSearchButton() throws InterruptedException {
        parfumLiderBasePage.activateSearch();
        Thread.sleep(20000);
        assertEquals(driver.getCurrentUrl(), "https://golden-time.ru/catalog/search/?q=");
    }
}