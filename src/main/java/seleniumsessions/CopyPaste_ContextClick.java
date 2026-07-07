package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyPaste_ContextClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			// Step 2: Open the practice website
			driver.get("https://demoqa.com/text-box");
			driver.manage().window().maximize();

			// Step 3: Wait for page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Step 4: Find the "Full Name" input field
			WebElement sourceField = wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));

			// Step 5: Type some text into the source field
			sourceField.click();
			sourceField.sendKeys("Hello Reshmi!");

			// Step 6: Select all text in source field (Ctrl+A)
			// keysdown -> pressing ctrl+a
			// keysup -> releasing
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

			// Step 7: Copy the selected text (Ctrl+C)
			actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

			// Step 8: Click on the "Email" field (target field)
			WebElement targetField = driver.findElement(By.id("userEmail"));
			targetField.click();

			// Step 9: Paste the copied text (Ctrl+V)
			actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

			// Step 10: Verify the paste worked
			String pastedText = targetField.getAttribute("value");
			System.out.println("Pasted text: " + pastedText);

			if (pastedText.equals("Hello Reshmi!")) {
				System.out.println("PASS: Copy-paste worked correctly!");
			} else {
				System.out.println("FAIL: Text did not paste correctly.");
			}

			// Wait 2 seconds so you can see the result
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 11: Always close the browser
			driver.quit();
		}
	}
}
