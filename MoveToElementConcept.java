package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


//MoveToElementConcept -> Applicable only for 2 levels(Parent/SubMenu)
public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		//By addOns = By.xpath("//div[text()='Add-ons']");

		//By visaServices = By.xpath("//div[text()='Visa Services']");
		
		By spiceClub = By.xpath("//div[text()='SpiceClub']");
		
		By earnPoints = By.xpath("//div[text()='Earn Points']");

		//handleParentSubMenu(addOns, visaServices);
		
		handleParentSubMenu(spiceClub, earnPoints);

	}

	public static void handleParentSubMenu(By parentMenu, By subMenu) throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(getElement(parentMenu)).build().perform();// moveToElement - Moves the mouse to the middle of the element.

		Thread.sleep(2000);

		getElement(subMenu).click();
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

}
