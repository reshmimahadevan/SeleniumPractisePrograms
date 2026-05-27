package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//Ec to debug/Reusability code
public class BrowserUtil {

	// Making it private as no one can access it outside of the class
	// Not making it static as driver will be stored in CMA and there only
	// sequential execution will be allowed(1 thread accessing 1 method) parallel
	// execution can't be done
	private WebDriver driver;

	/**
	 * This is used to Initialize Driver on the basis of given browser name :
	 * chrome/firefox/edge/safari
	 * 
	 * @param browserName
	 * @return it return driver
	 */
	public WebDriver initDriver(String browserName) {

		System.out.println("BrowserName is " + browserName);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;					
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser name");
			throw new BrowserException("*****Invalid Browser*****");
		}

		return driver;
	}

	public void launchURL(String url) {

		nullCheck(url);

		lengthCheck(url);

		httpCheck(url);

		driver.get(url);
	}

	public void launchURL(URL url) {

		String appUrl = String.valueOf(url);

		nullCheck(appUrl);

		lengthCheck(appUrl);

		httpCheck(appUrl);

		driver.navigate().to(appUrl);
	}

	private void lengthCheck(String value) {
		if (value.length() == 0) {
			System.out.println("Please pass the right URL " + value);
			throw new BrowserException("*****Empty Value*****");
		}

	}

	private void httpCheck(String value) {
		if (value.indexOf("http") != 0) {
			System.out.println("http is missing in the url " + value);
			throw new BrowserException("*****HTTP is missing the URL*****");
		}
	}

	private void nullCheck(String value) {
		if (value == null) {
			System.out.println("Value cannot be null " + value);
			throw new BrowserException("*****Value is null*****");
		}
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page Title is " + title);
		return title;
	}

	public String getPageURL() {
		String pageURL = driver.getCurrentUrl();
		System.out.println("The Page URL is " + pageURL);
		return pageURL;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser is closed");
		}
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is quit");
		}
	}
}