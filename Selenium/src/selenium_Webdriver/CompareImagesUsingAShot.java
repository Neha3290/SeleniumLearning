package selenium_Webdriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImagesUsingAShot {

	public static void main(String[] args) throws IOException {

		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	
		
		//Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		
		WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		//Read Expected image from device
		BufferedImage expectedImage = ImageIO.read(new File("D://Automation Testing/Practice/OrangeHRMLogo.png"));
		
		//Capture Screenshot from the live site
		Screenshot screenshot = new AShot().takeScreenshot(driver, logoImageElement);
		
		BufferedImage actualImage = screenshot.getImage();
		
		ImageDiffer diff = new ImageDiffer();
		
		ImageDiff difference = diff.makeDiff(expectedImage, actualImage);
		
		if(difference.hasDiff()==true) {
			System.out.println("Both Images Are Not Same");
		}else {
			System.out.println("Both Images Are Same");
		}
		
		
		

	}

}
