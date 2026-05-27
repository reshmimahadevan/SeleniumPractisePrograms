package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Interview Question:
public class GetTextFeildText {

	static WebDriver driver;

	public static void main(String args[]) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement firstName = driver.findElement(By.id("input-firstname"));

		firstName.sendKeys("Reshmi");

		String fn = firstName.getDomProperty("value");

		System.out.println("User entered FirstName :" + fn);

		WebElement lastName = driver.findElement(By.name("lastname"));

		lastName.sendKeys("Mahadevan");

		String ln = lastName.getDomProperty("value");

		System.out.println("User entered LastName :" + ln);

		WebElement emailId = driver.findElement(By.id("input-email"));

		emailId.sendKeys("pop@selenium.com");

		// Works only in the case if the text is already availble in the DOM .If we have
		// to get the value for what we entered then us use value attribute

		// String text = emailId.getText();

		// System.out.println(text);

		// Interview Question:
		// Why getDomProperty used rather than getDomAttribute -> coz in property only
		// the values will be updated/in attribute value will be null

		String e = emailId.getDomProperty("value");

		System.out.println("User entered EmailId :" + e);

		WebElement phoneNo = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));

		phoneNo.sendKeys("9809890789");

		String pn = phoneNo.getDomProperty("value");

		System.out.println("User entered PhoneNumber :" + pn);

		WebElement password = driver.findElement(By.cssSelector("#input-password"));

		password.sendKeys("Reshmi@123");

		String pass = password.getDomProperty("value");

		System.out.println("User entered Password :" + pass);

		WebElement confirmPassword = driver.findElement(By.cssSelector("#input-confirm"));

		confirmPassword.sendKeys("Reshmi@123");

		String confirmPass = confirmPassword.getDomProperty("value");

		System.out.println("User entered Confirm Password :" + confirmPass);

	}

}
