package com.learnmaven.TestCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFacebookWithoutFramework {
	
	WebDriver driver;
	
	@Test
	public void chrome() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("sign"), "Does not matched");
		System.out.println("Code successfully Executed");
		driver.quit();
	}
	

}
