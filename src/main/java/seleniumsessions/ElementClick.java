package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClick {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Create WebElement + Action(Click) Button,Link,Checkbox,RadioButton,Image

		// driver.findElement(By.linkText("Register")).click();

		// driver.findElement(By.name("agree")).click();

		By registerLink = By.linkText("Register");
		By agreeCheckBox = By.name("agree");
		
		ElementUtils eu = new ElementUtils(driver);
		
		eu.doClick(registerLink);
		eu.doClick(agreeCheckBox);

	}

	}
