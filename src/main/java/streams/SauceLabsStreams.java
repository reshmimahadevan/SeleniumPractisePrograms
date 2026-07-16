package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> pricesList = driver.findElements(By.cssSelector("div.inventory_item_price"));

		pricesList.stream().forEach(e -> System.out.println(e.getText()));

		// pricesList.stream().forEach(e -> System.out.println(e.getText()));

		// $29.99 --> "29.99" --> 29.99
		
		//By default ascending order will be printed

       //List<Double> sorted_prices = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).sorted()
       //			.collect(Collectors.toList());

	   //System.out.println(sorted_prices);
		
		//Descending order
		
		List<Double> sorted_prices = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		System.out.println(sorted_prices);

	}
}