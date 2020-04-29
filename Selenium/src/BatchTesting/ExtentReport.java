package BatchTesting;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/MyOwnReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Batch Testing Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser Info", "Chrome");
		extent.setSystemInfo("User Name", "Neha Gupta");
				
	}
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.manage().window().maximize();
	}
	
	//Method 1: Test Title of The Login Page of Orange HRM.
	@Test (priority=1)	
	public void TestTitle() {
		test = extent.createTest("TestTitle");
		String title = "OrangeHRM";
		System.out.println("Title of the page = "+driver.getTitle());
		Assert.assertEquals(title,driver.getTitle());		
	}
	
	//Method 2: Check Logo of Orange HRM is Displayed or not.
	@Test (priority=2)
	public void TestLogo() {
		test = extent.createTest("TestLogo");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Boolean status =driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) div:nth-child(4) div:nth-child(1) > img:nth-child(1)")).isDisplayed();
		System.out.println("Status of the Logo = "+status);
		Assert.assertTrue(status);
	}
	
	//Method 3: Test the functionality of Login with valid and invalid credentials.
	@Test (priority=3)
	public void TestLogin() throws InterruptedException {
		
		test =extent.createTest("TestLogin");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Boolean statusValid = driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).isDisplayed();
		System.out.println(statusValid);		
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();	
	
		Assert.assertTrue(statusValid);
		/*Actions act = new Actions(driver);
		
		WebElement Welcome = driver.findElement(By.xpath("//a[@id='welcome']"));		
		act.moveToElement(Welcome).clickAndHold().build().perform();
		WebElement Logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));	
		act.moveToElement(Logout).click().build().perform();*/
		
		
		
		test.createNode("Login With Invalid Id and Password");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Boolean statusInvalid = driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
		System.out.println("Status after invalid credentials ="+statusInvalid);
		Assert.assertTrue(statusInvalid);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed Is = "+result.getName());
			test.log(Status.FAIL, "Test Case Failed Due To"+result.getThrowable());
			
			String screeenshotPath = ExtentReport.getScreenShot(driver, result.getName());
			test.addScreenCaptureFromPath(screeenshotPath);	
			
		}else if(result.getStatus() ==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped = "+result.getName());
			test.log(Status.SKIP, "Test Case Skipped Due To ="+result.getThrowable());	
	
			
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Is Passed = "+result.getName());
			
		}
			
	}	
	
	public static String getScreenShot(WebDriver driver, String ScreenShotName) throws IOException {
		
		String DateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//After Execution You Could See a Folder "FailedTestScreenshot" Under Src Folder
		String destinationPath = System.getProperty("user.dir")+"/Screenshot/"+ScreenShotName+".png";
		File target = new File(destinationPath);
		FileUtils.copyFile(source,target);
		return destinationPath;
		
	}
	
	

}
