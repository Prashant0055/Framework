package com.learnmaven.TestCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnmaven.Pages.BaseClass;
import com.learnmaven.Pages.loginPage;

public class TestFacebookWithFramework extends BaseClass {

	
	@Test
	public void LoginApp() {
		
		logger=report.createTest("Login to FB");
		
		loginPage loginpage=PageFactory.initElements(driver, loginPage.class);
		
		logger.info("Starting Application");
		
		loginpage.loginToFB(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
				
		logger.pass("Login Successfully");
	}
	
	

}
