package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefException {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// browser

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");// page DOM-v1

		// DOM v1 -
		// f.A0700EF4C21F7DAB4D9CDD1A5AE41CB1.d.0BF9E2F35383A93F1B1919B731872539.e.3
		// session ID
		WebElement firstname = driver.findElement(By.id("input-firstname"));

		// DOM v1
		firstname.sendKeys("reshmi@gmail.com");

		// refresh, back and forward
		// All refreshes the page
		driver.navigate().refresh();
		// driver.navigate().back();
		// driver.navigate().forward();

		// DOM v2
		// The moment you re-initialize a new session id will be
		// created->f.A0700EF4C21F7DAB4D9CDD1A5AE41CB1.d.762A3DC8A2D471FDDACB4C202D0B3FA7.e.256
		// So no stale element comes
		// Uncomment below to get StaleElement Exception
		firstname = driver.findElement(By.id("input-firstname"));

		// Dom v2
		firstname.sendKeys("bhavika@gmail.com");

	}

}
