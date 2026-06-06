package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
//		Action myAction = act
//							.clickAndHold(sourceEle)
//								.moveToElement(targetEle)
//										.release()
//											.build();
//						
//
//      build is not necessary anyways .perform will build and then only perform
//		myAction.perform();

//      OR		

		act.dragAndDrop(sourceEle, targetEle).perform();

	}

}
