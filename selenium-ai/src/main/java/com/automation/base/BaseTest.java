package com.automation.base;

import com.framework.listeners.TestListener;
import com.framework.utils.ConfigReader;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() throws SQLException {
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        DriverManager.initializeDriver(browser);
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicit.wait")))
        );
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
