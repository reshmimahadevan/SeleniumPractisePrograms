package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorsAssignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement email = driver.findElement(By.xpath("//label[text()='E-Mail Address']"));

		driver.findElement(with(By.cssSelector(".form-control")).below(email)).sendKeys("reshmi@gmail.com");

		WebElement password = driver.findElement(By.xpath("//label[text()='Password']"));

		driver.findElement(with(By.cssSelector(".form-control")).below(password)).sendKeys("reshmi");
		
		WebElement passwordFeild = driver.findElement(By.cssSelector("#input-email"));
		
		driver.findElement(with(By.cssSelector(".btn.btn-primary")).below(passwordFeild)).click();
	}

}
