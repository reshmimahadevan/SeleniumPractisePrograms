package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaveenFooterLinks {

	public static void main(String[] args) {

          WebDriver driver = new ChromeDriver();
          
          driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
          
          By links = By.xpath("//footer//ul[@class='list-unstyled']//a");
          
          ElementUtils eu = new ElementUtils(driver);
          
          eu.clickElement(links, "Affiliate");

	}

}
