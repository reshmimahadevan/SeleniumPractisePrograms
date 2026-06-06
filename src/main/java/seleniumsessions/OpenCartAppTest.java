package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public class OpenCartAppTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();

		WebDriver driver = bu.initDriver("chrome");

		// bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// URL url = new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//Throws MalformedURLException -> it does'nt even go to our customed exception if added with "throws MalformedURLException"
		//Create Custom Exception here if you don't want to add throw
		URL url;
		try {
			url = new URL("naveenautomationlabs.com/opencart/index.php?route=account/login");
		} catch (MalformedURLException e) {
			System.out.println("Http is missing");
			e.printStackTrace();
			throw new RuntimeException("Http is missing");
		}

		bu.launchURL(url);

		// bu.launchURL("null");

		String title = bu.getPageTitle();

		if (title.equals("Account Login")) {
			System.out.println("Title is correct -- PASS");
		}

		else {
			System.out.println("Title is not correct -- FAIL");
		}

		String actURL = bu.getPageURL();
		if (actURL.contains("route=account/login")) {
			System.out.println("Login page url is correct -- PASS");
		} else {
			System.out.println("Login page url is not correct -- FAIL");
		}

		bu.quitBrowser();

	}

}
