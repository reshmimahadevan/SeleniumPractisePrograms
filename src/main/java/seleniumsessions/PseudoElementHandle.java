package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);

		// js.executeScript(script)Object (unlabeled box)
		// js.executeScript(script).toString()String (labeled box)

		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content');";
		String scriptColor = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('color');";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = js.executeScript(script).toString();
		System.out.println(content);
		if (content.contains("*")) {
			System.out.println("this is a mandatory field");
		}

		String color = js.executeScript(scriptColor).toString();
		System.out.println(color);

	}

}
