package PageObjectModel;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4JExample {

		@Test		
		
		
		public void verifyFlyingReg(){
			
		Logger logger = Logger.getLogger("Log4JExample");
		DOMConfigurator.configure("log4j.xml");
		
		logger.info("Browser opened");
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		logger.info("Maximize the window");
		driver.manage().window().maximize();	
		
		logger.info("URL opened");
		driver.get("http://newtours.demoaut.com/");
		
		
		logger.info("All info into the form are submitted");
		RegistrationPageObjectsMethod2 RegPageObj = new RegistrationPageObjectsMethod2(driver);
		
		RegPageObj.ClickRegisterLink();		
		
		RegPageObj.EnterFName("Neha");
		
		RegPageObj.EnterLName("Gupta");
		
		RegPageObj.EnterPhone("9876543210");
		
		RegPageObj.EnterEmail("nehagupta@gmail.com");
		
		RegPageObj.EnterAddr1("Natraj Colony");
		
		RegPageObj.EnterAddr2("Tonk Road");		
		
		RegPageObj.EnterCity("Jaipur");
		
		RegPageObj.EnterState("Rajasthan");
		
		RegPageObj.EnterPostalCode("302015");
		
		RegPageObj.EnterCountry("92");	
				
		RegPageObj.EnterUserName("nehagupta3290");
		
		RegPageObj.EnterPasssword("NehaGupta");
		
		RegPageObj.EnterCnfrmPasssword("NehaGupta");
		
		logger.info("Submit button is clicked");
		RegPageObj.ClickSubmit();
		
	
		
		logger.info("Validation is checked that user does registered successfully or not");
		
		WebElement ExpectedTxt = driver.findElement(By.xpath("//body//table//table//table//table//p[2]"));		
		if(ExpectedTxt.isDisplayed()) {
			System.out.println("User Successfully Registered");
		}else {
			System.out.println("User Does Not Registered Successfully");
		}
	}

}
	


