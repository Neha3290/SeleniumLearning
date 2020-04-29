package javaScriptClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	// 1. For Flashing An Element
	
	public static void flash(WebElement element, WebDriver driver){		
		
		String bgColor = element.getCssValue("backgroundColor");
		
		for(int i=0; i<=20; i++) {
			
			changeColor("#000000", element, driver);
			changeColor(bgColor, element, driver);
		}
	
			
	}


	public static void changeColor(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try {
			Thread.sleep(30);
		}catch(InterruptedException e){}
		
	}
	
	
		
	// 2. For Drawing A Border Around An Element
		
	public static void drawBorder(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border ='3px solid blue'", element);
	}
	
	
	// 3. To Return The Title Of The Page
	
	public static String getTitleByJS(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		
		return title;
	}
	
	
	// 4. For Clicking An Element Using JavaScript
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// 5. For Generating Alert Info
	public static void generateAlertMsg(WebDriver driver, String Message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+Message+"')");
		
	}
	
	// 5. For Refreshing the current page
		public static void refreshPageByJS(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
		}
		
	//6. Scroll Till An Element
		public static void scrollIntoView(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
		}
		
		//6. Scroll Till Bottom Of The Page
		public static void scrollPageDown(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
		}
	
}