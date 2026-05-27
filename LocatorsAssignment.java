package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorsAssignment {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil util = new BrowserUtil();

		WebDriver driver = util.initDriver("chrome");

		ElementUtils eu = new ElementUtils(driver);

		util.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		util.getPageTitle();

		util.getPageURL();

		// 1.ID
		By firstName = By.id("input-firstname");

		eu.doSendKeys(firstName, "Reshmi");
	

		// 2.Name
		By lastName = By.name("lastname");

		eu.doSendKeys(lastName, "M");

		// ID
		By email = By.id("input-email");

		eu.doSendKeys(email, "m3@gmail.com");

		// 3.xpath
		By phoneNo = By.xpath("//*[@id=\"input-telephone\"]");

		eu.doSendKeys(phoneNo, "9867574736");

		// 4.css
		By password = By.cssSelector("#input-password");

		eu.doSendKeys(password, "re@123");

		By confirmPassword = By.cssSelector("#input-confirm");

		eu.doSendKeys(confirmPassword, "re@123");

		// Name
		By click1 = By.name("agree");

		eu.doClick(click1);

		// 5.Class
		By click2 = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");

		eu.doClick(click2);

		// 7.Tag Name
		By tagName = By.tagName("h1");
		String header = eu.getText(tagName);
		System.out.println(header);
		if (header.equals("Your Account Has Been Created!")) {
			System.out.println("Test is PASS");
		} else {
			System.out.println("Test is FAIL");
		}

		util.getPageTitle();

		String pageUrl1 = util.getPageURL();

		if (pageUrl1.contains("success")) {
			System.out.println("Registration is successfully done");
		}

		else {
			System.out.println("Registration not done successfully");
		}

		// 6.Link text/Partial Link Text
		// By linkText = By.linkText("Logout");

		// eu.doClick(linkText);

		By partialLinkText = By.partialLinkText("og");
		
		eu.doClick(partialLinkText);

		util.getPageTitle();

		String pageUrl2 = util.getPageURL();

		if (pageUrl2.contains("logout")) {
			System.out.println("Test is PASS");
		} else {
			System.out.println("Test is FAIL");
		}

		util.quitBrowser();

	}

}
