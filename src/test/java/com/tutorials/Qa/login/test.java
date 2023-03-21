package com.tutorials.Qa.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class test {
	WebDriver driver;
	
	public test(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);}
		
}

