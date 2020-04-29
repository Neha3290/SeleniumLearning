/* Test Case-->
 * 1. Open Url https://opensource-demo.orangehrmlive.com/
 * 2. LogIn to this Url with correct UserName and Password
 * 3. Go to Admin >> User Management >> Users Using MouseOver Actions of Actions class
 * 4. Count Total No of Enable Users from this WebTable and display it.
 */

package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverAction {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Open Orange Hrm Login Page
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//Login in Orange Hrm site
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();
		
		//Go to Admin >> User Management >> Users Page
		/*driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click(); */
		
		//Using MouseOver action of Actions class
		Actions act = new Actions(driver);
		WebElement Admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement UserManagement = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement Users = driver.findElement(By.id("menu_admin_viewSystemUsers"));
		
		act.moveToElement(Admin).moveToElement(UserManagement).moveToElement(Users).click().build().perform();
				
		//Count Total No of Enable Users from this WebTable and display it
		int row = driver.findElements(By.xpath("//body//tbody//tr")).size();
		System.out.println("Total No Of Users="+row);
		int Count=0;
		for(int j=1; j<=row ; j++) {
			String txt = driver.findElement(By.xpath("//tr["+j+"]//td[5]")).getText();
			if(txt.equals("Enabled")) {
				Count++;
			}
		
		}
		System.out.println("Total No of Enabled Users= "+Count);
		
		//driver.close();


	}

}
