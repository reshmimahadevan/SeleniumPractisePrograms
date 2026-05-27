package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		
		Thread.sleep(1000);
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		System.out.println("Total Images :" +imagesList.size());
		
		//WebScraping
		
		for(WebElement e : imagesList)
		{
			String altVal = e.getDomAttribute("alt");
			String srcVal = e.getDomAttribute("src");
			
			System.out.println(altVal + " " + srcVal);
		}


	}

}
