package com.framework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonDataReader {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) {
        try {
            return objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read JSON file: " + filePath);
        }
    }

    public static String getTestData(String filePath, String testCase, String field) {
        JsonNode rootNode = readJsonFile(filePath);
        JsonNode testCaseNode = rootNode.get(testCase);

        if (testCaseNode != null && testCaseNode.get(field) != null) {
            return testCaseNode.get(field).asText();
        }

        throw new RuntimeException("Test data not found for: " + testCase + "." + field);
    }
}
