package Guru_99.Runner.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Page_Object_Model.Guru99_BankLocators;


public class Guru99_Login_Test {

	WebDriver driver;
	@Parameters({"Select_Browser"})
	@Test
	public void Select_Browser_Name(String Select_Browser)
	{
		if(Select_Browser.equals("Chrome"))
		{
			driver = new FirefoxDriver();
		}
		else if(Select_Browser.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
		
	}
	
	@Parameters({"user" , "pass"})
	@Test(dependsOnMethods = "Select_Browser_Name")
	public void BankLogin(String user, String pass) throws IOException
	{
		Guru99_BankLocators Bank_Data = new Guru99_BankLocators(driver);
		Bank_Data.Bank_Credentials(user, pass);
		System.out.println("username is  = "+user+ " Password is = "+pass);
		
		Alert alert = driver.switchTo().alert();
		String AlertPop = alert.getText();
		
		if (AlertPop.equals("User or Password is not valid"))
		{
			
			System.out.println("user is not able to login ! bad Credentials");
			alert.accept();
			TakesScreenshot tk = (TakesScreenshot)driver;
			File file = tk.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./Screenshot/Login_Funtion.png"));
			
		}
		
	}
	
	@Parameters({"URL1" , "URL2"})
	@Test(dependsOnMethods = "BankLogin")
	public void Verify_UserLogin(String URL1, String URL2)
	{
		String Current_URL = driver.getCurrentUrl();
		if(Current_URL.equals(URL1))
		{
			System.out.println("User is not able to Login");
			System.out.println("and the URL is = "+URL1);
		}
		else if(Current_URL.equals(URL2))
		{
			System.out.println("User is syuccessfully Login");
			System.out.println("and the URL is = "+URL2);
		}
	}
	

}
