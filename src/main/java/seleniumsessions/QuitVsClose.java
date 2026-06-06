package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver(); // 123

		driver.get("https://www.google.com");

		String title = driver.getTitle(); // 123
		System.out.println(title);

		String url = driver.getCurrentUrl(); // 123
		System.out.println(url);

		// driver.quit(); // 123

		driver.close();

		// After quit/close sid = null

		// Add the below 2 lines to successfully run
		// System.out.println(driver.getTitle());
		// driver = new ChromeDriver(); // 456

		// driver.get("https://www.google.com");

		// org.openqa.selenium.NoSuchSessionException: Session ID is null. Using
		// WebDriver after calling quit()? - QUIT

		// org.openqa.selenium.NoSuchSessionException: invalid session id - CLOSE
		System.out.println(driver.getTitle());
	}

}
