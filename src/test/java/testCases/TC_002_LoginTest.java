package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= "Regression")
	public void verify_login() {
		logger.info("*** Started TC_002_LoginTest ***");
		logger.debug("capturing application logs");
		try {

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		logger.info("Login page");
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();


		logger.info("My Account Page");

		MyAccountPage map = new MyAccountPage(driver);
	boolean targetpage =	map.isMyAccountisExists();
	Assert.assertTrue(targetpage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}

	logger.info("**** Finished TC_002_LoginTest  ****");


	}

}
