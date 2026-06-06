package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSendKeysWithPause {
	
//  SendKeys Overloaded method with a pause	

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//      WebElement firstName = driver.findElement(By.id("input-firstname"));

//      CharSequence: String, StringBuffer, StringBuilder
//		Actions act = new Actions(driver);
//
//		String value = "naveenautomation";
//		
//		char val[] = value.toCharArray();
//		for(char ch : val) {//n->"n"
//			act.sendKeys(firstName, String.valueOf(ch)).pause(500).perform();
//		}

		By firstname = By.id("input-firstname");
		doSendKeysWithPause(firstname, "Reshmi Mahadevan", 200);
	}

	public static void doSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(driver);

		char val[] = value.toCharArray();
		for (char ch : val) {// n->"n"
			act
			.sendKeys(getElement(locator), String.valueOf(ch))
			  .pause(pauseTime)
			    .perform();
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}