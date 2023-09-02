package UI.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WebElementAdvanced {

    private WebElement element = null;

    public WebElementAdvanced(WebElement element) {
        this.element = element;
    }

    public WebElementAdvanced findElement(By locator) {
        element = element.findElement(locator);
        return this;
    }

    public WebElementAdvanced moveToElement(WebDriver driver) {
        new Actions(driver).moveToElement(element);
        return this;
    }

    public PageUtils moveToElement(WebDriver driver, PageUtils pageUtils) {
        new Actions(driver).moveToElement(element);
        return pageUtils;
    }

    public WebElementAdvanced click() {
        element.click();
        return this;
    }

    public PageUtils click(PageUtils pageUtils) {
        element.click();
        return pageUtils;
    }

    public WebElementAdvanced perform(WebDriver driver) {
        new Actions(driver).perform();
        return this;
    }

    public PageUtils perform(WebDriver driver, PageUtils pageUtils) {
        new Actions(driver).perform();
        return pageUtils;
    }

    public WebElementAdvanced submit() {
        element.submit();
        return this;
    }

    public PageUtils submit(PageUtils pageUtils) {
        element.submit();
        return pageUtils;
    }

    public WebElementAdvanced sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
        return this;
    }

    public PageUtils sendKeys(PageUtils pageUtils, CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
        return pageUtils;
    }

    public WebElementAdvanced clear() {
        element.clear();
        return this;
    }

    public PageUtils clear(PageUtils pageUtils) {
        element.clear();
        return pageUtils;
    }

    // -------------------------------------------------------------------------------

    public String getTagName() {
        return null;
    }


    public String getAttribute(String name) {
        return null;
    }


    public boolean isSelected() {
        return false;
    }


    public boolean isEnabled() {
        return false;
    }


    public String getText() {
        return null;
    }


    public List<WebElement> findElements(By by) {
        return null;
    }


    public boolean isDisplayed() {
        return false;
    }


    public Point getLocation() {
        return null;
    }


    public Dimension getSize() {
        return null;
    }


    public Rectangle getRect() {
        return null;
    }


    public String getCssValue(String propertyName) {
        return null;
    }


    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
