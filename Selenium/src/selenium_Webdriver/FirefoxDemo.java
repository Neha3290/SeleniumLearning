package selenium_Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDemo {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver","D:/Automation Testing/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		System.out.println("Hello Firefox");
		driver.close();

	}

}
