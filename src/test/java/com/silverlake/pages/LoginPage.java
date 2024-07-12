package com.silverlake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.silverlake.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {

	private WebDriver driver;
	private By usernameLocator=By.id("authUser");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		
		driver.findElement(usernameLocator).sendKeys(username);
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
