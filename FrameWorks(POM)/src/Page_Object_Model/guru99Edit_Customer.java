package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class guru99Edit_Customer {

	WebDriver driver5;
	By Edit_CustomerField = By.xpath("//input[@name='cusid']");
	By Edit_Cutomer_Submit = By.xpath("//input[@name='AccSubmit']");
	
	public guru99Edit_Customer(WebDriver driver5)
	{
		this.driver5 = driver5;
	}
	
	public void editCustomerField(String customerID)
	{
		driver5.findElement(Edit_CustomerField).sendKeys(customerID);
		driver5.findElement(Edit_Cutomer_Submit).click();
	}
}
