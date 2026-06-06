package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringLocator {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String firstName_ID = "input-firstname";
		String lastName_ID = "input-lastname";
		String email_Name = "email";
		String telephone_Xpath = "//input[@placeholder='Telephone']";
		String checkBox_name = "agree";

		getElement("ID", firstName_ID).sendKeys("Reshmi");
		getElement("ID", lastName_ID).sendKeys("Mahadevan");
		getElement("NAME", email_Name).sendKeys("reshmi@gmail.com");
		getElement("XPATH", telephone_Xpath).sendKeys("8888888");

		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doClick("NAME", checkBox_name);
		eleUtil.doSendKeys("ID", firstName_ID, "Sudha");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public static By getBy(String locatorType, String locatorValue) {

		By locator = null;

		switch (locatorType.toUpperCase()) {
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "CLASS":
			locator = By.className(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;
		case "CSS":
			locator = By.cssSelector(locatorValue);
			break;
		case "LINKTEXT":
			locator = By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("plz pass the right locator type: " + locatorType);
			break;
		}

		return locator;

	}

}
