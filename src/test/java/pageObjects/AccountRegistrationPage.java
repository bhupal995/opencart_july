package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	
	//Elements
	
	@FindBy(name="firstname")
	WebElement txtFirstname;
	
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="telephone")
	WebElement txttelephone;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="confirm")
	WebElement txtcnfpassword;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btncontinue;

	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	WebElement errmsgconfirmation;
	
	@FindBy(css="First Name must be between 1 and 32 characters!")
	WebElement fnameerrormsg;
	
//	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
//	WebElement fnameerrormsg;
	
	
	//Action methods
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void settelephone(String tel) {
		txttelephone.sendKeys(tel);
	}

	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtcnfpassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	
	
	public void clickContinue() {
		btncontinue.click();
	}
	
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
		public String errorgetConfirmationMsg()
		{
			try
			{
				return (errmsgconfirmation.getText());
			} catch (Exception e)
			{
				return (e.getMessage());
			}
		
		}
		
		
		public String firstnameerrormsg()
		{
			try
			{
				return (fnameerrormsg.getText());
			} catch (Exception e)
			{
				return (e.getMessage());
			}
		
		}
}
