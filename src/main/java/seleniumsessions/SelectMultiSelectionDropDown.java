package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultiSelectionDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		
		Select select = new Select(dropDownEle);
		
		//isMultiple() -> to check for MultipleSelection
		System.out.println(select.isMultiple());
		
		List<WebElement> selectedOptionsList = select.getAllSelectedOptions();
		System.out.println(selectedOptionsList.size()); //0
		
		if(select.isMultiple())
		{
			System.out.println("Multiple selection is possible");
			
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Greater flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Lesser flamingo");
			
			selectedOptionsList = select.getAllSelectedOptions();
			System.out.println(selectedOptionsList.size()); //4
			
		}
		
		//Applicable only for Multi Selection
		//select.deselectByVisibleText("Greater flamingo");
		//select.deselectAll();

	}

}
