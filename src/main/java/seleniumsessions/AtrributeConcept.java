package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AtrributeConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		// WebElement firstName = driver.findElement(By.id("input-firstname"));

		// getAttribute is depricated in latest selenium version
		
		// String placeholderVal = firstName.getAttribute("placeholder");
		
		// System.out.println(placeholderVal);
		
        // String placeholderVal = firstName.getDomAttribute("placeholder");
		
        // System.out.println(placeholderVal);
		
		// String height = firstName.getDomProperty("tagName");
		
		// System.out.println(height);
		
		// String isDisabled = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).getDomProperty("disabled");
		
		// System.out.println(isDisabled);
		
        String defaultValue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).getDomProperty("defaultValue");
		
		System.out.println(defaultValue);
		
		ElementUtils eu = new ElementUtils(driver);
		
		By continueBtn =  By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		
		String isDisabled = eu.getElementDomAttributePropertyValue(continueBtn,"disabled");
		
		System.out.println(isDisabled);
		
		By firstName = By.id("input-firstname");
		
		String value = eu.getElementDomAttributeValue(firstName, "placeholder");
		
		System.out.println(value);
		
		
    
		
		
	}

}
