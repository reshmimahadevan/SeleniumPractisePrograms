package seleniumsessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownListReturnAssignment {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();

		driver.get("https://orangehrm.com/30-day-free-trial");

		By country = By.id("Form_getForm_Country");

		ElementUtils eu = new ElementUtils(driver);

		List<String> expCountryOptions = Arrays.asList("Albania", "Andorra", "Belgium", "Greece", "India");

		System.out.println(eu.getDropDownValueList(country, expCountryOptions));

	}

}
