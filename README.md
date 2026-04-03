# Selenium TestNG Zoho Website Login Automation

## Framework Overview
A simple data-driven automation framework built with Selenium WebDriver and TestNG for automated login testing.

## Test Scenario Covered
-Success: Valid cred entered - Dashboard Loads <br>
-Invalid Email : Wrong email entered - Error message <br>
-INvalid Password: Valid email + wrong password - Error message

## Screenshot/Testng Report
src/test/resources/screenshots

## Test Execution Video
[Youtube link for Test Execution](https://youtu.be/ebFhrj1YGSY)


## Tech Stack
-Java<br>
-Selenium WebDriver<br>
-TestNG<br>
-Apache POI (Excel data reading)<br>
-Maven (dependency management)<br>

## Framework Architecture

### Base Class
-Initializes WebDriver, WebDriverWait<br>
-Loads config.properties and locators.properties<br>
-LoginTest class extend this parent base class to reuse setup<br>

### Properties Files
-config properties-stores url, broswser<br>
-locators properties-stores element locators<br>

### Utils
-Read test data from Excel using Apache poi<br> 
-Returns data as Object[][] for testng dataprovider<br>

### LoginTest Class
-Extends Baseclass. 
-Uses @DataProvider to feed multiple data sets<br> 
-Covers 3 login scenarios: success, invalidEmail and invalidPassword<br>

### Testng.xml
-Defines test suite config