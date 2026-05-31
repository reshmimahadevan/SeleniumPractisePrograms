package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDown_MultiSelectionCascade_Assignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		By choice = By.id("justAnInputBox1");

		By choiceList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[2]//li//span[@class='comboTreeItemTitle']");

		// tc_1: single selection
		// boolean result = selectChoice(choice, choiceList, "choice 2");
		// System.out.println("Selection successful: " + result);

		// tc_2: multi selection
		// boolean result = selectChoice(choice, choiceList, "choice 1", "choice 2",
		// "choice 6");
		// System.out.println("Selection successful: " + result);

		// tc_3: invalid choice
		// boolean result = selectChoice(choice, choiceList, "choice 99");
		// System.out.println("Selection successful: " + result); // prints false

		//tc_4:All
		boolean result = selectChoice(choice, choiceList, "all");
		System.out.println("Selection successful:" + result);

	}

	public static boolean selectChoice(By choice, By choiceList, String... choiceValue) throws InterruptedException {

		driver.findElement(choice).click();
		Thread.sleep(2000);
		List<WebElement> choices = driver.findElements(choiceList);
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
		if (choiceValue[0].equalsIgnoreCase("All")) {

			for (WebElement e : choices) {
				try {
					List<WebElement> checkBoxList = e
							.findElements(By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]//li//input"));

					for (WebElement cbList : checkBoxList)
						if (!cbList.isSelected()) {
							cbList.click(); // click checkbox directly, not the span
							Thread.sleep(200);
						}
				} catch (Exception ex) {
					System.out.println("Checkbox not found for: " + e.getText());
				}
			}
		}
		return true;
	}
}