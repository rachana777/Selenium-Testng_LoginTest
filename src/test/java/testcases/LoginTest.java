package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BaseTest;
import utils.ReadExcelData;

public class LoginTest extends BaseTest {
	
	
	
	@Test(dataProviderClass=ReadExcelData.class,dataProvider="loginData")
	public static void loginUser(String email,String password, String expected) throws InterruptedException {

		 dr.findElement(By.linkText(loc.getProperty("SignInBtn"))).click();
		 
		 dr.findElement(By.id(loc.getProperty("LoginId"))).sendKeys(email);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("NextBtn")))).click();
		 
		 //invalid email check
		 if(expected.equalsIgnoreCase("Invalidemail")) {
			 boolean invalidEmailError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"getusername\"]/span/div[4]")))
					 .isDisplayed();
			 Assert.assertTrue(invalidEmailError);
			 return;
		 }

		 dr.findElement(By.id(loc.getProperty("PassField"))).sendKeys(password);
		 wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(loc.getProperty("LoginNextBtn"))))).click();
		 
		 if(expected.equalsIgnoreCase("Success")) {
			 boolean isLoggedIn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ztb-logo-rebrand"))).isDisplayed();
			 Assert.assertTrue(isLoggedIn);
		 }
		 else if(expected.equalsIgnoreCase("Invalidpassword")) {
			 boolean invalidPassError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password_container\"]/div[2]/div[1]")))
					 .isDisplayed();
			 Assert.assertTrue(invalidPassError);
		 }
		 
	}
	

}
