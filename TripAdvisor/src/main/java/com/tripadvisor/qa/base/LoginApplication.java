package com.tripadvisor.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tripadvisor.qa.pages.HomePage;

public class LoginApplication {
		
	WebDriver driver;
		@Test
		public void application() throws Exception
		{
			driver=TestBase.startApplication(driver,"Chrome", "https://www.tripadvisor.in/");
			//driver.getTitle();
			HomePage homepage= PageFactory.initElements(driver, HomePage.class);
			homepage.Navigate();
			homepage.clickOnFirstElement();
			homepage.window();
			
		}
}
