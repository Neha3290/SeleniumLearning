package SeleniumGrid;

/* For registering a hub
 * java -jar selenium-server-standalone-3.141.59.jar -role hub
 * 
 * For registering a node
 * java -Dwebdriver.gecko.driver="C:\Driver\geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.42.217:4444/grid/register/

 */
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridChromeAsHubAndFirefoxAsNode {
	
	static WebDriver driver;
	static String nodeURL;
	
	@Test (priority=1)
	void setUp() throws MalformedURLException {
		System.out.println("Hello world=1");
		
		nodeURL = "http://192.168.42.217:4444/wd/hub";
		URL node = new URL(nodeURL);
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		//cap.setPlatform(Platform.WIN10);		
		System.out.println("Hello world=2");
		
		FirefoxOptions options = new FirefoxOptions();
		options.merge(cap);
		
		driver = new RemoteWebDriver(node,options);
		//driver.manage().window().maximize();
		System.out.println("Hello world=3");
	}
	
	
	@Test (priority=2)
	void LoginFunct() {
		System.out.println("Hello world=4");		
		driver.get("http://practice.automationtesting.in/my-account/");	
		driver.findElement(By.id("username")).sendKeys("ayushi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("AyushiGupta@123");
		driver.findElement(By.name("login")).click();
		
		System.out.println("Hello world=5");
		String str = driver.findElement(By.xpath("//div[@id='body']//p[1]")).getText();
		if(str.contains("ayushi ")==true) {
			System.out.println("User is log in successfully.");
		}else {
			System.out.println("User does not log in successfully.");
		}
	}

}
