package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Real Use Case: Address
public class SendKeysConcept {

	static WebDriver driver;

	public static void main(String args[]) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement firstName = driver.findElement(By.id("input-firstname"));

		String fN = "Testing";
		String lN = "Automation";
		StringBuilder sb = new StringBuilder("Selenium");
		StringBuffer sbf = new StringBuffer("Learning");

		// Three dot paramter in sendkeys means allowing us to sent value through comma
		// seperated ones
		// ... -> Char Sequence Array
		firstName.sendKeys(fN, ",", lN, " ", sb, " ", sbf);

		ElementUtils eu = new ElementUtils(driver);

		// You cannot send null it will give IllegalArgument Exception
		eu.doSendKeys(By.name("lastname"), null);

	}

}
