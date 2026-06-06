package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Attribute based Locators
		// 1.ID : unique attribute but if its duplicate no problem as well
		driver.findElement(By.id("input-firstname")).sendKeys("Reshmi");
		
		// 2.Name : can be duplicate
		driver.findElement(By.name("lastname")).sendKeys("Mahadevan");
		
		// 3.Class : can be duplicate for most of the times/All the classes are seperated by space/Class defines the CSS(look and feel of the page)
		// So the 1st element found with the  mentioned class name will be entered with the email 
		// In this page in search the email will be entered insted of email (1 of 7)
		// So this the least preferrable
		// Inspect -> Ctrl F -> .classname and see how many elements with same classnames present
		
		// driver.findElement(By.className("form-control")).sendKeys("reshmi@gmail.com");
		
		driver.findElement(By.id("input-email")).sendKeys("reshmi@gmail.com");
		
		// Here classname is unique (1 of 1)
		// driver.findElement(By.className("img-responsive")).click();
		
		// 4.xpath : Not an Atrribute/Address of the element in the DOM
		// Dynamic Elements Handling
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("9867574736");
		
		// 5.css : Not an Atrribute 
		// Dynamic Elements Handling
		driver.findElement(By.cssSelector("#input-password")).sendKeys("re@123");
		
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("re@123");
		
		// 6.Link Text : Only for Links
		// htmltag : <a>
		driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.linkText("Forgotten Password")).click();
		
		
		// 7.Partial Link Text : Only for Links
		// If Link text is very long
		// driver.findElement(By.partialLinkText("Forgotten")).click();
		
		
		// 8.Tag Name
		By tagName = By.tagName("h2");
		ElementUtils eu = new ElementUtils(driver);
		String header = eu.getText(tagName);
		System.out.println(header);
		if(header.equals("New Customer"))
		{
			System.out.println("Test is PASS");
		}
		else
		{
			System.out.println("Test is FAIL");
		}
		
	}

}
