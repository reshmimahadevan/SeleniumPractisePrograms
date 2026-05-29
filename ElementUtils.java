package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	private void nullCheck(CharSequence... value) {
		if (value == null) {
			throw new RuntimeException("*****VALUE CANNOT BE NULL*****");
		}
	}

	// public void doSendKeys(By locator, String value) {
	// nullCheck(value);
	// getElement(locator).sendKeys(value);
	// }

	// Send Keys is CharacterSequence "Array" -> ... -> sending multiple values so
	// what if user sends
	// StringBuilder/Buffer/String as value so overloaded the above method
	// Refer SendKeysConcept

	public void doSendKeys(By locator, CharSequence... value) {

		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
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

	// *****Find Elements*****//
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

	public boolean getDropDownValueList(By locator,List<String> expOptionsList) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsValList = new ArrayList<String>();// pc=0, []

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValList.add(text.trim());
		}

		if(optionsValList.containsAll(expOptionsList))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

}
