package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		// WebDriverWait(C)[no methods] --> FluentWait(C)[until(){}, other methods] -->
		// Wait(I): until();

		// WebDriverWait IS - A FluentWait

		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/");

		By username = By.name("username");

		waitForElementVisibleWithFluentWait(username, 10, 2).sendKeys("testautomation");

	}
	
	//Default polling time - 500 ms

	public static WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage("===Element is not found====");

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage("===Element is not found====");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
																																								