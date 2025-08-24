package com.framework.utils;

import com.automation.base.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class WebDriverUtils {
    private static WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
    }

    public static void waitForElementVisible(WebElement element, int timeoutInSeconds) {
        getWait(timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebElement element, int timeoutInSeconds) {
        getWait(timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForTextToBePresentInElement(WebElement element, String text, int timeoutInSeconds) {
        getWait(timeoutInSeconds).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void clickElementWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void selectDropdownByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public static void selectDropdownByText(WebElement dropdown, String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.dragAndDrop(source, target).perform();
    }

    public static void switchToFrame(WebElement frameElement) {
        DriverManager.getDriver().switchTo().frame(frameElement);
    }

    public static void switchToDefaultContent() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void acceptAlert() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        return DriverManager.getDriver().switchTo().alert().getText();
    }

    public static void takeScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
        byte[] srcFile = screenshot.getScreenshotAs(OutputType.BYTES);
        // Save screenshot logic here
    }
}
