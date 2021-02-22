package com.tripadvisor.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	WebDriver driver;
	
	//Page Factory=Object Repository:
	@FindBy(xpath="//input[@placeholder='Where to?']")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[2]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div/div/div/div[2]/div[1]/div[1]")
	WebElement link;
	
	@FindBy(linkText="Write a review")
	WebElement write ;
	
	@FindBy(name="ReviewTitle")
	WebElement review;
	
	@FindBy(name="ReviewText")
	WebElement reviewtitle;
	
	@FindBy(xpath="//*[@id=\"DQ_RATINGS\"]/div[1]")
	WebElement Element;
	
	@FindBy(xpath="//*[@id=\"DQ_RATINGS\"]/div[1]")
	WebElement HotelRatings;
	
	@FindBy(css="#qid12_bubbles")
	WebElement Service;
	
	@FindBy(css="#qid13_bubbles")
	WebElement Value;
	
	@FindBy(name="noFraud")
	WebElement checkbox;
	
	@FindBy(css="#tr_qid47 > div.answersBlock > div.detailsRatings")
	WebElement Location;
	
	public HomePage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@Test
	public void Navigate() throws Exception {
		search.click();
		search.sendKeys("Club Mahindra");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
    
	@Test
	public void clickOnFirstElement() {
		link.click();
	}
	
	@Test
	public void window() throws InterruptedException
	{
		Set<String> handler= driver.getWindowHandles();
		
		Iterator<String> it=handler.iterator();
		
		String parentwindowID=it.next();
		System.out.print(parentwindowID);
		
		String ChildwindowID=it.next();
		System.out.print(ChildwindowID);
		
		driver.switchTo().window(ChildwindowID);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page till the element is found		
        js.executeScript("window.scrollBy(0,1000)");
        write.click();
        driver.findElement(By.cssSelector("#bubble_rating")).click();
        //driver.switchTo().window(ChildwindowID);
        
        //Actions action = new Actions(driver);
        //action.moveToElement(hoverstar).build().perform();
        //stars.click();
        
        review.sendKeys("This is my demo review");
        reviewtitle.sendKeys("This is my first review");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        if (HotelRatings.isDisplayed()) 
        {
        	System.out.println("Hotel Ratings are available");
        }
        else
        {
        	System.out.println("Hotel Ratings are not available.Please proceed for submission");
      	}
        Service.click();
        Thread.sleep(20000);
        Value.click();
        Thread.sleep(2000);
        Location.click();
        
        if (checkbox.isEnabled())
        {	
        	System.out.println("Checkbox is selected");
        	driver.findElement(By.id("SUBMIT")).click();
        }
        else
        {
        	driver.findElement(By.name("noFraud")).click();
        	driver.findElement(By.id("SUBMIT")).click();
        }
	}
	
}
