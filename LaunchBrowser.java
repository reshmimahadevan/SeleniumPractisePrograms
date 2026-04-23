package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String args[]) {

		// Launch Browser:Chrome
		ChromeDriver driver = new ChromeDriver();
		// FirefoxDriver driver = new FirefoxDriver();
		// EdgeDriver driver = new EdgeDriver();

		// Enter the URL
		driver.get("https://www.google.com");

		// Get the Title of the Page
		String browserTitle = driver.getTitle();
		System.out.println("The title of the page is " + browserTitle);

		// Validation
		// Automation steps + Chekpoint = Automation Testing
		if (browserTitle.equals("Google")) {
			System.out.println("Title is correct: PASS");
		} else {
			System.out.println("Title is not correct: FAIL");
		}

		// Close the Browser
		driver.quit();
		// driver.close();
	}

}
