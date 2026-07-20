package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassCRMStream {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/");

//		List<WebElement> headers = driver.findElements(By.cssSelector("section#details h3"));

//		String allHeaders = headers.stream()
//				.map(e -> e.getText())
//				.collect(Collectors.joining("||"));
//
//		System.out.println(allHeaders);

//      headers.stream().forEach(e -> System.out.println(e.getText() + " -- " e.getTagName()));

		By headers = By.cssSelector("section#details h3");

		if (getHeadersList(headers).contains("Forms")) {
			System.out.println("PASS");
		};
	}

	public static void printHeadersList(By locator) {
		driver.findElements(locator).stream().forEach(e -> System.out.println(e.getText()));
	}

	public static List<String> getHeadersList(By locator) {
		return driver.findElements(locator).stream().map(e -> e.getText()).collect(Collectors.toList());
	}

}

//CONS OF STREAMS:
//1.Performance issue
//2.No debug can be done