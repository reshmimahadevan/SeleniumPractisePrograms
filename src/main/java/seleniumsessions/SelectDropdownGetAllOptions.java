package seleniumsessions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdownGetAllOptions {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/30-day-free-trial");

		//By country = By.id("Form_getForm_Country");(pointed to the <select> container)
		
		//ID locator can only select the `<select>` tag itself — CSS with `option` reaches inside it to each individual choice.
		By country = By.cssSelector("#Form_getForm_Country option");//(points to each individual <option> inside it)

		//System.out.println(selectDropDownValue(country, "India"));

		if (getHeadersList(country).contains("Dublin")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("Cannot find the country");
		}
	}

//	public static boolean selectDropDownValue(By locator, String value) {
//
//		WebElement countryEle = driver.findElement(locator);
//
//		Select select = new Select(countryEle);
//
//		List<WebElement> optionsList = select.getOptions();
//
//		boolean flag = false;
//
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals(value)) {
//				e.click();
//				flag = true;
//				break;
//			}
//		}
//
//		if (flag) {
//			System.out.println(value + " is selected");
//			return true;
//		}
//
//		else {
//			System.out.println(value + " is not selected");
//			return false;
//		}
//	}

	public static void printHeadersList(By locator) {
		driver.findElements(locator).stream().forEach(e -> System.out.println(e.getText()));
	}

	public static List<String> getHeadersList(By locator) {
		return driver.findElements(locator).stream().map(e -> e.getText()).collect(Collectors.toList());

	}
}