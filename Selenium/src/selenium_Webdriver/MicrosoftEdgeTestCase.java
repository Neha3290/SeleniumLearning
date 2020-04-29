package selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MicrosoftEdgeTestCase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "D:/Automation Testing/Microsoft Edge Webdriver/MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.close();

	}

}
