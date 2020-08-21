package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmailMessageLogPage;
import pages.LoginPage;
import pages.NavegatorPage;
import utill.BrowserFactory;

public class EmailMessageLogSteps extends Stepbase {
	WebDriver driver;
	LoginPage loginpage;
	NavegatorPage navegatpage;
	EmailMessageLogPage emailmessagelogpage;
	String userName = "demo@techfios.com";
	String password = "abc123";

	@Before
	public void startfirst() { // this method will automatic gets called
		driver = BrowserFactory.Startbrowser(); // passing the driver
		loginpage = PageFactory.initElements(driver, LoginPage.class); // access the login page
		emailmessagelogpage = PageFactory.initElements(driver, EmailMessageLogPage.class);
	}

	@Given("^valid user$")
	public void valid_user() {
		loginpage.login(userName, password);
	}

	@When("^user navigate to utilities$")
	public void user_navigate_to_utilities() {
		emailmessagelogpage.clickOnUtilitiesButton();
	}

	@When("^user navigate to email message log$")
	public void user_navigate_to_email_message_log() {
		emailmessagelogpage.clickOnEmailMessageButton();
	}

	@And("^user views email details$")
	public void user_views_email_details() {
		emailmessagelogpage.clickOnViewButton();
	}

	@Then("^email details should display$")
	public void email_details_should_display() throws InterruptedException {
		Thread.sleep(2000);
		String expectedResult = "Utilities";
		boolean actualResult = emailmessagelogpage.isUtilitiesPageDisplaied();
		Assert.assertEquals("Utilities page did not displaied", expectedResult, actualResult);
		try {
			screenShot(driver, "C://ScreenShots//emailshot.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
