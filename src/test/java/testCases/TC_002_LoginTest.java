package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	

	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		
	
		logger.info("Starting TC_002_LoginTest");
		
		try {
		HomePage hm = new HomePage(driver);
		
		
		hm.clickMyAccount();
		logger.info("clicked on my account");
		hm.clicklogin();
		logger.info("clicked on login");
		
		Loginpage lp = new Loginpage(driver);
		
		lp.setemail(rb.getString("email"));
		logger.info("email entered");
		lp.setPasswrd(rb.getString("password"));
		logger.info("password entered");
		
		lp.clicklogin();
		
		MyaccountPage macc = new MyaccountPage(driver);
		
		boolean target = macc.isMyAccountPageExists();
		
		Assert.assertEquals(target, true);
		
	}
	
	catch (Exception e) {
		Assert.fail();
	}
	
	logger.info("Finished TC_002_LoginTest");
	}
	
	
	
}
