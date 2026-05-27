package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	// Find all the Links and Print The Text of Each Link
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		Thread.sleep(1000);

		By links = By.tagName("a");

		ElementUtils eu = new ElementUtils(driver);

		// Describe the LinkCount here
		if (eu.getElementsCount(links) > 300) {
			System.out.println("Proper Links are present -- PASS");
		}

		List<String> linksTextList = eu.getElementTextList(links);

		// Validation
		// So contains("Hello, sign in") is checking if the List contains an element
		// that
		// is exactly equal to "Hello, sign in" — but no element matches exactly because
		// the full text is "Hello, sign in\nAccount & Lists".
		// Going for Substring Text
		boolean found = false;
		for (String text : linksTextList) {
			if (text.contains("Hello, sign in")) { // substring check
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Pass");
		}

//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//
//		System.out.println("Total Links :" + linksList.size());
//
//		// Index Loop
//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (text.length() != 0) {
//				System.out.println(i + " " + text);
//			}
//		}
//
//		System.out.println("=============================");
//		
//		for (WebElement list : linksList) {
//			String text = list.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}
	}

}
