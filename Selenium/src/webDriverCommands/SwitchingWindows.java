/* Test Case -->
 * 1. Open Url "http://demo.automationtesting.in/Windows.html"
 * 2. Go to "Open New Tabbed Window >> click"
 * 3. Switch to window "http://www.sakinalium.in/"
 */ 

package webDriverCommands;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Url "http://demo.automationtesting.in/Windows.html" and Maximize the window
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		
		//Go to "Open New Tabbed Window >> click"
		driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();
		driver.findElement(By.xpath("//div[@id='Tabbed']//button[@class='btn btn-info'][contains(text(),'click')]")).click();
		//System.out.println("Current Window = "+driver.getTitle());
		
		//Switch to window "http://www.sakinalium.in/"
		Set <String>s = driver.getWindowHandles();
		String title;
		for(String i:s) {
			title = driver.switchTo().window(i).getTitle();
			System.out.println("Title of The Window  = "+title);
			
			//Close Only Parent Window
			if(title.contains("Frames & windows"))
				driver.close();
		}
		
		//For Closing All The Open Windows
	    //driver.quit();	

	}

}
