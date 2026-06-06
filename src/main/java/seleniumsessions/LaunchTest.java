package seleniumsessions;
	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTest {

	public static void main(String[] args) {

		// Before Selenium 4.6 version
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\reshm\\OneDrive\\Desktop\\Job\\Learnings\\NaveenCourse\\Selenium\\MyDrivers\\chromedriver-win64\\chromedriver.exe");

		// After Selenium 4.6 version
		// 3 chrome browsers will be opened
		WebDriver driver = new ChromeDriver(); // 123 - Seesion ID
		driver = new ChromeDriver();// 345
		driver = new ChromeDriver();// 567
		// In 3rd browser only the url will be entered
		driver.get("https://www.google.com"); // 567
		// In 3rd browser only the quit happens
		driver.quit(); // 567
		driver.quit(); // Exception will not be thrown / sid = null

		// WebDriver driver = new FirefoxDrive();

		// WebDriver driver = new EdgeDriver();

	}

}
