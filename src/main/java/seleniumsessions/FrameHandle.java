package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// browser

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");// page
		Thread.sleep(2000);

		// total number of frames:
		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println(frameCount);

		// switch driver to frame;
		// Index :
		// driver.switchTo().frame(2);
		// Name/ID :
		// driver.switchTo().frame("main");
		// WebElement :
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));

		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
	}

}
