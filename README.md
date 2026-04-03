# Selenium TestNG Zoho Website Login Automation

## Framework Overview
A simple data-driven automation framework built with Selenium WebDriver and TestNG for automated login testing.

## Test Scenario Covered
Scenario            Input                       Expected
InvalidEmail        Wrong email entered         Error Message
Success             Valid cred entered          Dashboard loads
InvalidPassword     Valid email + wrong pass    Error Message

## Screenshot/Testng Report
src/test/resources/screenshots

## Test Execution Video
[Youtube link for Test Execution](https://youtu.be/ebFhrj1YGSY)


## Tech Stack
-Java
-Selenium WebDriver
-TestNG
-Apache POI (Excel data reading)
-Maven (dependency management)

## Framework Architecture

### Base Class
-Initializes WebDriver, WebDriverWait
-Loads config.properties and locators.properties
-LoginTest class extend this parent base class to reuse setup

### Properties Files
-config properties-stores url, broswser
-locators properties-stores element locators

### Utils
-Read test data from Excel using Apache poi
-Returns data as Object[][] for testng dataprovider

### LoginTest Class
-Extends Baseclass
-Uses @DataProvider to feed multiple data sets
-Covers 3 login scenarios: success, invalidEmail and invalidPassword

### Testng.xml
-Defines test suite config