package selenium_Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaleElementReferenceError {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();
		
		//Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Load the page
		driver.get("http://www.pavantestingtools.com/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
			
		WebElement training = driver.findElement(By.xpath("//a[contains(text(),'Training')]"));
		
		training.click();
				
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		//For generating StaleElementReferenceException 
		//training.click();
		
		//For preventing the StaleElementReferenceException
		
		try{
			
			training.click();
					
		}catch(StaleElementReferenceException e) {
			
			training = driver.findElement(By.xpath("//a[contains(text(),'Training')]"));
			
			training.click();
		}
		
		driver.close();
	}

}
