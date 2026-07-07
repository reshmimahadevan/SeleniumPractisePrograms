package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitle {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Free Trial"));		
//		System.out.println(driver.getTitle());

		String title = waitFotTitleContains("Free Trial", 5);
		System.out.println(title);
	}

	public static String waitFotTitleContains(String fractionTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		//If you write it in ifelse condition then it will not return null in case of else
		//It will return timeout exception similiar to isDisplayed()
        //So handle it using try catch so it returns null
		
		try {
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}

	public static String waitFotTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}

}
