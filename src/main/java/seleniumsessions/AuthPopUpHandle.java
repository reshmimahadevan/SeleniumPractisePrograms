package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUpHandle {

	public static void main(String[] args) {

		// handle auth pop:
		// basic authentication: username/password

		String username = "admin";
		String password = "admin";

		WebDriver driver = new ChromeDriver();
		// Supplying username and password in the url
		// It will not work if un/pwd contains @:As 2 @ not possible
		// driver.get("https://" + username + ":" + password + "@" +
		// "the-internet.herokuapp.com/basic_auth");

//		https://  admin  :  admin  @  the-internet.herokuapp.com/basic_auth
//		└──┬──┘   └──┬┘  │  └──┬┘  │  └───────────────────┬──────────────────┘
//		 Protocol  User  │  Password                     Host / Domain
//		                 │         │
//		          Separates       Separates credentials 
//		         User & Pass       from the Domain

		// selenium 4.x:
		// basic auth: it will work for any un/pwd : with @ also it will work only for chroium based browsers: chrome, edge
		// If you try to launch using other than chromium browser then classcast exception will come
		// Refer AuthPopUpHandle Onedrive for heirarchy
		// () -> Anonymous and Lambda
		
		((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
		// Casts the driver to support logins, sets a background listener for password prompts, and automatically injects the credentials when requested.

		driver.get("https://the-internet.herokuapp.com/basic_auth");

		String mesg = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		System.out.println(mesg);

	}

}
