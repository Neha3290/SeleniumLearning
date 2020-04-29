package webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBetweenAlerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Url "http://demo.automationtesting.in/Alerts.html" and Maximize the window
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		// 1. Alert With Single Ok Button
		driver.findElement(By.xpath("//li[@class='active']//a[@class='analystic'][contains(text(),'Alert with OK')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		
		//Click on Ok button, which is appear on alert
		driver.switchTo().alert().accept();
		
		
		// 2. Alert With Ok and Cancel Button
		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// To click on Ok button
		driver.switchTo().alert().dismiss();
		String ExpTxt = "You pressed Ok";
		String ActText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(ExpTxt.equals(ActText))
			System.out.println("You Pressed Ok button");
		else
			System.out.println("You Pressed Cancel button");
		
		
		// 3. Alert with Textbox
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.switchTo().alert().sendKeys("Neha Gupta");
		driver.switchTo().alert().accept();
		String ExpText1 = "Hello Neha Gupta How are you today";
		String ActText1 = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		if(ExpText1.equals(ActText1))
			System.out.println(ActText1);
		else
			System.out.println("Test is fail");
		
	}

}
