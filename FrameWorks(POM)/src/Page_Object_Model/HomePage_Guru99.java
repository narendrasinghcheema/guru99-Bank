package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage_Guru99 {

	WebDriver driver3;
	By New_Customer = By.xpath("//*[text()='New Customer']");
	By Edit_Customer = By.linkText("Edit Customer");
	
	
	public HomePage_Guru99(WebDriver driver3)
	{
		this.driver3 = driver3;
	}
	
	public void clickNew_Customer()
	{
		driver3.findElement(New_Customer).click();
	}
	
	public void clickEdit_Customer()
	{
		driver3.findElement(Edit_Customer).click();
	}
}
