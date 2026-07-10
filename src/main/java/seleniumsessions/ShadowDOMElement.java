package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		Thread.sleep(3000);

		//shadowRoot ->open only we can automate not close
		
		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement pizza = (WebElement) js.executeScript(script);// js.executescript returns html element ---> webelement to sendKeys

		pizza.sendKeys("veg pizza");

		// driver.findElement(By.id("pizza")).sendKeys("veg pizza"); doesn't work

	}

}
