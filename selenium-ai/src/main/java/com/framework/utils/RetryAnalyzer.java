package com.framework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 2; // Retry failed tests 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                System.out.println("Retrying test " + iTestResult.getName() + " with status "
                        + getResultStatusName(iTestResult.getStatus()) + " for the " + (count + 1) + " time(s).");
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
