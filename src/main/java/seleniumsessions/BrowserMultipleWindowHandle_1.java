package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandle_1{

	// abc.com---> 4 tabs==> 5 tabs/windows

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/30-day-free-trial");// parent
		String parentWindowId = driver.getWindowHandle();

		Actions act = new Actions(driver);
		Thread.sleep(4000);
		act.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement fb_ele = driver.findElement(By.xpath("//img[@alt='facebook']"));
		WebElement li_ele = driver.findElement(By.xpath("//img[@alt='linkedin']"));
		WebElement yt_ele = driver.findElement(By.xpath("//img[@alt='youtube']"));

		fb_ele.click();
		li_ele.click();
		yt_ele.click();
		
		//Set and Iterator is Interface

		Set<String> handles = driver.getWindowHandles();

		// set to list: if we want to go to any paticular window as List is ordered
		// List<String> handlesList = new ArrayList<String>(handles);

		Iterator<String> it = handles.iterator();

		
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getTitle());
			Thread.sleep(1500);
			//Set is unordered we don't know where ParentWindowId is present is checking this condition in "if"
			if (!windowId.equals(parentWindowId)) {
				driver.close();
			}
		}

		// driver is lost
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title:" + driver.getTitle());
		
	}

}
