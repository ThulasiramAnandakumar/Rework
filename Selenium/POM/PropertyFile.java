package POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile
{
	public String mainTitle() throws IOException
	{
		Properties prop=new Properties();

		FileInputStream fp=new FileInputStream("/home/qq383/eclipse-workspace/SeleniumAutomation/src/test/java/Flipkart/Config.properties");
		prop.load(fp);

		String title=(String) prop.get("title");
	//	System.out.println("Title :" +title);
		return title;

	}
	public String mobileTitle() throws IOException
	{
		Properties prop=new Properties();

		FileInputStream fp=new FileInputStream("/home/qq383/eclipse-workspace/SeleniumAutomation/src/test/java/Flipkart/Config.properties");
		prop.load(fp);

		String title=(String) prop.get("Mobiletitle");
	//	System.out.println("Title :" +title);
		return title;

	}

	public String endTitle() throws IOException
	{
		Properties prop=new Properties();

		FileInputStream fp=new FileInputStream("/home/qq383/eclipse-workspace/SeleniumAutomation/src/test/java/Flipkart/Config.properties");
		prop.load(fp);

		String title=(String) prop.get("endTitle");
	//	System.out.println("Title :" +title);
		return title;

	}
}
