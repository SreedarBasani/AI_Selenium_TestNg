package com.framework.models;

public class TestDataModel {

    private String testCase;
    private String username;
    private String password;
    private String expectedMessage;

    // Constructors
    public TestDataModel() {}

    public TestDataModel(String testCase, String username, String password, String expectedMessage) {
        this.testCase = testCase;
        this.username = username;
        this.password = password;
        this.expectedMessage = expectedMessage;
    }

    // Getters and Setters
    public String getTestCase() { return testCase; }
    public void setTestCase(String testCase) { this.testCase = testCase; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getExpectedMessage() { return expectedMessage; }
    public void setExpectedMessage(String expectedMessage) { this.expectedMessage = expectedMessage; }

    @Override
    public String toString() {
        return "TestDataModel{" +
                "testCase='" + testCase + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", expectedMessage='" + expectedMessage + '\'' +
                '}';
    }
}
