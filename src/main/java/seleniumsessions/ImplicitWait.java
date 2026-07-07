package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//sel 3.x  //deprecated

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));// sel 4.x

		driver.get("");
		// global wait: it will be applied for all the webelements
		// login page: 10 secs
		// e1 : 10 --> 2 : 2 --> 8 secs will be cancelled/ignored
		// e2 : 10 --> 5 : 5
		// e3 : 10 --> 4 : 4

		// product page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// sel 4.x
		// e4
		// e5
		// e6

		// login page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// sel 4.x
		// e1 e2 e3: 10 secs

		// e1: 10 secs: 4 secs:
		// nullify of Implicit wait
		//the latest wait will be overloaded if many implicit waits are present
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// sel 4.x
		// e2: imp wait: 0
		// e3: imp wait :0

		// it wont work for non web elements: title, url, alert, windows

	}

}
