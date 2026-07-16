package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		Thread.sleep(2000);

		driver.findElement(By.id("datepicker")).click();

		futureDate("February 2028", "29");

//		driver.findElement(By.linkText("25")).click();

	}

	/**
	 *
	 * @param expMonthYear
	 * @param day
	 */
	public static void futureDate(String expMonthYear, String day) {

		// expMonthYear looks like "October 2027" -> split into month = "October", year= "2027"
		String[] parts = expMonthYear.split(" ");
		String expMonth = parts[0];
		int expYear = Integer.parseInt(parts[1]);
		int dayNum = Integer.parseInt(day); // Integer.parseInt -> since day is given in the form of string

		if (!isValidDay(expMonth, expYear, dayNum)) {
			System.out.println(
					"wrong day is passed for " + expMonth + " " + expYear + ", please pass a valid day for that month");
			return;
		}

		String actMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(actMonthYear);

		while (!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on next icon:
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();// Pick all the dates until
																								// the futre date
																								// mentioned
			System.out.println(actMonthYear);

		}

		driver.findElement(By.linkText(day)).click();

	}

	/**
	 * Checks whether "day" is a real day number for the given month/year, e.g.
	 * rejects April 31, rejects Feb 30, allows Feb 29 only in leap years.
	 */
	public static boolean isValidDay(String month, int year, int day) {

		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// Jan=index0, Feb=index1, Mar=index2 ... Dec=index11

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int monthIndex = -1;
		for (int i = 0; i < months.length; i++) {
			if (months[i].equalsIgnoreCase(month)) {
				monthIndex = i;
				break;
			}
		}

		if (monthIndex == -1) {
			System.out.println("unrecognized month name: " + month);
			return false;
		}

		int maxDay = daysInMonth[monthIndex];

		// handle leap year for February (monthIndex 1 = February)
		if (monthIndex == 1 && isLeapYear(year)) {
			maxDay = 29;
		}

		return day >= 1 && day <= maxDay;
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0;
	}

}