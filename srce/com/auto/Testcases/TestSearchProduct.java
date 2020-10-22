/**
 * 
 */
package com.auto.Testcases;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.Pages.LandingPage;

/**
 * @author Marc
 *
 */
public class TestSearchProduct {

	
	private WebDriver setup() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marc\\Documents\\SeleniumShit\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     return driver;
	}
	
	
    @Test
	public void SearchProduct() {
		try {
			 System.out.println("Test Case One with Thread Id:- "
					+ Thread.currentThread().getId());
			
			 WebDriver driver = setup();
			 
		     driver.get("https://www.amazon.es/ref=nav_logo");
		     LandingPage landing = new LandingPage(driver);
	         
		     Thread.sleep(4000);
		     landing.clickSearchBar();
		     landing.typeSearchBar("1917");
		     landing.clickSearchButton();
		     landing.clickPrimeraBusqueda();
		     Thread.sleep(6000);
		     driver.quit();
		     
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	@Test
	public void TestTitle() {
		
		 System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		 
		 WebDriver driver = setup();
	     driver.get("https://www.amazon.es/ref=nav_logo");
	     LandingPage landing = new LandingPage(driver);
	     
	     String expectedTitle = "Amazon";
	     String actualTitle = landing.getTitle();
	     try {
	    	 Assert.assertEquals(actualTitle,expectedTitle);
	     } catch (Exception e){
	    	 System.out.println("error");
	     }
	     driver.close();
	}
}
