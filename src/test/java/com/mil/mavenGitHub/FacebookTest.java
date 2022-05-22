package com.mil.mavenGitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
	}

	@Test
	public void facebookTitleTest() {
		String title = driver.getTitle();
		String expTitle = "Facebook - log in or sign up";
		System.out.println("Facebook page title is: " + title);
		Assert.assertEquals(title, expTitle, "Facebook title is mismatched");
	}

	@Test
	public void facebookUrlTest() {
		String url = driver.getCurrentUrl();
		String expUrl = "https://www.facebook.com/";
		System.out.println("Facebook page url is: " + url);
		Assert.assertEquals(url, expUrl, "Facebook url is mismatched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
