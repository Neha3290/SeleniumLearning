package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Orange Hrm Login Page
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		
		WebElement Stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement Italy = driver.findElement(By.xpath("//div[@id='box106']"));
		
		// Method 1
		act.clickAndHold(Stockholm).moveToElement(Italy).release().build().perform();
		
		//Method 2
		WebElement Rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Denmark = driver.findElement(By.xpath("//div[@id='box104']"));
		act.dragAndDrop(Rome, Denmark).release().build().perform();

	}

}
