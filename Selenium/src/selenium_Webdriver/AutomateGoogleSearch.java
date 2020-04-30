package selenium_Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();
		
		//Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open Google Page
		driver.get("http://google.com");
		
		//Wait for Proper loading of the page
		Thread.sleep(3000);
		
		driver.findElement(By.id("fakebox-input")).sendKeys("Java Tutorials");
		
		//driver.close();

	}

}
