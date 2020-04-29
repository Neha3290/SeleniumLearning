package PageObjectModel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPageObjectExecution1 {

		@Test
		
		public void verifyFlyingReg(){
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	
		
		//Open URL
		driver.get("http://newtours.demoaut.com/");
		
		
			
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
		
		RegPageObj.ClickSubmit();
		
	
		
		//Validation
		
		WebElement ExpectedTxt = driver.findElement(By.xpath("//body//table//table//table//table//p[2]"));		
		if(ExpectedTxt.isDisplayed()) {
			System.out.println("User Successfully Registered");
		}else {
			System.out.println("User Does Not Registered Successfully");
		}
	}

}


