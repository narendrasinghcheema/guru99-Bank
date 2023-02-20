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

import Page_Object_Model.AddCustomerPage_Guru99;
import Page_Object_Model.Guru99_BankLocators;
import Page_Object_Model.HomePage_Guru99;

public class Guru99_addCustomer {

	WebDriver driver;
	@Test
	public void Select_Browser_Name()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
	}
	
	@Parameters({"URL1" , "URL2"})
	@Test(dependsOnMethods = "Select_Browser_Name")
	public void ValidCredentials(String URL1, String URL2)
	{
		Guru99_BankLocators Bank_Data = new Guru99_BankLocators(driver);
		Bank_Data.Bank_Credentials("mngr476338", "nyhymUd");
		
        String url = driver.getCurrentUrl();
		
		if(url.equals(URL1))
		{
			System.out.println("user is not able to login");
			System.out.println("and the url is = "+URL1);
		}
		else 
			if(url.equals(URL2))
		{
			System.out.println("user is successfully Login");
			System.out.println("and the URL is = "+URL2);
		}
		
	}
	
	
	@Test(dependsOnMethods = "ValidCredentials")
	public void addCustomer_test() throws IOException
	{
		HomePage_Guru99 homepage = new HomePage_Guru99(driver);
		homepage.clickNew_Customer();
		
		AddCustomerPage_Guru99 Add_Customer = new AddCustomerPage_Guru99(driver);
		Add_Customer.fillForm("John Doe", "01/01/1980", "123 Main St", "Anytown", "California", "123456", "7415658478", "pulpqa7@gmail.com", "Pulp@123");
		
		Alert popupAlert = driver.switchTo().alert();
		String alert = popupAlert.getText();
		
		if(alert.equals("please fill all fields"))
		{
			popupAlert.accept();
			System.out.println("please fill all fields");
			TakesScreenshot tk = (TakesScreenshot)driver;
			File file = tk.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./Screenshot/Guru99AddCustomer.png"));
		} //32394
		
	}

}
