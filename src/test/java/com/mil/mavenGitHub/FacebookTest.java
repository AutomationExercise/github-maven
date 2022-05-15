package com.mil.mavenGitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest {
	public static WebDriver driver;

	@Test
	public void facebookTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		String title = driver.getTitle();
		System.out.println("Facebook page title is: " + title);
		Assert.assertEquals(title, "Facebook - log in or sign up", "Facebook title mismatched");
		
		String url = driver.getCurrentUrl();
		System.out.println("Facebook page url is: " + url);

		driver.quit();
	}

}
