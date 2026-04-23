package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserLogic {

	// static WebDriver driver;

	public static void main(String[] args) {

		String browser = "Reshmi";

		WebDriver driver = null;

		switch (browser.trim().toLowerCase()) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "Safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser.. " + browser);
			//Without throw it will give us Null pointer Exception 
			throw new RuntimeException("Invaid Browser");
			
		}

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
