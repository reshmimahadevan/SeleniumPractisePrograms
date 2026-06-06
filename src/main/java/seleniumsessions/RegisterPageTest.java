package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageTest {

	public static void main(String[] args) {
		
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initDriver("edge");
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		System.out.println(bu.getPageTitle());
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone= By.id("input-telephone");
		By password = By.id("input-password");
		By passwordConfirm = By.id("input-confirm");
		
		ElementUtils eu = new ElementUtils(driver);
	
		eu.doSendKeys(firstName, "Reshmi");
		eu.doSendKeys(lastName, "Mahadevan");
		eu.doSendKeys(email, "re@gmail.com");
		eu.doSendKeys(telephone, "9878675678");
		eu.doSendKeys(password, "re@123");
		eu.doSendKeys(passwordConfirm, "re@123");
		
		bu.quitBrowser();
		
        
		
	}

}
