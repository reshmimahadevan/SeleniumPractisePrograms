package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		By searchName = By.name("q");

		doSendKeys(searchName, "Selenium Automation");

		Thread.sleep(5000);

		By xpath = By.xpath("//div[@class='wM6W7d']/span");

		search(xpath, "10 years experience");

	}

	public static void search(By locator, String value) throws InterruptedException {

		clickElement(locator, value);
	}

	public static void doSendKeys(By locator, CharSequence... value) {

		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void clickElement(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println("Total No of Elements : " + eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			// Using contains instead of equals because what if any text later is appended
			// with anything in future
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

}
