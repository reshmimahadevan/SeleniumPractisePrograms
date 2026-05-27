package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {
		
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initDriver("firefox");
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(bu.getPageTitle());
		
		By emailFeild = By.id("input-email");
		By passwordFeild = By.id("input-password");
		
		ElementUtils eliUtil = new ElementUtils(driver);
		eliUtil.doSendKeys(emailFeild, "re@gmail.com");
		eliUtil.doSendKeys(passwordFeild, "re@123");
		
		bu.quitBrowser();

	}

}
