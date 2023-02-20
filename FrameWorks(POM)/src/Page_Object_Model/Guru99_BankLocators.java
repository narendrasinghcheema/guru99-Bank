package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru99_BankLocators {

	//========================Guru99 Banking Project==========================       
		By Bank_UserName = By.xpath("//input[@name='uid']");
		By Bank_Password = By.xpath("//input[@name='password']");
		By Bank_Submit = By.name("btnLogin");
	    //=========================================================================
		
		WebDriver driver2;
		public Guru99_BankLocators(WebDriver driver2)
		{
			this.driver2 = driver2; 
		}
		
		public void Bank_Credentials(String user, String pass)
		{
			driver2.findElement(Bank_UserName).sendKeys(user); //mngr476338
			driver2.findElement(Bank_Password).sendKeys(pass); //nyhymUd
			driver2.findElement(Bank_Submit).click();
		}
		
		public void Select_Browser()
		{
				driver2 = new FirefoxDriver();
				driver2.manage().window().maximize();
				driver2.get("https://demo.guru99.com/V4/");
		}
}
