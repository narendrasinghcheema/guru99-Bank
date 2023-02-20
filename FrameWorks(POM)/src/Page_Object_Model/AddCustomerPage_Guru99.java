package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage_Guru99 {

	WebDriver driver4;
    By nameField = By.name("name");
    By dobField = By.name("dob");
    By addressField = By.name("addr");
    By cityField = By.name("city");
    By stateField = By.name("state");
    By pinField = By.name("pinno");
    By telephoneField = By.name("telephoneno");
    By emailField = By.name("emailid");
    By passwordField = By.name("password");
    By submitButton = By.name("sub");
    By successMessage = By.xpath("//p[contains(text(), 'Customer Registered Successfully')]");

    public AddCustomerPage_Guru99(WebDriver driver4) {
        this.driver4 = driver4;
    }

    public void fillForm(String name, String dob, String address, String city, String state, String pin, String telephone, String email, String password) {
        driver4.findElement(nameField).sendKeys(name);
        driver4.findElement(dobField).sendKeys(dob);
        driver4.findElement(addressField).sendKeys(address);
        driver4.findElement(cityField).sendKeys(city);
        driver4.findElement(stateField).sendKeys(state);
        driver4.findElement(pinField).sendKeys(pin);
        driver4.findElement(telephoneField).sendKeys(telephone);
        driver4.findElement(emailField).sendKeys(email);
        driver4.findElement(passwordField).sendKeys(password);
        driver4.findElement(submitButton).click();
    }

}
