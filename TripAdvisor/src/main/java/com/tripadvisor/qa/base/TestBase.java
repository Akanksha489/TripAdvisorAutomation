package com.tripadvisor.qa.base;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
	@BeforeClass
	public static WebDriver startApplication(WebDriver driver,String browsername, String appURL)
	{
		if ("Chrome".equals(browsername))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if("IE".equals(browsername))
		{
			System.setProperty("webdriver.internetexplorer.driver", "D:\\eclipse\\InternetExplorerdriver.exe");
			driver=new InternetExplorerDriver();
		}
		else if("FireFox".equals(browsername))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\eclipse\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.print("We donot support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterClass
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
