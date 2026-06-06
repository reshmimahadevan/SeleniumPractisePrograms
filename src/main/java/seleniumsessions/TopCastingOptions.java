package seleniumsessions;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//Refer Diagram in OneDrive - Selenium Architecture

		// 1.CD = CD only Chrome
		// Not Top Casting / Valid
		// ChromeDriver driver = new ChromeDriver();

		// 2.WD d new CD
		// Valid and recommended
		// Only for Local Execution
		// Limitation : ChromeDriver methods(Individual methods) cannot be accessed/Thats y no methods implementations are not present inside it
		// WebDriver driver = new ChromeDriver();

		// 3.SC d = new CD
		// Valid but not recommended as only FE and FE's method from SC are only available
		// SearchContext driver = new ChromeDriver();

		// 4.WD d = new RWD();
		// Valid and recommended
		// Used when we want to run test cases in Remote Machine/Cloud/AWS grid
		// WebDriver driver = new RemoteWebDriver(remoteAddress , capabilities); //OS/Browser

		// 5.SC d = new RWD();
		// Valid but not recommended as only FE and FE's method from SC are only available
		// Used when we want to run it in remote machines
		// SearchContext driver = new RemoteDriver(remoteAddress , capabilities);

		// 6.RWD d = new CD();
		// Valid and recommended
		// Local Execution
		// RemoteDriver driver = new ChromeDriver();

		// 7.Chromium d = new CD();
		// Not recommended as it works only for Chromium based browsers(Chrome/Edge) and not for (Firefox/Safari)
		// Local Execution
		// ChromiumDriver d = new ChromeDriver();

		// 8.RWD d = new RWD ();
		// Not Top Casting / Valid but only for Remote execution
		// RemoteWebDriver driver = new RemoteWebDriver(new URL("192.178.11.2:4444/wd/hub"),capabilities); // OS/Browser

	}

}
