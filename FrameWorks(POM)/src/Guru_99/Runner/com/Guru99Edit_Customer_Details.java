package Guru_99.Runner.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page_Object_Model.Guru99_BankLocators;
import Page_Object_Model.HomePage_Guru99;
import Page_Object_Model.guru99Edit_Customer;

public class Guru99Edit_Customer_Details {

	WebDriver driver;
	@Test
	public void Open()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
	}
	
	@Test(dependsOnMethods = "Open")
	public void Login()
	{
		Guru99_BankLocators login = new Guru99_BankLocators(driver);
		login.Bank_Credentials("mngr476338", "nyhymUd");
	}
	
	
	@Parameters("customerID")
	@Test(dependsOnMethods = "Login")
	public void CustomerID_Edit(String customerID)
	{
		HomePage_Guru99 clickon_Edit = new HomePage_Guru99(driver);
		clickon_Edit.clickEdit_Customer();
		guru99Edit_Customer Edit_Filed = new guru99Edit_Customer(driver);
		Edit_Filed.editCustomerField(customerID);
		
		Alert PopUp_Massage = driver.switchTo().alert();
		String PopMassage = PopUp_Massage.getText();
		
		if(PopMassage.equals("Customer does not exist!!"))
		{
			System.out.println("CustomerID does not exist!!");
			PopUp_Massage.accept();
		}
		else if(driver.getCurrentUrl().equals("https://demo.guru99.com/V4/manager/editCustomerPage.php"))
		{
			System.out.println("Page is Open User can edit the customer Details");
		}
		
	}
	
	
}
