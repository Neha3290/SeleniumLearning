package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridChromeToChrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		System.out.println("Hello world=1");
		// Define Desired Capailities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		// Note : Don't set Platform property if you use same window platform
		//cap.setPlatform(Platform.WIN10);		
		
		// Define Chrome Options
		System.out.println("Hello world=2");
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		System.out.println("Hello world=3");
		String hubURL = "http://192.168.42.217:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);
		
		Thread.sleep(9000);
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
