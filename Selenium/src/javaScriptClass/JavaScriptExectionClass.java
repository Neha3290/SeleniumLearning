package javaScriptClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExectionClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	

		//Open Orange Hrm Login Page
		driver.get("https://www.twoplugs.com/");
		
		WebElement element = driver.findElement(By.xpath("//ul[@class='control-bar']//li[2]//a[1]"));
		
		
		// For Flash An Element
		JavaScriptUtil.flash(element, driver);
		
		// For Drawing A Border Around An Element
		JavaScriptUtil.drawBorder(element, driver);
		Thread.sleep(3000);
		
		// For Taking The Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("D:\\Automation Testing\\Practice\\Screenshot1");
		FileUtils.copyFile(src, trg);
		
		
		// For Get the Title Of The Page 
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println("The Title Of The Page : "+title);
		
		
		//For Clicking An Element Using JavaScript
		JavaScriptUtil.clickElementByJS(element, driver);
		Thread.sleep(3000);
		
		//Show Alert Message
		JavaScriptUtil.generateAlertMsg(driver, "You Just Clikcked On Join Now For Free Button");
		
		//For Refreshing The Page
		JavaScriptUtil.refreshPageByJS(driver);
		
		//Scroll Till An Element
		WebElement icon = driver.findElement(By.xpath("//span[@class='w-icons-slide2']"));
		JavaScriptUtil.scrollIntoView(icon, driver);
		
		//Scroll Page Till Bottom Of The Page
		JavaScriptUtil.scrollPageDown(driver);
		
		//driver.close();
	}

}
