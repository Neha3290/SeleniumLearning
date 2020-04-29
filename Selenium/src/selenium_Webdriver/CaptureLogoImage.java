package selenium_Webdriver;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	

		//Open Orange Hrm Login Page
		 driver.get("https://opensource-demo.orangehrmlive.com/index.php"
		 		+ "");
		 
		WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		 
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		
		File logoImagePath = new File("D://Automation Testing/Practice/OrangeHRMLogo.png");
		
		ImageIO.write(logoImageScreenshot.getImage(), "png", logoImagePath);
		
		if(logoImagePath.exists()) {
			
			System.out.println("File is Exist");
		}else {
			System.out.println("File is not Exist");
		}
		
		
	driver.close();	
		 
		 

	}

}
