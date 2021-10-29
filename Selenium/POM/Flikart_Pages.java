package POM;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Flipkart.Flipkart;


public class Flikart_Pages 
{
	public WebDriver d;
	String baseurl="https://www.flipkart.com/";
	public void setup(WebDriver d)
	{

		System.setProperty("webdriver.chrome.driver","/home/qq383/Selenium/Driver/chromedriver");
		d= new ChromeDriver();
		d.get("https://www.flipkart.com/");
	}

	public String login(WebDriver d) throws IOException
	{

		Common_Locators cl=new Common_Locators();
		//
		//		System.setProperty("webdriver.chrome.driver","/home/qq383/Selenium/Driver/chromedriver");
		//		d= new ChromeDriver();


		cl.url(d, "https://www.flipkart.com/");
		d.manage().window().maximize();
		//Skip Pop up
		cl.Xpath(d, "//*[contains(text(),'✕')]").click();

		System.out.println(d.getCurrentUrl());
		//	System.out.println(d.getTitle());
		return d.getTitle().toString();

	}


	public String searchProducts(WebDriver d)
	{

		d.get("https://www.flipkart.com");
		//Enter Products in Search Box
		Common_Locators cl=new Common_Locators();

		cl.name(d,"q").sendKeys("Poco");

		//click Search
		cl.Xpath(d,"//*[@type='submit']").click();


		WebDriverWait wait=new WebDriverWait(d,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'POCO C31 (Royal Blue, 32 GB)')]")));
		//Select Product

		cl.Xpath(d,"//div[contains(text(),'POCO C31 (Royal Blue, 32 GB)')]").click();
		return d.getTitle().toString();
	}


	public String buyNow(WebDriver d) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(d,20);
		Common_Locators ref=new Common_Locators();

		//Window Handling
		String parent=d.getWindowHandle();
		//d.switchTo().window(parent);
		//System.out.println(parent);

		Set<String> winHandle=d.getWindowHandles();

		ArrayList<String> tab=new ArrayList<String>(winHandle);
		d.switchTo().window(tab.get(1));
		Thread.sleep(2000);

		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(d.getCurrentUrl());
		System.out.println(d.getTitle());

		//Choose_color
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='swatch-1-color']")));
		
		ref.Xpath(d, "//li[@id='swatch-1-color']").click();

		Thread.sleep(2000);

		//Choose_Storage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='swatch-1-storage']")));


		ref.Xpath(d, "//li[@id='swatch-1-storage']").click();

		Thread.sleep(2000);

		//ref.Xpath(d, "//li[@id='swatch-1-color']").click();
		//	assertEquals(true, wb.isEnabled());

		System.out.println(d.getTitle());
		
		ref.Xpath(d, "//button[@type='button']").click();
		return d.getTitle().toString();


	}

}
