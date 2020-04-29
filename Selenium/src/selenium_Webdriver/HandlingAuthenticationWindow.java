/* Test Case -->
 * 1. Open Url https://the-internet.herokuapp.com/basic_auth
 * 2. Authenicate Log in Pop up with correct Username and Password
 * 3. Format of pass value on window pop up --> https://Username:Password@the-internet.herokuapp.com/basic_auth
 */

package selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationWindow {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Url "http://demo.automationtesting.in/Windows.html" and Maximize the window
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		WebElement str = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));	
		if(str.isDisplayed())
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Fail");
				
		

	}

}
