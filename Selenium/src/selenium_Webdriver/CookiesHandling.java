package selenium_Webdriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookiesHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D://Automation Testing//geckodriver.exe/");
		WebDriver driver =new FirefoxDriver();
		
		//Open Url
		driver.get("https://www.amazon.in/");
		
		Set <Cookie>allCookies = driver.manage().getCookies();
		
		System.out.println("Total No of Cookies = "+allCookies.size());
		
		for(Cookie c:allCookies) {
			
			System.out.println(c.getName()+"-->"+c.getValue());		
			
		}
		
		//Access any Cookie by its Name
		
		System.out.println(driver.manage().getCookieNamed("session-id-time"));
		driver.close();
	}

}
