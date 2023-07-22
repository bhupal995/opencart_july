package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()throws InterruptedException{
		
		logger.info("******** Starting TC_001_ AccountRegistration Test ****");

		try{HomePage hm = new HomePage(driver);
		
		hm.clickMyAccount();
		
		logger.info("Clicked on My account link");
		hm.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomAlphaNumeric()+"@gmail.com");
		regpage.settelephone(randomeNumber());
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Clicked on continue");
		
		String confmsg = regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		MyaccountPage mcp =new MyaccountPage (driver);
		mcp.clickLogout();
		
		}
		catch(Exception e) {
			
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
		
		
	}
	
	@Test
	public void test_account_Registration1()throws InterruptedException{
		
		logger.info("******** Starting TC_001_ AccountRegistration Test ****");

		try{HomePage hm = new HomePage(driver);
		
		hm.clickMyAccount();
		
		logger.info("Clicked on My account link");
		hm.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
	/**	regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomAlphaNumeric()+"@gmail.com");
		regpage.settelephone(randomeNumber());
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();  **/
		regpage.clickContinue();
		
		logger.info("Clicked on continue");
		
		String confmsg = regpage.errorgetConfirmationMsg();
		String fcnfmsg = regpage.firstnameerrormsg();
		
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg,"Warning: You must agree to the Privacy Policy!");
		Assert.assertEquals(fcnfmsg,"First Name must be between 1 and 32 characters!");
		
		System.out.println("test success");
		}
		catch(Exception e) {
			
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");	
	}
	
}
