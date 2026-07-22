
package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

	// 1
	@BeforeSuite
	public void startDBConnection() {
		System.out.println("BS- start DBConnection");
	}

	// 2
	@BeforeTest
	public void createUser() {
		System.out.println("BT - Createuser");
	}

	// 3
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC - LaunchBrowser");

	}

	// 4 7 10-> 3 tests are there so runs 3 times and with alphabet order
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM - LoginToApp");
	}

	// 8
	@Test
	public void homePageTitleTest() {
		System.out.println("homePageTitleTest");
	}

	// 11
	@Test
	public void homePageURLTest() {
		System.out.println("homePageURLTest");
	}

	// 5
	@Test
	public void homePageSearchTest() {
		System.out.println("homePageSearchTest");
	}

	// 6 9 12
	@AfterMethod
	public void logout() {
		System.out.println("AM - Logout");
	}

	// 13
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - CloseBrowser");

	}

	// 14
	@AfterTest
	public void deleteUser() {
		System.out.println("AT - Deleteuser");
	}

	// 15
	@AfterSuite
	public void disconnetWithDatabase() {
		System.out.println("AS- disconnet with DBConnection");
	}

}
