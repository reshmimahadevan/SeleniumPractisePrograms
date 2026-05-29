package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownMiddleValue {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

		By country = By.id("Form_getForm_Country");

		Select select = new Select(driver.findElement(country));

//		int middleIndex = select.getOptions().size()/2;
		
//		select.selectByIndex(middleIndex);

//      size() - No Such Exception so size()-1 should be written	
		
//		select.selectByIndex(select.getOptions().size()-1);

//      233: 0 to 232
		
//		select.getAllSelectedOptions();//list of all pre selected valued
	
//		String defaultValue = select.getFirstSelectedOption().getText();
		
//		System.out.println(defaultValue);

//      select.selectByContainsVisibleText("African");

		List<WebElement> selectedOptiobsList = select.getAllSelectedOptions();
		
		System.out.println(selectedOptiobsList.size());

	}

}