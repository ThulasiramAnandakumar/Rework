package Flipkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Flikart_Pages;
import POM.PropertyFile;

public class Flipkart 
{
	PropertyFile pf=new PropertyFile();
	Flikart_Pages fp=new Flikart_Pages();

	public WebDriver d;

	@Test(priority = 1,description = "Login")
	public void login() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","/home/qq383/Selenium/Driver/chromedriver");
		d= new ChromeDriver();
		
		
		Assert.assertEquals( fp.login(d) ,pf.mainTitle());
		System.out.println("Login Passed Successfully ");
		
	}
	
	@Test(priority = 2,description = "Search and select a product")
	public void run() throws IOException
	{
		Assert.assertEquals( fp.searchProducts(d),pf.mobileTitle());
		System.out.println("Product Clicked Successfully");
		
	}

	@Test(priority = 3,description = "Buynow")
	public void buyNow() throws InterruptedException, IOException
	{
	//	String title=fp.buyNow(d);
		Assert.assertEquals(fp.buyNow(d),pf.endTitle());
		System.out.println("Login Passed Successfully ");
	}

}
