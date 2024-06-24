package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}



	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telnumber;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_cpassword;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_agree;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	public void setFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}

	public void setEmail(String mail) {
		txt_email.sendKeys(mail);
	}
	public void setTelePhonenum (String telnum)
	{
		txt_telnumber.sendKeys(telnum);
	}
	public void setPassword (String pwd) {
		txt_password.sendKeys(pwd);
	}
   public void setConfpassword (String cpwd) {
	   txt_cpassword.sendKeys(cpwd);
   }
   public void setPriovcypolice() {
	   chk_agree.click();
   }
   public void clickContinue() {

	   btn_continue.click();


   }


   public String getConfirmationMsg() {
	   try {
		   return(msgConfirmation.getText());
	   }
	   catch (Exception e) {
		   return (e.getMessage());


	   }

	   }
   }

