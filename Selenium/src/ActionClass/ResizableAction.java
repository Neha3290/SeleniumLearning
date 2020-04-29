package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizableAction {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Orange Hrm Login Page
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		
		
		act.moveToElement(element).dragAndDropBy(element, 100, 100).build().perform();
		Thread.sleep(5000);

	}

}
