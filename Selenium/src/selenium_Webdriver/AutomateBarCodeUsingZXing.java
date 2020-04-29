package selenium_Webdriver;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class AutomateBarCodeUsingZXing {

	public static void main(String[] args) throws IOException, NotFoundException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	
		
		//Open URL
		driver.get("http://testautomationpractice.blogspot.com/");
		
		// Get The SRC Attribute of Barcode Element
		String barcodeUrl = driver.findElement(By.xpath("//div[@id='HTML12']//div[@class='widget-content']//img[1]")).getAttribute("src");
		
		// Get The Actual Url from String barcodeUrl
		URL url = new URL(barcodeUrl);
		
		//Get Buffered Image from this Actual URl
		BufferedImage bufferedImage = ImageIO.read(url);
		
		//Create a New Luminance Source Variable Using This BufferedImage
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		
		//Create a Variable of BinaryBitmap Class Uding HybridBinarizer and luminanceSource Object
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		//Get Result from this binaryBitmap Object by Using MultiFormatReader Class
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		//Get Text From This result Object
		String barcodeText = result.getText();
		
		//Pring this Barcode text
		System.out.println(barcodeText);
		
		driver.close();
		
		
		
		
	}

}
