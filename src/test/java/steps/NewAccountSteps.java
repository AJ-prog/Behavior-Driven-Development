package steps;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.NavegatorPage;
import pages.NewAccountPage;

public class NewAccountSteps extends Stepbase {
	// creating global varibale
	WebDriver driver;
	LoginPage loginpage;
	NavegatorPage navegatpage;
	NewAccountPage newAccountPage;

//	@Before    >>>>this hook method comitted so i can run another step class<<<<
//	public void starttfirst() { // this method will automatic gets called
//		driver = BrowserFactory.Startbrowser(); // passing the driver
//		loginpage = PageFactory.initElements(driver, LoginPage.class); // access the login page
//		navegatpage = PageFactory.initElements(driver, NavegatorPage.class);// access sidenavigat page
//		newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);// access newaccountpage
//		listaccountpage=PageFactory.initElements(driver, ListAccountsPage.class);
//	}

	@Given("^a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_user_with_username_and_password(String userName, String passwrod) throws InterruptedException { // passwordThread.sleep(2000);
		loginpage.login(userName, passwrod);
	}
	// >>>>this database method comitted so it wont interact with Given method,it is
	// still good to use I tried both ways<<<
//	@And("^a user with valid credentials$")
//	public void a_user_with_valid_credentials() throws InterruptedException, ClassNotFoundException, SQLException {
//		Thread.sleep(2000);
//		loginpage.login(Database.get("username"), Database.get("password"));
//		Thread.sleep(3000);
//	}

	@When("^user navigates to New Account Page$")
	public void user_navigates_to_New_Account_Page() throws InterruptedException {
		navegatpage.goToNewAccountPage();
	}

	@And("^user create new account using title \"([^\"]*)\" Description \"([^\"]*)\" Amount \"([^\"]*)\"$")
	public void user_create_new_account_using_title_Description_Amount(String title, String description, String balance)
			throws InterruptedException {
		Thread.sleep(1000);
		newAccountPage.inputNewAccount(title + (new Random().nextInt(999)));
		newAccountPage.inputDescription(description);
		newAccountPage.initialBalance(balance);
		newAccountPage.clickOnSubmitButton();

	}

	@Then("^new account page should display$")
	public boolean new_account_page_should_display() {
		try {
			screenShot(driver, "C://ScreenShots//panel.jpg");
			return newAccountPage.isPanelHeaderDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue("Page did not display", newAccountPage.isPanelHeaderDisplayed());
		return false;
	}

	@After
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
