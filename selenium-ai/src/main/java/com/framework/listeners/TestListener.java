package com.framework.listeners;

import com.aventstack.extentreports.Status;
import com.automation.base.DriverManager;
import com.framework.utils.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.initReports();
        ExtentReportManager.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Capture screenshot on failure
        try {
            TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
            String base64Image = screenshot.getScreenshotAs(OutputType.BASE64);
            ExtentReportManager.getTest().addScreenCaptureFromBase64String(base64Image, "Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentReportManager.flushReports();
    }
}
