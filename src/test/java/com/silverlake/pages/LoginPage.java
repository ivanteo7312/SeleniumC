package com.silverlake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		
		driver.findElement(By.id("authUser")).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(By.cssSelector("#login-button")).click();
	}
	
	public String getInvalidErrorMessage() {
		return driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText();
	}
}
