package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_01_AccountRegistrationPage extends BaseClass {

	@Test (groups= "Sanity")
	 public void verify_accoun_registation() {

		logger.info("***Statred TC_01_AccountRegistrationPage ****** ");
		try
		{

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");

		hp.clickRegistration();
		logger.info("Clicked on Register Link.. ");


		AccountRegistrationPage regpage = new AccountRegistrationPage(driver) ;
		logger.info("Providing customer details...");

			 regpage.setFirstName(randomeString().toUpperCase());
			 regpage.setLastName(randomeString().toUpperCase());
			 regpage.setEmail(randomeString()+"@gmail.com");
			 regpage.setTelePhonenum(randomeNumber());

			 String password =randomAlphaNumeric();
			 regpage.setPassword(password);
			 regpage.setConfpassword(password);


			 regpage.setPriovcypolice();
			 regpage.clickContinue();

			 logger.info("Validating expected message..");

			 String confirmation =regpage.getConfirmationMsg();
			 Assert.assertEquals(confirmation,"Your Account Has Been Created!");
			 logger.info("Test passed");


		}
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
		finally
		{
		logger.info("***** Finished TC_01_AccountRegistrationPage *****");
		}
	}
	}



