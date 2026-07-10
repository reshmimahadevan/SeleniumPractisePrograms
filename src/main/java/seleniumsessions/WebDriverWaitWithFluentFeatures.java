package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentFeatures {

	static WebDriver driver;

	public static void main(String[] args) {

		// WebDriverWait(C)[no methods] --> FluentWait(C)[until(){}, other methods] -->
		// Wait(I): until();

		// WebDriverWait IS - A FluentWait

		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/");

		//Refer TimeUtil.java 
		TimeUtil.shortWait();

		By username = By.name("username");
		
		//Topcasting also possible
		//With Timeout and PollingTime
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
				.withMessage("===Element is not found====");

		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("testautomation");

	}

}
