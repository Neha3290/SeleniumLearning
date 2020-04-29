package selenium_Webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncodingAndDecoding {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	

		//Open Orange Hrm Login Page
		 driver.get("https://www.nopcommerce.com/login");
		
		String str= "Test123";
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded String is="+new String(encodedString));
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		String decodedPwd =  new String(decodedString);
		System.out.println("Decoded String is ="+decodedPwd);
		
		driver.findElement(By.id("Username")).sendKeys("Admin");
		driver.findElement(By.id("Password")).sendKeys("decodedPwd");
		
		driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
		
		driver.findElement(By.xpath("//div[@class='form-fields']//input[@class='btn blue-button']")).click();
	}

}
