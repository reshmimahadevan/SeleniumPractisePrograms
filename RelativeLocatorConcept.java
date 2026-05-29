package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		// selenium 4.x: RelativeLocator : with

//						  above
//							|	
//				left <---   ele  ---> right
//							|
//						  below
		// near ele

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(8000);

		WebElement ele = driver
				.findElement(By.xpath("//section[contains(@class,'polluted-cities-list')]//p[text()='Saint John']"));

		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);

		String rightAQIStatus = driver.findElement(with(By.cssSelector("p.status")).toRightOf(ele)).getText();
		System.out.println(rightAQIStatus);

		String rightAQILevel = driver.findElement(with(By.cssSelector("div.aqi")).toRightOf(ele)).getText();
		System.out.println(rightAQILevel);

		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);

		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);

		//near uses CLOSE_IN_PIXELS - see its declaration
		String nearEleText = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearEleText);

	}

}
