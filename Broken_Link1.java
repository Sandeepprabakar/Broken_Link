package com.interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Link1 {
	@Test
	public void brokenLink() throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		for (WebElement link : linkList) {

			String url = link.getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}

			try {
				URL htt = new URL(url);
				HttpURLConnection huc = (HttpURLConnection) htt.openConnection();
				/*
				 * huc.setRequestMethod("HEAD");
				 * 
				 * huc.connect();
				 */

				int respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

}
