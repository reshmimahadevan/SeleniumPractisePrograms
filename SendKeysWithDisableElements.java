package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithDisableElements {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
	driver = new ChromeDriver();
	
	driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
	
	//org.openqa.selenium.ElementNotInteractableException: element not interactable as element is disabled
	
	//driver.findElement(By.id("pass")).sendKeys("Re@123");
	
	//When you simply click on disabled element then nothinh happens
	
	driver.findElement(By.id("pass")).click();
	
	

	}

}
