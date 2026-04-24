package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateURL {

	public static void main(String args[]) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();

		// There is no diffrence between "get" and "to" - Both launches the URL

		// The only difference is "get" is not overloaded it always takes string

		driver.get("https://www.google.com");

		// "to" is overloaded it takes String and URL

		// "to" internally calls get but in 2nd case URL will be converted to
		// String using String.valueOf() and be passed to "	get"

		//1. 
		driver.navigate().to("https://www.google.com"); // String URL

		//2.
		driver.navigate().to(new URL("https://www.amazon.com")); // URL
		
	
	}

}
