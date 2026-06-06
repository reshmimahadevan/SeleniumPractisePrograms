package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) {

		// 5 navigation methods -> back/forward/to(String)/to(URL)/refresh

		WebDriver driver = new ChromeDriver();

		// new ChromeDriver(); - browser will be launched but this will be eligible for
		// GC as its no reference

		// new ChromeDriver().get("https://www.google.com"); - incase you want to launch
		// the browser but 2 objects will be created and both will be eligible for GC

		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		// Navigate to Amazon.com
		driver.navigate().to("https://www.amazon.com");

		driver.navigate().back();

		System.out.println(driver.getTitle());

		driver.navigate().forward();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(driver.getTitle());

		driver.navigate().back();

		System.out.println(driver.getTitle());

		driver.navigate().refresh();
	}

}
