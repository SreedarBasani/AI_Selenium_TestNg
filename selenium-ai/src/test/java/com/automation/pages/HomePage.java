package com.automation.pages;

import com.automation.base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    private WebDriverWait wait;

    @FindBy(css = ".welcome-message")
    private WebElement welcomeMessage;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public void logout() {
        logoutButton.click();
    }

}
