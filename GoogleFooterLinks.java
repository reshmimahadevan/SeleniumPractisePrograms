package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFooterLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		By links = By.xpath("//div[@class='KxwPGc SSwjIe']/div/a");

		ElementUtils eu = new ElementUtils(driver);

		eu.clickElement(links, "Privacy");

	}

}
