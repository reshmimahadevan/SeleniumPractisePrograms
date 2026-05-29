package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableWithRelativeLocators {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");

		Thread.sleep(4000);

		WebElement userName = driver.findElement(By.linkText("Joe.Root"));

		driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(userName)).click();
		
		//Gives all the td elements right of the Joe.Root -> This is the Limitation

		List<WebElement> eleList = driver.findElements(with(By.tagName("td")).toRightOf(userName));

		for (WebElement e : eleList) {
			System.out.println(e.getText());
		}

	}

}
