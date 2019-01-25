package com.benleadbeater.ATExercise;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppTest {

	public WebDriver driver;
	public static ExtentTest test;
	private static ExtentReports report;
	public WebElements element = PageFactory.initElements(driver, WebElements.class);

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", VariableStorage.ChromeLocation);
		report = new ExtentReports(VariableStorage.ReportLocation, false);
		test = report.startTest("Verify Application Title");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
		report.flush();
	}
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
	    driver.manage().window().maximize();
		driver.get("localhost:3000");
		test.log(LogStatus.INFO,"Navigate to Website");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
		element.ClickFormButton();
		test.log(LogStatus.INFO,"Navigate to Form");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	@Ignore
	public void i_fill_click_the_dropdown_menu(String arg1) {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
	    element.SelectCountry(arg1);
	    test.log(LogStatus.INFO,"Select Country");
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
	    element.EnterEmail(arg1);
	    test.log(LogStatus.INFO,"Fill Email");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
	    element.EnterPass1(arg1);
	    test.log(LogStatus.INFO,"Fill First Password");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
		element.EnterPass2(arg1);
		test.log(LogStatus.INFO,"Fill Second Password");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
		assertEquals("Success!", element.SuccessCheck());
		test.log(LogStatus.PASS,"Log In Sucessful");
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) throws Throwable {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
	    element.EnterPass2(arg1);
	    test.log(LogStatus.INFO,"Fill Incorrect Second Password");
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		WebElements element = PageFactory.initElements(driver, WebElements.class);
		assertEquals("The passwords do not match", element.PasswordMisMatch());
		test.log(LogStatus.PASS,"Passwords Don't Match");
	}
}