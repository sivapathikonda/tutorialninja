package com.tutorialninja.input;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginwithdetails {
	WebDriver rdriver;
	public loginwithdetails(WebDriver ldriver) {
		this.rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	@FindBy(linkText="Login")
	WebElement ClickOnLoginButton;
	@FindBy(id="input-email")
	WebElement EnterEmailid;
	@FindBy(id="input-password")
	WebElement EnterPassword;
	@FindBy(xpath="//input[@class=\"btn btn-primary\"][@value=\"Login\"]")
	WebElement ClickOnBTNButton;
	
	public void EnterTheDetailsOfLogin(String Email,String Password) {
		ClickOnLoginButton.click();
		EnterEmailid.sendKeys(Email);
		EnterPassword.sendKeys(Password);
		ClickOnBTNButton.click();
		
		
		
		
	}

}
