/* Test Case -->
 * 1. Open Url "http://testautomationpractice.blogspot.com/"
 * 2. Go to field "Select a Animal"
 * 3. Extend this drop down
 * 4. Now Check drop down is sorted or not
 */


package selenium_Webdriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class VerifyDropDownSorting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Url "http://testautomationpractice.blogspot.com/" and Maximize the window
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
				
		//Go to field "Select a Animal"
		WebElement element = driver.findElement(By.xpath("//select[@id='animals']"));
		Select se = new Select(element);
		
		List OriginalList = new ArrayList();
		List tempList = new ArrayList();
		List <WebElement> options= se.getOptions();
		for(WebElement e:options) {
			OriginalList.add(e.getText());
			tempList.add(e.getText());
		}
		
		System.out.println("Original List= "+OriginalList);
			
		
		//Sort the tempList
		Collections.sort(tempList);
		System.out.println("Sorted List= "+tempList);

				
		if(tempList.equals(OriginalList)) {
			System.out.println("List is Sorted");
		}else {
			System.out.println("List is  not Sorted");			
		}
			
		
		
	}

}
