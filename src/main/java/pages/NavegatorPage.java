package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavegatorPage {
	WebDriver driver;
	public NavegatorPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")
	WebElement BankCashModule;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement NewAccountPage;        
	@FindBy(how = How.LINK_TEXT, using = "List Accounts")
	WebElement ListAccountPage;
	
	public void goToNewAccountPage() throws InterruptedException {
		Thread.sleep(2000);
		BankCashModule.click();
		NewAccountPage.click();
		Thread.sleep(2000);
	}
	
	public void goToListAccountPage() throws InterruptedException {
		ListAccountPage.click();
	}
	
}

