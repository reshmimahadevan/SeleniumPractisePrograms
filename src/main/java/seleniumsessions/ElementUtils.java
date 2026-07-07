package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;
	private Actions act;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	private void nullCheck(CharSequence... value) {
		if (value == null) {
			throw new RuntimeException("*****VALUE CANNOT BE NULL*****");
		}
	}

	public void doSendKeys(By locator, String value) {
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	// Send Keys is CharacterSequence "Array" -> ... -> sending multiple values so
	// what if user sends StringBuilder/Buffer/String as value so overloaded the
	// above method
	// Refer SendKeysConcept

	public void doSendKeys(String locatorType, String locatorValue, String value) {

		nullCheck(value);
		getElement(locatorType, locatorValue).sendKeys(value);
	}

	public void doSendKeys(By locator, CharSequence... value) {

		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}

	public String getText(By locator) {
		String eleText = getElement(locator).getText();
		System.out.println("Element Text : " + eleText);
		return eleText;
	}

	public String getElementDomAttributeValue(By locator, String attrName) {
		nullCheck(attrName);
		return getElement(locator).getDomAttribute(attrName);
	}

	public String getElementDomAttributePropertyValue(By locator, String propName) {
		nullCheck(propName);
		return getElement(locator).getDomProperty(propName);
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();

		} catch (NoSuchElementException e) {
			// e.printStackTrace();
			System.out.println("Element is not Present on the Page");
			return false;
		}

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement getElementWithWait(By locator, int timeOut) {
		return waitForElementVisible(locator, timeOut);
	}

	// If Locators ar enot in By but in String
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public By getBy(String locatorType, String locatorValue) {

		By locator = null;

		switch (locatorType.toUpperCase()) {
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "CLASS":
			locator = By.className(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;
		case "CSS":
			locator = By.cssSelector(locatorValue);
			break;
		case "LINKTEXT":
			locator = By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("plz pass the right locator type: " + locatorType);
			break;
		}

		return locator;

	}

	// *****Find Elements *****//
	public List<String> getElementTextList(By locator) {

		List<WebElement> elements = getElements(locator);

		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : elements) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public void clickElement(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println("Total No of Elements : " + eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			// Using contains instead of equals because what if any text later is appended
			// with anything in future
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
	}

	public int getElementsCount(By locator) {

		int size = getElements(locator).size();
		System.out.println("Element count :" + size);
		return size;
	}

	public boolean checkSingleElementDisplayed(By locator) {
		if (getElements(locator).size() == 1) {
			System.out.println("Element : " + locator + " is displayed on the page one time");
			return true;
		}
		return false;
	}

	public boolean checkElementDisplayed(By locator, int expElementCount) {
		if (getElements(locator).size() == expElementCount) {
			System.out.println("Element : " + locator + " is displayed on the page " + expElementCount + " times");
			return true;
		}
		return false;
	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	// ***** Drop Down Utils - Select Based Dropdowns ***** //
	public boolean doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(index + " is not present in the dropdown");
			return false;
		}
	}

	public boolean doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(visibleText + " is not present in the dropdown");
			return false;
		}
	}

	public boolean doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(value + " is not present in the dropdown");
			return false;
		}
	}

	public boolean selectDropDownValue(By locator, String value) {

		WebElement countryEle = getElement(locator);

		Select select = new Select(countryEle);

		List<WebElement> optionsList = select.getOptions();

		boolean flag = false;

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(value + " is selected");
			return true;
		}

		else {
			System.out.println(value + " is not selected");
			return false;
		}
	}

	public boolean getDropDownValueList(By locator, List<String> expOptionsList) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsValList = new ArrayList<String>();// pc=0, []

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValList.add(text.trim());
		}

		if (optionsValList.containsAll(expOptionsList)) {
			return true;
		}

		else {
			return false;
		}
	}

	// ***** Dropdown Utils - Non Select Based *****//
	public void selectChoice(By choice, By choicesList, String... choiceValue) throws InterruptedException {

		doClick(choice);
		Thread.sleep(2000);
		List<WebElement> choices = getElements(choicesList);
		System.out.println(choices.size());

		if (choiceValue[0].equalsIgnoreCase("all")) {
			// logic to select all the choices:
			for (WebElement e : choices) {
				e.click();
			}
		} else {

			for (WebElement e : choices) {
				String text = e.getText();
				System.out.println(text);

				for (String value : choiceValue) {
					if (text.trim().equals(value)) {
						e.click();
						break;
					}
				}

			}
		}
	}

	// ***** Action Utils ***** //
	public void doMoveToElement(By locator) throws InterruptedException {
		Actions actions = new Actions(driver);

		actions.moveToElement(getElement(locator)).build().perform();

		Thread.sleep(2000);
	}

	public void handleParentSubMenu(By parentMenu, By subMenu) throws InterruptedException {

		doMoveToElement(parentMenu);

		doClick(subMenu);

	}

	public void handle4LevelMenuHandle(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {

		doClick(level1Menu);
		Thread.sleep(2000);
		doMoveToElement(level2Menu);
		Thread.sleep(2000);
		doMoveToElement(level3Menu);
		Thread.sleep(2000);
		doClick(level4Menu);
	}

	// For doSendKeysWithPause()/doActionsSendKeys()/doActionsClick()
	// -> Actions action = new Actions(driver)-> Created in Constructor above

	public void doSendKeysWithPause(By locator, String value, long pauseTime) {

		char val[] = value.toCharArray();
		for (char ch : val) {// n->"n"
			act.sendKeys(getElement(locator), String.valueOf(ch)).pause(pauseTime).perform();
		}
	}

	public void doActionsSendKeys(By locator, String value) {
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		act.click(getElement(locator)).perform();
	}

	/***** Wait Utils *****/

	/**
	 * An exception for checking that an element is present in the DOM of the
	 * page.This does not mean that element is visible
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickWithWait(By locator, int timeOut) {
		waitForElementVisible(locator, timeOut).click();
	}

	public void sendKeysWithWait(By locator, int timeOut, CharSequence... value) {
		waitForElementVisible(locator, timeOut).sendKeys(value);

	}

}
