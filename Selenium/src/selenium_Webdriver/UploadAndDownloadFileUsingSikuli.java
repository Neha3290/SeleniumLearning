package selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UploadAndDownloadFileUsingSikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
					
		//Maximize the Window
		driver.manage().window().maximize();
		
		
		WebElement BrowseButton = driver.findElement(By.id("imagesrc"));
		
		
		if(BrowseButton.isDisplayed()) {
			//String ImagePath = "D:\\Automation Testing\\Practice\\";
			//String InputPath = "D:\\Automation Testing\\Practice\\";
			
			BrowseButton.click();
			
			
			Screen s = new Screen();
			
			Pattern fileNameTextField = new Pattern("D:\\Automation Testing\\Practice\\TextField.png");
			Pattern OpenButton = new Pattern("D:\\Automation Testing\\Practice\\OpenButton.png");
			
			Thread.sleep(5000);
			
			s.wait(fileNameTextField, 20); //Wait FileName Text Field to appear
			s.type(fileNameTextField, "D:\\Automation Testing\\Practice\\Image.jpg");
			
			s.click(OpenButton);
			
			Thread.sleep(5000);
		
		}
		

	}

}
