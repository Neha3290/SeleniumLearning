package selenium_Webdriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsingHashMap {
	
	
	static HashMap <String, String> LoginData(){		
		
		HashMap <String, String> hm = new HashMap <String, String>();
		hm.put("A", "nehagupta3290@NehaGupta");
		hm.put("B", "Mercury1@Mercury1");
		hm.put("C", "Mercury2@Mercury2");
		hm.put("D", "Mercury3@Mercury3");
			
		return hm;
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();	
		
		//Open URL
		driver.get("http://newtours.demoaut.com/");
		
		//Fetching data of A from HashMap		
		String crendentials = LoginData().get("A");
		
		//Split UserName and Password and store in a string array variable
		String arr[] = crendentials.split("@");
		
		//Find element and put the value of UserNaMe and Password in it
		driver.findElement(By.name("userName")).sendKeys(arr[0]);
		driver.findElement(By.name("password")).sendKeys(arr[1]);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		if(ExpTitle.equals(ActTitle)) {
			System.out.println("User Registered Successfully");
			driver.findElement(By.linkText("Home")).click();
		}else {
			
			System.out.println("User Does Not Registered Successfully");
		}
		
		
	}
	

}
