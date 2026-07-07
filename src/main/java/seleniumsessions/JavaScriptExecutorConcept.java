package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		// sel+java --> JavaScriptExecutor -- inject JS code into the browser

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//      driver.get("https://classic.crmpro.com");

//		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//      To get Page title	
//      .toString() -> to get the equivalent java value
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);

//		To get page URL
//		String url = js.executeScript("return document.URL;").toString();
//		System.out.println(url);

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		String title = jsUtil.getTitleByJS();
//		System.out.println(title);
//		
//		jsUtil.generateJSAlert("user is on login page");

//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
		
//		CRM website
//		if(pageText.contains("Companies & Contacts")) {
//			System.out.println("PASS");
//		}

//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		

//      Amazon website
//		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Trending products from Emerging Businesses')]"));
//		jsUtil.scrollIntoView(element);

//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//
//		WebElement loginForm = driver.findElement(By.cssSelector("div.well form"));
//		WebElement footer = driver.findElement(By.xpath("//footer"));

//		jsUtil.drawBorder(emailId);
//		jsUtil.drawBorder(loginForm);
//		jsUtil.drawBorder(footer);

//		jsUtil.flash(emailId);
//		emailId.sendKeys("test@gmail.com");
//		
//		jsUtil.flash(password);
//		password.sendKeys("test@123");

		// webClick --> ActionsClick --> JsClick
		WebElement agree = driver.findElement(By.name("agree"));
		jsUtil.clickElementByJS(agree);

	}

}
