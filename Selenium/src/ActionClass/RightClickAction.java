/* Test Case -->
 * 1. Open Url - https://swisnl.github.io/jQuery-contextMenu/demo.html
 * 2. Then right clck on "Right Click Me" button
 * 3. click on Quit Button
 * 4. Switch to alert pop up
 * 5. Click OK Button.
 */

package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Orange Hrm Login Page
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement btn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement QuitBtn = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-quit']"));
		
		Actions act = new Actions(driver);
		act.contextClick(btn).moveToElement(QuitBtn).click().build().perform();
		
		driver.switchTo().alert().accept();

	}

}
