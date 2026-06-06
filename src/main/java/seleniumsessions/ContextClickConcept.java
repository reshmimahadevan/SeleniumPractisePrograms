package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//ContextClick -> Right Click

public class ContextClickConcept {

	public static void main(String[] args) {

		// perform() ==> Build.perform

		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act = new Actions(driver);

		act.contextClick(rightClickEle).perform();// right click on the element

		driver.findElement(By.xpath("//span[text()='Copy']")).click();

//			List<WebElement> optionsList = 
//						driver.findElements(By.cssSelector("ul.context-menu-list > li.context-menu-icon > span"));
//			
//			System.out.println(optionsList.size());

//			for(WebElement e : optionsList) {
//				String text = e.getText();
//				System.out.println(text);
//					if(text.equals("Copy")) {
//						e.click();
//						break;
//					}
//			}

	}

}
