package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUseCases {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// No Such Element Exception
		// If you don't want error you can create a wrapper class using try catch block
		// and make it return true/false
		// Refer ElementUtils - isDisplayed()
		// WebElement ele = driver.findElement(By.id("input-email11"));

		// List<WebElement> eleList1 = driver.findElements(By.className("test-reshmi"));
		// System.out.println(eleList1); // Empty Array
		// System.out.println(eleList1.size()); // 0

		// List<WebElement> eleList2 = driver.findElements(By.id("input-email"));
		// System.out.println(eleList2.size()); // 1

		By emailId = By.id("input-email");
		System.out.println(checkSingleElementDisplayed(emailId));

		By forgotPwdLink = By.linkText("Forgotten Password");
		if(checkElementDisplayed(forgotPwdLink, 2))
		{
			System.out.println("Forgot Password is coming 2 times on the page");
		}

	}

	public static boolean checkSingleElementDisplayed(By locator) {
		if (getElements(locator).size() == 1) {
			System.out.println("Element : " + locator + " is displayed on the page one time");
			return true;
		}
		return false;
	}

	public static boolean checkElementDisplayed(By locator, int expElementCount) {
		if (getElements(locator).size() == expElementCount) {
			System.out.println("Element : " + locator + " is displayed on the page " + expElementCount + " times");
			return true;
		}
		return false;
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

}
