package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree");

		Thread.sleep(2000);

		By choice = By.id("justAnInputBox");
		By choicesList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']");

		// tc_1: single selection:
		selectChoice(choice, choicesList, "choice 3");

		// tc_2: multi selection:
		// selectChoice(choice, choicesList, "choice 1", "choice 2", "choice 6 2 1",
		// "choice 7", "choice 2 3");

		// tc_3: all selection:
		// selectChoice(choice, choicesList, "all");
	}

	/**
	 * this method is used to select the choices with three different use cases: 1.
	 * single selection : selectChoice(choice, choicesList, "choice 3"); 2. multi
	 * selection : selectChoice(choice, choicesList, "choice 1", "choice 2", "choice
	 * 2 3"); 3. all selection: use "all/All" to select all the choices:
	 * selectChoice(choice, choicesList, "ALL");
	 * 
	 * @param choice
	 * @param choicesList
	 * @param choiceValue
	 * @throws InterruptedException
	 */
	public static void selectChoice(By choice, By choicesList, String... choiceValue) throws InterruptedException {

		driver.findElement(choice).click();
		Thread.sleep(2000);
		List<WebElement> choices = driver.findElements(choicesList);
		System.out.println(choices.size());

		if (choiceValue[0].equalsIgnoreCase("all")) {
			// logic to select all the choices:
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

	}

}
