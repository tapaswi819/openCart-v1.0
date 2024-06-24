package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath=("//input[@id='input-email']"))
	WebElement txt_emaiAddres ;

	@FindBy(xpath=("//input[@id='input-password']"))
	WebElement txt_Password ;

	@FindBy(xpath=("//input[@value='Login']"))
	WebElement btn_login ;


	public void setEmail(String email) {
		txt_emaiAddres.sendKeys(email);
	}

	public void setPassword (String  password) {
		txt_Password.sendKeys( password);
	}


	public void clickLogin() {
		btn_login.click();
	}







	}


