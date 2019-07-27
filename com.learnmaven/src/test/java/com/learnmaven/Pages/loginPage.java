package com.learnmaven.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="email") WebElement username;
	@FindBy(id="pass") WebElement password;
	@FindBy(id="loginbutton") WebElement loginButton;

	public void loginToFB(String UN,String PWD) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		username.sendKeys(UN);
		password.sendKeys(PWD);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
}
