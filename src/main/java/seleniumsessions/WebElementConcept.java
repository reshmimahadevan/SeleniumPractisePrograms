package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// create a webelement(FE)+Actions(click,sendkeys,isDisplayed,sendText...)

		// 1.
		// driver.findElement(By.id("input-email")).sendKeys("re@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("re@123");

		// 2.
		// WebElement email = driver.findElement(By.id("input-email"));
		// WebElement password = driver.findElement(By.id("input-password"));
		//
		// email.sendKeys("re@gmail.com");
		// password.sendKeys("re@123");

		// 3.By Locator:
		// This is the best as we are maintaining the elements and then we hit the
		// neccessary elements to the server
		// By emailFeild = By.id("input-email");
		// By passwordFeild = By.id("input-password");
		//
		// WebElement email = driver.findElement(emailFeild);
		// WebElement password = driver.findElement(passwordFeild);
		//
		// email.sendKeys("re@gmail.com");
		// password.sendKeys("re@123");

		// 4.By Locator + Genric function to get the element
		// By emailFeild = By.id("input-email");
		// By passwordFeild = By.id("input-password");

		// getElement(emailFeild).sendKeys("re@gmail.com");
		// getElement(passwordFeild).sendKeys("re@123");

		// 5.By Locator + Genric function to get the element and perfome action
		// By emailFeild = By.id("input-email");
		// By passwordFeild = By.id("input-password");

		// doSendKeys(emailFeild, "re@gmail.com");
		// doSendKeys(passwordFeild, "re@123");

		// 6.By Locator + Genric function to get the element and perfome action - ElementUtil
		By emailFeild = By.id("input-email");
		By passwordFeild = By.id("input-password");

		ElementUtils eu = new ElementUtils(driver);

		eu.doSendKeys(emailFeild, "re@gmail.com");
		eu.doSendKeys(passwordFeild, "re@123");

		// 7.BrowserUtil + ElementUtil -> LoginPageTest.java

	}

	// public static void doSendKeys(By locator, String value) {
	// getElement(locator).sendKeys(value);
	// }

	// public static WebElement getElement(By locator) {
	// return driver.findElement(locator);
	// }

}
