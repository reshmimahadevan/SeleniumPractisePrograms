package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClassConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=34_51");

		// 1.Invalid - org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
		// Multiples classes can't be written as such
		// driver.findElement(By.className("col-sm-3 hidden-xs")).click();

		//2.Valid
		//driver.findElement(By.cssSelector("aside.col-sm-3.hidden-xs")).click();
		
		//3.Valid
		//driver.findElement(By.xpath("//aside[@class = 'col-sm-3 hidden-xs']")).click();
		
		//4.Valid
		//driver.findElement(By.className("col-sm-3")).click();
		
		//5.Invalid -org.openqa.selenium.InvalidSelectorException
		driver.findElement(By.xpath("///[@@id,'reshmi']")).click();
	}

}
