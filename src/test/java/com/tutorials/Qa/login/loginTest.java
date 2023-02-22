package com.tutorials.Qa.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.input.loginwithdetails;
import com.tutorialninja.qA.utiliy.utillity;


public class loginTest {
public	WebDriver driver;

	utillity put=new utillity();
	
	
	@BeforeMethod
	public void setup()
	{
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		
	
	}
	@AfterMethod
	public void destory()
	{
		driver.quit();
	}
	@Test
	
	public void RegisterWithAll() {
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("siva");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(utillity.GenerateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("12345789");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String ActualSucessHeading=driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(ActualSucessHeading,"Your Account Has Been Created!","register not successed" );
	}
	@Test
	public void verifyREgisterWithProvedingAllTheFeilds() {
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("siva");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys("siva85744@gmal.com");
		driver.findElement(By.id("input-telephone")).sendKeys("12345789");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=\"1\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String ActualSucessHeading=driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(ActualSucessHeading,"Register Account","register not successed" );
	}
	@DataProvider
	public Object[][] ApplyTEStDATA(){
		Object[][] Data= utillity.GetDAtaFromExcelSheet("login");
		return Data;
	}
	@Test
	public void VerifyRegisteringAccountWithExistingEmail() {
		
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("siva");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys("siva85744@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("12345789");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String ActualSucessHeading=driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		Assert.assertTrue(ActualSucessHeading.contains("Warning: E-Mail Address is already registered!"));
		
	}
	@Test
	
	
	public void VerifyingRegisterAccountWithoOutFillingAnyDetails() {
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String ActualPrivacyPolicyWarning=driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertTrue(ActualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"not match");
		
		String ActualFirstNameWarning=driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		Assert.assertEquals(ActualFirstNameWarning,"First Name must be between 1 and 32 characters!" );
	}
	
	@Test
	public void loginWithValueCradential() {
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		loginwithdetails s1=new loginwithdetails(driver);

		s1.EnterTheDetailsOfLogin("pathikondasiva1512@gmail.com","1234");
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}
	@Test
	
	public void VerifySearchWithValidProduct() {
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.name("search")).sendKeys("hp");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("P LP3065")).isDisplayed());
	}
}
	
	
	
	
	
	
	
	
	
	
	
	



