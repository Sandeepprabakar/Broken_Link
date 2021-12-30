package com.interview;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Broken_Link {
	
	
	@Test
	private void broken() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Selenium_Basic\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/SearchHotel.php");
		
		

		Thread.sleep(3000);
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		//WebDriverWait wait = new WebDriverWait(driver,30);
	  //  WebElement element = wait.until(
	                       // ExpectedConditions.elementToBeClickable(By.id("alllinks")));
		System.out.println();
		for (WebElement links : alllinks) {
			
			String link = links.getAttribute("href");
			System.out.println(link);
			
			URL url = new URL(link);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();
			if (responseCode>400) {
				System.out.println("Broken link");
				System.out.println(link);
			}
			
		}

	}

}
