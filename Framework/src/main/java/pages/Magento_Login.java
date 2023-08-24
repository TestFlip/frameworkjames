package pages;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ie.curiositysoftware.testmodeller.TestModellerModule;
import utilities.reports.ExtentReportManager;
import utilities.testmodeller.TestModellerLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;

// http://ec2-35-178-43-81.eu-west-2.compute.amazonaws.com:80/app/#!/module-collection/guid/8f8370ee-1d4f-4471-b7ad-09feefa50d9c
@TestModellerModule(guid = "8f8370ee-1d4f-4471-b7ad-09feefa50d9c")
public class Magento_Login extends BasePage
{
	public Magento_Login (WebDriver driver)
	{
		super(driver);
	}


	
	private By EmailElem = By.xpath("//label[normalize-space()= 'Email']/../div/input");

	private By Incorrect_LoginElem = By.xpath("//DIV[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]");

	private By Invalid_EmailElem = By.xpath("//DIV[@id='email-error']");

	private By Invalid_PasswordElem = By.xpath("//DIV[@id='pass-error']");

	private By PasswordElem = By.xpath("//INPUT[@title='Password']");

	private By Signin_ButtonElem = By.xpath("//FIELDSET[@class='fieldset login']/DIV[@class='actions-toolbar']/DIV[@class='primary']/BUTTON[@id='send2']");


	
     
	/**
 	 * Assert Incorrect Login
     * @name Assert Incorrect Login
     */
	public void Assert_Incorrect_Login()
	{
	    
		WebElement elem = getWebElement(Incorrect_LoginElem);

		if (elem == null) {
			Assert.fail("Unable to locate object: " + Incorrect_LoginElem.toString());
        }
        
	}
     
	/**
 	 * Assert Invalid Email
     * @name Assert Invalid Email
     */
	public void Assert_Invalid_Email()
	{
	    
		WebElement elem = getWebElement(Invalid_EmailElem);

		if (elem == null) {
			Assert.fail("Unable to locate object: " + Invalid_EmailElem.toString());
        }
        
	}
     
	/**
 	 * Assert Invalid Password
     * @name Assert Invalid Password
     */
	public void Assert_Invalid_Password()
	{
	    
		WebElement elem = getWebElement(Invalid_PasswordElem);

		if (elem == null) {
			Assert.fail("Unable to locate object: " + Invalid_PasswordElem.toString());
        }
        
	}
     
	/**
 	 * AssertUrl
     * @name AssertUrl
     */
   public void AssertUrl()
    {
        String currentUrl = m_Driver.getCurrentUrl();
        String expectedUrl = "https://magento.testinsights.io/customer/account/login";

        if (!currentUrl.equals("https://magento.testinsights.io/customer/account/login")) {
            Assert.fail("Expecting URL - "  + expectedUrl + " Found " + currentUrl);
        }
    }

      
	/**
 	 * Click Signin Button
     * @name Click Signin Button
     */
    public void Click_Signin_Button()
    {
         
        WebElement elem = getWebElement(Signin_ButtonElem);

        if (elem == null) {
            ExtentReportManager.failStepWithScreenshot(m_Driver, "Click_Signin_Button", "Click_Signin_Button failed. Unable to locate object: " + Signin_ButtonElem.toString());

            TestModellerLogger.FailStepWithScreenshot(m_Driver, "Click_Signin_Button", "Click_Signin_Button failed. Unable to locate object: " + Signin_ButtonElem.toString());

            Assert.fail("Unable to locate object: " + Signin_ButtonElem.toString());
         }

        elem.click();
         

        ExtentReportManager.passStepWithScreenshot(m_Driver, "Click_Signin_Button");

        TestModellerLogger.PassStepWithScreenshot(m_Driver, "Click_Signin_Button");
    }
      
	/**
 	 * Enter Email
     * @name Enter Email
     */
 	public void Enter_Email(String Email)
 	{
 	    
 		WebElement elem = getWebElement(EmailElem);

 		if (elem == null) {
    		ExtentReportManager.failStepWithScreenshot(m_Driver, "Enter_Email", "Enter_Email failed. Unable to locate object: " + EmailElem.toString());

    		TestModellerLogger.FailStepWithScreenshot(m_Driver, "Enter_Email", "Enter_Email failed. Unable to locate object: " + EmailElem.toString());

 			Assert.fail("Unable to locate object: " + EmailElem.toString());
         }

 		elem.sendKeys(Email);
 		

  		ExtentReportManager.passStep(m_Driver, "Enter_Email " + Email);

  		TestModellerLogger.PassStep(m_Driver, "Enter_Email " + Email);
 	}

      
	/**
 	 * Enter Password
     * @name Enter Password
     */
 	public void Enter_Password(String Password)
 	{
 	    
 		WebElement elem = getWebElement(PasswordElem);

 		if (elem == null) {
    		ExtentReportManager.failStepWithScreenshot(m_Driver, "Enter_Password", "Enter_Password failed. Unable to locate object: " + PasswordElem.toString());

    		TestModellerLogger.FailStepWithScreenshot(m_Driver, "Enter_Password", "Enter_Password failed. Unable to locate object: " + PasswordElem.toString());

 			Assert.fail("Unable to locate object: " + PasswordElem.toString());
         }

 		elem.sendKeys(Password);
 		

  		ExtentReportManager.passStep(m_Driver, "Enter_Password " + Password);

  		TestModellerLogger.PassStep(m_Driver, "Enter_Password " + Password);
 	}

	public void GoToUrl()
	{
		m_Driver.get("https://magento.testinsights.io/customer/account/login");

		ExtentReportManager.passStepWithScreenshot(m_Driver, "Go to URL", "Go to URL - https://magento.testinsights.io/customer/account/login");

		TestModellerLogger.PassStepWithScreenshot(m_Driver, "Go to URL", "Go to URL - https://magento.testinsights.io/customer/account/login");
	}
}