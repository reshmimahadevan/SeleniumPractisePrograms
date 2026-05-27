package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);

		// Parent to Child :

		// parentTag[@attr='value']/childTag[@attr='value']
		// parentTag[@attr='value']//childTag[@attr='value']

		// parentTag[@attr='value']/child::childTag[@attr='value']

		// (div[@class='form-group'])[1]/child::input[@id='input-email']
		// (div[@class='form-group'])[1]//child::input[@id='input-email']

		// div[@class='form-group']/child::input[@id='input-email']
		// div[@class='form-group']/input[@id='input-email']

		// select[@id='Form_getForm_Country']/child::option[contains(text(),'Armenia')]
		// -> Orangehrm

		// Child to Parent : Backward Traversing

		// input[@id='input-email']/../../../../../../.. -> To parent html

		// option[contains(text(),'Armenia')]/..
		// input[@id='input-email']/parent::div/parent::form

		// Child to GrandParent :

		// input[@id='input-email']/ancestor::form
		// input[@id='input-email']/ancestor::form//ancestor::div[@id='content']

		// Sibling :
		// input[@id='input-email']/preceding-sibling::label
		// label[@for='input-email']/following-sibling::input

		// option[contains(text(),'Armenia')]//preceding-sibling::option -> 10 siblings
		// option[contains(text(),'Armenia')]//following-sibling::option -> 222 siblings
		// (//option[contains(text(),'Armenia')]//following-sibling::option)[1] -> Aruba
		// (//option[contains(text(),'Armenia')]//following-sibling::option)[last()] ->
		// Zaire

		// a[contains(text(),'Joe.Root')]/parent::td/preceding-sibling::td/input[@type='checkbox']
		// -> Selectors Hub -> https://selectorshub.com/xpath-practice-page/
		// a[contains(text(),'Joe.Root')]/ancestor::tr//input[@type='checkbox']

		// driver.findElement(By.xpath("//a[contains(text(),'Joe.Root')]/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'John.Smith')]/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

		selectUser("Joe.Root");
		selectUser("John.Smith");

		if (getUser("Joe.Root").contains("Enabled")) {
			System.out.println("The test is passed");
		}

	}

	public static void selectUser(String userName) {
		driver.findElement(By.xpath(
				"//a[contains(text(),'" + userName + "')]/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static List<String> getUser(String userName) {
		List<WebElement> elements = driver
				.findElements(By.xpath("//a[contains(text(),'Joe.Root')]/parent::td/following-sibling::td"));

		// List<String> is only needed if you want to return and reuse the data
		// elsewhere.

		List<String> colList = new ArrayList<String>();

		System.out.println(colList.size());

		for (WebElement e : elements) {
			String text = e.getText();
			System.out.println(text);
			colList.add(text);
		}

		return colList;

	}

}
