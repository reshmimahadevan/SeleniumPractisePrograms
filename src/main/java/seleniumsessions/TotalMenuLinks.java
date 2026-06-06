package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalMenuLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		String title = driver.getTitle();

		System.out.println("Page title : " + title);

		// List<WebElement> menuLinksList =
		// driver.findElements(By.className("list-group-item"));

		// for (WebElement e : menuLinksList) {
		// String text = e.getText();
		// System.out.println(text);
		// if (text.equals("Forgotten Password")) {
		// e.click();
		// break;
		// }
		// }

		By menuList = By.className("list-group-item");
		if (getElementsCount(menuList) == 13) {
			System.out.println("Menu Link Count is correct -- PASS");
		} else {
			System.out.println("Menu Link Count is not correct -- FAIL");
		}

		List<String> actualList = getElementTextList(menuList);
		if (actualList.contains("My Account")) {
			System.out.println("PASS");
		}
		if (actualList.contains("Reward Points")) {
			System.out.println("PASS");
		}
	}

	public static List<String> getElementTextList(By locator) {

		List<WebElement> elements = getElements(locator);

		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : elements) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public static int getElementsCount(By locator) {

		int size = getElements(locator).size();
		System.out.println("Element count :" + size);
		return size;
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}
}
