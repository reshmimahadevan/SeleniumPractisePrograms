package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDown_MultiSelection {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree");

		Thread.sleep(2000);

		By choice = By.id("justAnInputBox");
		By choicesList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']");

		// tc_1: single selection
		// boolean result = selectChoice(choice, choicesList, "choice 3");
		// System.out.println("Selection successful: " + result);

		// tc_2: multi selection
		// boolean result = selectChoice(choice, choicesList, "choice 1", "choice 2",
		// "choice 6 2 1");
		// System.out.println("Selection successful: " + result);

		// tc_3: invalid choice
		// boolean result = selectChoice(choice, choicesList, "choice 99");
		// System.out.println("Selection successful: " + result); // prints false

		// tc_4:All
		boolean result = selectChoice(choice, choicesList, "all");
		System.out.println("Selection successful:" + result);
	}

	/**
	 * this method is used to select the choices with three different use cases:
	 * 1.single selection : selectChoice(choice, choicesList, "choice 3"); 2.
	 * multiselection : selectChoice(choice, choicesList, "choice 1", "choice 2",
	 * "choice 3"); 3. all selection: use "all/All" to select all the
	 * choices:selectChoice(choice, choicesList, "ALL");
	 * 
	 * @param choice
	 * @param choicesList
	 * @param choiceValue
	 * @throws InterruptedException
	 */
	public static boolean selectChoice(By choice, By choicesList, String... choiceValue) throws InterruptedException {

		driver.findElement(choice).click();
		Thread.sleep(2000);
		List<WebElement> choices = driver.findElements(choicesList);
		System.out.println(choices.size());

		// Step 1: Collect all available option texts
		List<String> availableChoices = new ArrayList<String>();
		for (WebElement e : choices) {
			String text = e.getText();
			availableChoices.add(text.trim());
		}

		// Step 2: Validate passed choices (skip validation if "all")
		if (!choiceValue[0].equalsIgnoreCase("all")) {
			for (String value : choiceValue) {
				if (!availableChoices.contains(value)) {
					System.out.println("Invalid choice passed: " + value);
					System.out.println("Available choices are: " + availableChoices);
					return false;
				}
			}
		}

		// Step 3: Perform selection
		if (choiceValue[0].equalsIgnoreCase("all")) {
			for (WebElement e : choices) {
				e.click();
			}
		} else {
			for (WebElement e : choices) {
				String text = e.getText();
				System.out.println(text);

				for (String value : choiceValue) {
					if (text.trim().equals(value)) {
						e.click();
						break;
					}
				}
			}
		}

		return true;
	}

}
