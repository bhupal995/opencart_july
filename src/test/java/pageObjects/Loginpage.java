package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) {
		super(driver);
	}

	
	// Web elements
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtpass;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	
	// Action methods
	
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setPasswrd (String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
}
