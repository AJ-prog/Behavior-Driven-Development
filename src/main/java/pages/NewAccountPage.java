package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add New Account')]")
	WebElement PanelHeaderElement;
	@FindBy(how = How.ID, using = "account")
	WebElement AccountTitleField;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionField;
	@FindBy(how = How.ID, using = "balance")
	WebElement InitialBalanceField;
	@FindBy(how = How.XPATH, using = "//label[text()='Initial Balance']/../following-sibling::button")
	WebElement SubmitButton;

	public void waitForFormToDisplay() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("account")));

	}

	public void inputNewAccount(String title) {
		AccountTitleField.sendKeys(title);

	}

	public void inputDescription(String description) {
		DescriptionField.sendKeys(description);

	}

	public void initialBalance(String balance) {
		InitialBalanceField.sendKeys(balance);

	}

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}

	public boolean isPanelHeaderDisplayed() {
		try {
			return PanelHeaderElement.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
