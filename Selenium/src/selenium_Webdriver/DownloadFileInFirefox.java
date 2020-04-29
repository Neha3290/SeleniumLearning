package selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileInFirefox {

	public static void main(String[] args) {

System.setProperty("webdriver.gecko.driver","D:/Automation Testing/geckodriver.exe");
			
		
		//Creating Browser Profile
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain"); //Set MIME Type
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		WebDriver driver = new FirefoxDriver(option);
		
		//Maximize the Window	
		driver.manage().window().maximize();
		
		//Open Url
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		
		driver.findElement(By.id("textbox")).sendKeys("Testing");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		

	}

}
