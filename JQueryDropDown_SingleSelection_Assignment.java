package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDown_SingleSelection_Assignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree");

		Thread.sleep(2000);

		By choice = By.id("justAnotherInputBox");
		By choicesList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[3]//li/span[@class='comboTreeItemTitle']");

		// tc_1: Correct choice
		//boolean result = selectChoice(choice, choicesList, "choice 3");
		//System.out.println("Selection successful: " + result);
		
		// tc_2: Wrong choice
		boolean result = selectChoice(choice, choicesList, "choice 99");
		System.out.println("Selection successful: " + result);

	}

	public static boolean selectChoice(By choice, By choicesList, String choiceValue) {

	    driver.findElement(choice).click();

	    List<WebElement> choices = driver.findElements(choicesList);

	    List<String> availableChoices = new ArrayList<String>();

	    for (WebElement e : choices) {
	        availableChoices.add(e.getText().trim());
	    }

	    
	    if (!availableChoices.contains(choiceValue)) {
	        System.out.println("Invalid choice: " + choiceValue);
	        System.out.println("Available choices: " + availableChoices);
	        return false;
	    }

	    
	    boolean isSelected = false;
	    for (WebElement e : choices) {
	        if (e.getText().trim().equals(choiceValue)) {
	            e.click();
	            isSelected = true;
	            break; // 
	        }
	    }

	    return isSelected;
	}
}