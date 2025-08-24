package com.framework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginTestData() {
        String filePath = "src/test/resources/testdata/loginData.json";
        JsonNode rootNode = JsonDataReader.readJsonFile(filePath);

        List<Object[]> testData = new ArrayList<>();
        Iterator<String> fieldNames = rootNode.fieldNames();

        while (fieldNames.hasNext()) {
            String testCase = fieldNames.next();
            JsonNode testCaseNode = rootNode.get(testCase);

            String username = testCaseNode.get("username").asText();
            String password = testCaseNode.get("password").asText();
            String expectedMessage = testCaseNode.get("expectedMessage").asText();

            testData.add(new Object[]{testCase, username, password, expectedMessage});
        }

        return testData.toArray(new Object[0][]);
    }

    @DataProvider(name = "csvData")
    public static Object[][] getCsvTestData() {
        // Implementation for CSV data reading
        return new Object[][]{};
    }

    @DataProvider(name = "excelData")
    public static Object[][] getExcelTestData() {
        // Implementation for Excel data reading
        return new Object[][]{};
    }
}
