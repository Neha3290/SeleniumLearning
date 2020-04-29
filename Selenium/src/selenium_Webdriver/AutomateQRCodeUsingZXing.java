package selenium_Webdriver;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class AutomateQRCodeUsingZXing {

	public static void main(String[] args) throws IOException, NotFoundException {

		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	
		
		//Open URL
		driver.get("http://testautomationpractice.blogspot.com/");
		
		//Wait For Element to Present
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Get The SRC Attribute of QRCode Element
		String qrCodeUrl= driver.findElement(By.xpath("//img[2]")).getAttribute("src");
		
		// Get The Actual Url from String qrCodeUrl
		URL url = new URL(qrCodeUrl);
		
		//Get Buffered Image from this Actual URl
		BufferedImage bufferedImage = ImageIO.read(url);
				
		//Create a New Luminance Source Variable Using This BufferedImage
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		
		//Create a Variable of BinaryBitmap Class Using HybridBinarizer and luminanceSource Object
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		//Get Result from this binaryBitmap Object by Using MultiFormatReader Class
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		//Get Text From This result Object
		String qrCodeText = result.getText();
		
		//Print this qrCode Text
		System.out.println(qrCodeText);
		
		//Close The Browser
		driver.close();
		
		

	}

}
