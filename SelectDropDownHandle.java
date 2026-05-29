package seleniumsessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// dropdown:
		// htmltag: <select> ---> Select class -- default class in Selenium
		// select -- option
		// option: value = , text =

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/30-day-free-trial");

		Thread.sleep(5000);

		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");

//		WebElement dayEle = driver.findElement(day);
//		WebElement monthEle = driver.findElement(month);
//		WebElement yearEle = driver.findElement(year);
//
//		Select select1 = new Select(dayEle);
//		select1.selectByIndex(20);
//
//		Select select2 = new Select(monthEle);
//		select2.selectByVisibleText("Aug");
//		select2.selectByValue("10");

//		Select select3 = new Select(yearEle);
//		select3.selectByValue("2015");

//		doSelectDropDownByIndex(day, 10);
//		doSelectDropDownByIndex(month, 5);
//		doSelectDropDownByIndex(year, 9);

//		doSelectDropDownByVisibleText(day, "15");
//		doSelectDropDownByVisibleText(month, "Aug");
//		doSelectDropDownByVisibleText(year, "2016");

//		doSelectDropDownByVisibleText(day, "15");
//		doSelectDropDownByValue(month, "5");
//		doSelectDropDownByVisibleText(year, "2020");

		By country = By.id("Form_getForm_Country");
		boolean flag = doSelectDropDownByVisibleText(country, "India");
		System.out.println(flag);

		doSelectDropDownByIndex(country, 400);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static boolean doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(index + " is not present in the dropdown");
			return false;
		}
	}

	public static boolean doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(visibleText + " is not present in the dropdown");
			return false;
		}
	}

	public static boolean doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(value + " is not present in the dropdown");
			return false;
		}
	}

}
