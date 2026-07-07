package seleniumsessions;

public class Wait {

	public static void main(String[] args) {

		// wait -- sync between script vs app
		// auto wait

		// 1. static wait: Thread.sleep(10000) -- Java lib
		// e1 --> 2 secs --> total timeout : 10 secs
		// e1 -- 0 secs --> total timeout : 10 secs
		// e1 -- 15 secs --> total timeout : 10 secs

		// 2. dynamic wait: total time
		// 10 secs: 2 secs -->
		// 10 secs : 15 secs 
		// a. Implicitly wait  -> does not dynamically adjust wait in case of 15 secs
		// b. Explicit wait
		// b.1: WebDriverWait
		// b.2: FluentWait
	}

}
