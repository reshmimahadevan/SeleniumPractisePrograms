package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTestClass {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test
	public void titleTest() {

		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	@Test
	public void searchExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void isHelpExistTest() {
		boolean flag = driver.findElement(By.linkText("Help")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
