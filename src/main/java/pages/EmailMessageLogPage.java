package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailMessageLogPage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public EmailMessageLogPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[13]/a/span[1]")
	WebElement UTILITIES_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[13]/ul/li[2]/a")
	WebElement EMAIL_MESSAGE_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sys_logs\"]/tbody/tr/td[5]/a")
	WebElement VIEW_BUTTON;
	@FindBy(how=How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement UTILITIES_LOCATOR;

	public void waitForEmailPageToDisplay() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("@id=\"page-wrapper\"]/div[2]/div/h2")));

	}

	public void clickOnUtilitiesButton() {
		UTILITIES_BUTTON.click();
	}

	public void clickOnEmailMessageButton() {
		EMAIL_MESSAGE_BUTTON.click();
	}

	public void clickOnViewButton() {
		VIEW_BUTTON.click();
	}
	
	public boolean isUtilitiesPageDisplaied() {
		return UTILITIES_LOCATOR.isDisplayed();
		
	}

}