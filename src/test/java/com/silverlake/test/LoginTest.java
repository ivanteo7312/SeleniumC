package com.silverlake.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silverlake.base.AutomationWrapper;
import com.silverlake.utilities.DataSource;

public class LoginTest extends AutomationWrapper {


	
	@Test
	public void validLoginTest() {

		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.cssSelector("#clearPass")).sendKeys("pass");
		driver.findElement(By.id("login-button")).click();

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
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-button")).click();
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String username, String password, String expectedTitle) {
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-button")).click();
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	

}
