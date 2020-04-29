package selenium_Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaveFileUsingRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D://Automation Testing//geckodriver.exe/");
		WebDriver driver =new FirefoxDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Open Url
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.findElement(By.id("textbox")).sendKeys("Testing");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		Thread.sleep(3000);
		
		Robot robot = new Robot();
		
		//1.Press Down Arrow Key  2. Three Times Press Tab Key    3. Press Enter Key
		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		
		

	}

}
