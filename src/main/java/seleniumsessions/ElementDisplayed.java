package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String args[]) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// WebElement firstName = driver.findElement(By.id("input-firstname"));

		// The output will not be false it will give NoSuchElement Exception

		// WebElement firstName = driver.findElement(By.id("input-firstname11"));

		// boolean b1 = firstName.isDisplayed();

		// System.out.println(b1); // true

		// The output is still not be false as it will give NoSuchElement Exception
		// boolean b2 = driver.findElement(By.id("input-firstname11")).isDisplayed();

		// System.out.println(b2);

		// The output is still not be false as it will give NoSuchElement Exception

		By fn = By.id("input-firstname11");

		ElementUtils eu = new ElementUtils(driver);

		if (eu.isElementDisplayed(fn)) {
			System.out.println("Element is Displayed - PASS");
		} else {
			System.out.println("Element is Not Displayed - FAIL");
		}
		
		By logo = By.className("img-responsive");
		
		System.out.println(eu.isElementDisplayed(logo));
		
	}
}
