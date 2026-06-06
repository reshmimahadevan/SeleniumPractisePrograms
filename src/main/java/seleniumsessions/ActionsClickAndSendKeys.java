package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Actions act = new Actions(driver);

		WebElement fn = driver.findElement(By.id("input-firstname"));
		WebElement checkBox = driver.findElement(By.name("agree"));

		// Used in the case of Overlapping elements in webpages/Chatbot window/cookie banner

		// Equivalent to calling: Actions.click(element).sendKeys(keysToSend)
		// SendKeys overloaded method
		act.sendKeys(fn, "testing").perform();

		// Clicks in the middle of the given element.
		// Equivalent to: Actions.moveToElement(onElement).click()
		// Click overloaded method
		act.click(checkBox).perform();

	}

	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
