package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//      *[local-name()='svg' and @fill='none'] --flipkart search icon

		driver = new ChromeDriver();
//		driver.get("https://www.flipkart.com/");
//		Thread.sleep(3000);
//		
//		driver.findElement(By.name("q")).sendKeys("macbook");
//		driver.findElement(By.xpath("//*[local-name()='svg' and @fill='none']")).click();

		driver.get("https://petdiseasealerts.org/forecast-map");
		Thread.sleep(3000);

		String xpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class='region']";

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		Thread.sleep(3000);

		List<WebElement> regionsList = driver.findElements(By.xpath(xpath));

		System.out.println(regionsList.size());

			Actions act = new Actions(driver);
		    for (WebElement e : regionsList) {
			String regionName = e.getDomAttribute("id");
			System.out.println(regionName);
			act.moveToElement(e).perform();
			Thread.sleep(500);
		}

	}
}