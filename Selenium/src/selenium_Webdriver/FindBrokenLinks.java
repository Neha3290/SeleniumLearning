package selenium_Webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException{
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		//Maximize the Window
		driver.manage().window().maximize();
		
		//Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open Orange Hrm Login Page
		driver.get("http://newtours.demoaut.com/");
		
		//Wait for Proper loading of the page
		Thread.sleep(3000);
		
		List <WebElement>links = driver.findElements(By.tagName("a"));
				
		System.out.println("Total No Of Links Available = "+links.size());
		int brokenLinks=0, validLinks=0;
		
		
		for(int i=0; i<links.size(); i++) {
			
			//By Using href property we can get the url of the link
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			URL link = new URL(url);
			
			//Open Url using HttpConnection class and check its status
			HttpURLConnection httpConn =  (HttpURLConnection) link.openConnection();
			
			//Wait for 2 ms
			Thread.sleep(2000);
			
			//Establish Connection
			httpConn.connect();
			
			//Get response 
			int response = httpConn.getResponseCode();
			
			//If response is above 400 then it is a broken link
			
			if(response>=400) {
				System.out.println(link+"--> "+"is a Broken Link");
				brokenLinks++;				
			}else {
				System.out.println(link+"--> "+"is a Valid Link");
				validLinks++;				
				
			}				
					
			
		}
		System.out.println("Total No of Broken Links = "+brokenLinks);
		System.out.println("Total No of Valid Links = "+validLinks);
		

	}

}
