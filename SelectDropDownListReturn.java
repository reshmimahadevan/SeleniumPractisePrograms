package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownListReturn {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/r.php?entry_point=login");

		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");

		List<String> actMonthList = getDropDownValueList(month);
		System.out.println(actMonthList);// 12

		List<String> expMonthList = Arrays.asList("Jan", "Feb", "May", "Dec");// 4
		System.out.println(expMonthList);// 4

		if (actMonthList.containsAll(expMonthList)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

	}

	public static List<String> getDropDownValueList(By locator) {

		Select select = new Select(driver.findElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsValList = new ArrayList<String>();// pc=0, []

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text.trim());
		}

		return optionsValList;

	}

}
