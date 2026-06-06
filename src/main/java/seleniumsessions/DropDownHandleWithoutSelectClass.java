package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

		// no select class:

		List<WebElement> optionsList = driver.findElements(By.cssSelector("select#Form_getForm_Country > option"));

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Turkey")) {
				e.click();
				break;
			}
		}

	}

}
