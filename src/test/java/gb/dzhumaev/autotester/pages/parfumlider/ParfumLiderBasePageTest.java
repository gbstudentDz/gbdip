package gb.dzhumaev.autotester.pages.parfumlider;

import gb.dzhumaev.autotester.common.CommonActions;
import gb.dzhumaev.autotester.pages.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static gb.dzhumaev.autotester.constants.Constant.Urls.PARFUMLIDER_FAVORITE;
import static gb.dzhumaev.autotester.constants.Constant.Urls.PARFUMLIDER_HOMEPAGE;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
public class ParfumLiderBasePageTest extends BaseTest {
    ParfumLiderBasePage parfumLiderBasePage = new ParfumLiderBasePage(driver);
    @Test
    public void testGoToFavorite() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.goToFavorite();
        assertEquals(driver.getCurrentUrl(), PARFUMLIDER_FAVORITE);
    }

    @Test
    public void testInsertSearchQuery() {
        basePage.open(PARFUMLIDER_HOMEPAGE);
        parfumLiderBasePage.insertSearchQuery("Смартфон");
        //assertEquals(driver.getCurrentUrl(), PARFUMLIDER_FAVORITE);
    }

    @Test
    public void testPressSearchButton() {
    }

    @Test
    public void testGoToCart() {
    }
}