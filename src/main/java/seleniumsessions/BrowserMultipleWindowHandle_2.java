package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandle_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/30-day-free-trial"); // parent

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

        Thread.sleep(2000); // wait for all child windows to open

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()) {
            String windowId = it.next();

            if (!windowId.equals(parentWindowId)) {

                // Step 1: Go to child
                driver.switchTo().window(windowId);
                System.out.println("Child window title: " + driver.getTitle());
                Thread.sleep(1500);

                // Step 2: Close child
                driver.close();

                // Step 3: Go back to parent
                driver.switchTo().window(parentWindowId);
                System.out.println("Parent window title: " + driver.getTitle());
                Thread.sleep(1500);
            }
        }

        System.out.println("All child windows closed. Parent still open: " + driver.getTitle());
    }
}
