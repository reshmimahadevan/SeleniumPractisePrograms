package seleniumsessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		Thread.sleep(5000);

//      multi selection:
//		while (true) {
//			driver.findElement -> if not found on 1st page returns NoSuchElementException
//			driver.findElements -> Returns list -> so even if not found no error only 0 will be returned
//			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
//				System.out.println("country is found");
//				selectMultipleCountry("India");
//			}
//
//			// pagination logic: click next
//			WebElement next = driver.findElement(By.cssSelector("button.next"));
//
//			// Enter any other random names to get this output
//			if (next.getDomAttribute("class").contains("disabled")) {
//				System.out.println("pagination is over...");
//				break;
//			}
//
//		x`	next.click();
//			Thread.sleep(1000);
//		}

//      MultiCountry selection
		List<String> targetCountries = Arrays.asList("India", "United States");
		while (true) {
			for (String country : targetCountries) {
				List<WebElement> rows = driver.findElements(By.xpath("//td[text()='" + country + "']"));
				if (rows.size() > 0) {
					System.out.println(country + " is found");
					selectMultipleCountry(country);
				}
			}

			WebElement next = driver.findElement(By.cssSelector("button.next"));
			if (next.getDomAttribute("class").contains("disabled")) {
				System.out.println("pagination is over...");
				break;
			}
			next.click();
			Thread.sleep(1000);
		}

//      Single Selection:
//		while (true) {
//			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
//				System.out.println("country is found");
//				selectCountry("India");
//				break;
//			} else {
//				// pagination logic:
//				// click on next
//		WebElement next = driver.findElement(By.cssSelector("button.next"));

//        Even after last page if country is not present
//        The word "disabled" is in the class attribute, NOT the button's text	-> so .getDOmAttribute()	
//				if (next.getDomAttribute("class").contains("disabled")) {
//					System.out.println("pagination is over...country is not found...");
//					break;
//				}
//
//				next.click();
//				Thread.sleep(1000);
//			}
//
//		}

	}

	public static void selectMultipleCountry(String countryName) {
		List<WebElement> countryList = driver.findElements(
				By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : countryList) {
			e.click();
		}
	}

	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

}
