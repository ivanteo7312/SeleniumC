package com.silverlake.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.silverlake.base.AutomationWrapper;
import com.silverlake.pages.LoginPage;
import com.silverlake.pages.MainPage;
import com.silverlake.utilities.DataSource;

public class LoginTest extends AutomationWrapper {


	
	@Test
	public void validLoginTest() {

//		driver.findElement(By.id("authUser")).sendKeys("admin");
//		driver.findElement(By.cssSelector("#clearPass")).sendKeys("pass");
//		driver.findElement(By.id("login-button")).click();
		LoginPage a1 = new LoginPage(driver); 
		a1.enterUsername("admin");
		a1.enterPassword("pass");
		a1.clickOnLogin();

		Assert.assertEquals(driver.getTitle(), "OpenEMR");
	}

//	@Test(dataProvider = "validLoginData",dataProviderClass = DataSource.class)
//	public void validLoginTest(String username, String password, String expectedTitle) {
//		driver.findElement(By.id("authUser")).sendKeys(username);
//		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
//		driver.findElement(By.cssSelector("#login-button")).click();
//		Assert.assertEquals(driver.getTitle(), expectedTitle);
//	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void validLoginTest(String username, String password, String expectedTitle) {
//		driver.findElement(By.id("authUser")).sendKeys(username);
//		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
//		driver.findElement(By.cssSelector("#login-button")).click();
		LoginPage a2 = new LoginPage(driver); 
		a2.enterUsername(username);
		a2.enterPassword(password);
		a2.clickOnLogin();
		
		MainPage main = new MainPage(driver);
		Assert.assertEquals(main.getMainPageTitle(), expectedTitle);
		
	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String username, String password, String expectedTitle) {
//		driver.findElement(By.id("authUser")).sendKeys(username);
//		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
//		driver.findElement(By.cssSelector("#login-button")).click();
		LoginPage a3 = new LoginPage(driver); 
		a3.enterUsername(username);
		a3.enterPassword(password);
		a3.clickOnLogin();
		
		String actualError = a3.getInvalidErrorMessage();
		MainPage main1 = new MainPage(driver);
		Assert.assertEquals(main1.getMainPageTitle(), expectedTitle);
	}
	

}
