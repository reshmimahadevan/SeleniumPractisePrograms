package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//https://claude.ai/chat/e45ea5a0-0bf0-4302-9b34-869d9b1b1bd8 - Check this

public class CricInfoTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		Thread.sleep(5000);

		driver.get(
				"https://www.espncricinfo.com/series/ipl-2026-1510719/sunrisers-hyderabad-vs-royal-challengers-bengaluru-67th-match-1529310/full-scorecard");

//		getWcktTakerName("Venkatesh Iyer");
//
//		System.out.println(getPlayerScoreCard("Venkatesh Iyer"));
//
//		getWcktTakerName("Nitish Kumar Reddy");
//
//		System.out.println(getPlayerScoreCard("Nitish Kumar Reddy"));

		System.out.println(getBattingScoreCard("Venkatesh Iyer"));

		System.out.println(getBowlingScoreCard("Nitish Kumar Reddy"));

		System.out.println(getBattingScoreCard("Nitish Kumar Reddy"));

		System.out.println(getBattingPlayers());

		System.out.println(getBowlingPlayers());

	}

//	public static void getWcktTakerName(String name) {
//		System.out.println(driver
//				.findElement(By.xpath("//span[text()='" + name + "']/ancestor::td/following-sibling::td")).getText());
//	}
//
//	public static List<String> getPlayerScoreCard(String name) {
//		List<WebElement> elements = driver.findElements(By.xpath(
//				"//span[text()='" + name + "']/ancestor::td/following-sibling::td[contains(@class,'ds-text-center')]"));
//
//		List<String> playerDetails = new ArrayList<String>();
//
//		for (WebElement e : elements) {
//			String text = e.getText();
//			System.out.println(text);
//			playerDetails.add(text);
//		}
//
//		return playerDetails;
//	}

	public static List<String> getBattingScoreCard(String name) {
		// ancestor::table scoped to the Batting table only
		List<WebElement> elements = driver
				.findElements(By.xpath("//th[normalize-space(text())='Batting']/ancestor::table" + "//span[text()='"
						+ name + "']" + "/ancestor::td/following-sibling::td[contains(@class,'ds-text-center')]"));

		List<String> playerDetails = new ArrayList<>();
		for (WebElement e : elements) {
			playerDetails.add(e.getText());
		}
		return playerDetails;
	}

	public static List<String> getBowlingScoreCard(String name) {
		// ancestor::table scoped to the Bowling table only
		List<WebElement> elements = driver
				.findElements(By.xpath("//th[normalize-space(text())='Bowling']/ancestor::table" + "//span[text()='"
						+ name + "']" + "/ancestor::td/following-sibling::td[contains(@class,'ds-text-center')]"));

		List<String> playerDetails = new ArrayList<>();
		for (WebElement e : elements) {
			playerDetails.add(e.getText());
		}
		return playerDetails;
	}

	public static List<String> getBattingPlayers() {
		List<WebElement> elements = driver
				.findElements(By.xpath("//th[normalize-space(text())='Batting']/ancestor::table//tbody"
						+ "/tr[not(contains(@class,'ds-hidden'))]/td[1]" + "//a//span[not(*)]"));

		List<String> playerNames = new ArrayList<>();
		for (WebElement e : elements) {
			String text = e.getText();
			if (!text.isEmpty()) {
				playerNames.add(text);
			}
		}
		return playerNames;
	}

	public static List<String> getBowlingPlayers() {
		List<WebElement> elements = driver
				.findElements(By.xpath("//th[normalize-space(text())='Bowling']/ancestor::table//tbody"
						+ "/tr[not(contains(@class,'ds-hidden'))]/td[1]" + "//a//span[not(*)]"));

		List<String> playerNames = new ArrayList<>();
		for (WebElement e : elements) {
			String text = e.getText().trim();
			if (!text.isEmpty()) {
				playerNames.add(text);
			}
		}
		return playerNames;
	}

}