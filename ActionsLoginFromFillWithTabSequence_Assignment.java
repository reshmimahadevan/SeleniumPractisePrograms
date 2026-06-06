package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsLoginFromFillWithTabSequence_Assignment {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement email = driver.findElement(By.cssSelector("#input-email"));

		Actions act  = new Actions(driver);

		Action loginAction = act.sendKeys(email, "gh@gmail.com").pause(200).sendKeys(Keys.TAB).pause(200).sendKeys("Reshmi@123")
				.pause(200).sendKeys(Keys.TAB).pause(200).sendKeys(Keys.TAB).pause(200).sendKeys(Keys.ENTER).build();

		performLoginAction(loginAction);

	}

	public static void performLoginAction(Action action) {
		action.perform();
	}

}
