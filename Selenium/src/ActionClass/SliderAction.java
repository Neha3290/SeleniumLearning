package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Orange Hrm Login Page
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		
		act.moveToElement(slider).dragAndDropBy(slider, 100, 400).build().perform();

	}

}
