package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.HomePage;
import com.framework.utils.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private final String TEST_DATA_PATH = "src/test/resources/testdata/loginData.json";

    @Test(description = "Valid login test")
    public void testValidLogin() {
        loginPage = new LoginPage();
        homePage = new HomePage();

        String username = JsonDataReader.getTestData(TEST_DATA_PATH, "validLogin", "username");
        String password = JsonDataReader.getTestData(TEST_DATA_PATH, "validLogin", "password");

        loginPage.login(username, password);

        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome message should be displayed");
    }

    @Test(description = "Invalid login test")
    public void testInvalidLogin() {
        loginPage = new LoginPage();

        String username = JsonDataReader.getTestData(TEST_DATA_PATH, "invalidLogin", "username");
        String password = JsonDataReader.getTestData(TEST_DATA_PATH, "invalidLogin", "password");

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
    }

    @Test(description = "Empty fields login test")
    public void testEmptyFieldsLogin() {
        loginPage = new LoginPage();

        String username = JsonDataReader.getTestData(TEST_DATA_PATH, "emptyFields", "username");
        String password = JsonDataReader.getTestData(TEST_DATA_PATH, "emptyFields", "password");

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for empty fields");
    }
}
