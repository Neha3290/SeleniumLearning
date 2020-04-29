package selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingWebPageUsingSeleniumWebDriver {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	

		//Open Orange Hrm Login Page
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		Thread.sleep(5000);
		
		// Scroll By Pixels
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000, 5000)", "");
		
		
		// Scroll By Element
		WebElement flag = driver.findElement(By.xpath("//table[1]//tbody[1]//tr[86]//td[1]//img[1]"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		
		// Scroll Page Till Bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		driver.close();

	}

}
