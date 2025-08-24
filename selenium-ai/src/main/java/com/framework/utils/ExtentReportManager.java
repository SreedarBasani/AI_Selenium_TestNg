package com.framework.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void initReports() {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setReportName("Automation Test Results");
            sparkReporter.config().setDocumentTitle("Test Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
    }

    public static void createTest(String testName, String description) {
        ExtentTest test = extentReports.createTest(testName, description);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
