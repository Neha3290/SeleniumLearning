package PageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPageObjectsMethod1 {
	
	WebDriver driver;
	
	By RegisterLink= By.linkText("REGISTER");
	By FirstName   = By.name("firstName");
	By LastName    = By.name("lastName");
	By Phone       = By.name("phone");
	By Email       = By.name("userName");
	By Address1    = By.name("address1");
	By Address2    = By.name("address2");
	By City        = By.name("city");
	By State       = By.name("state");
	By PostalCode  = By.name("postalCode");
	By Country     = By.name("country");
	By UserName    = By.name("email");
	By Password    = By.name("password");
	By CnfrmPwd    = By.name("confirmPassword");
	By Submit      = By.name("register");
	
	
	RegistrationPageObjectsMethod1(WebDriver d) {
		
		//this.driver = d;
		driver = d;
		
	}
	
	public void ClickRegisterLink() {
		
		driver.findElement(RegisterLink).click();
	}
	
	
	public void EnterFName(String fname) {
		
		driver.findElement(FirstName).sendKeys(fname);
	}
	
	public void EnterLName(String lname) {
		
		driver.findElement(LastName).sendKeys(lname);
	}
	
	public void EnterPhone(String phoneNo) {
		
		driver.findElement(Phone).sendKeys(phoneNo);
	}
	
	public void EnterEmail(String email) {
		
		driver.findElement(Email).sendKeys(email);
	}
	
	public void EnterAddr1(String address1) {
		
		driver.findElement(Address1).sendKeys(address1);
	}
	
	public void EnterAddr2(String address2) {
		
		driver.findElement(Address2).sendKeys(address2);
	}
	
	public void EnterCity(String city) {
		
		driver.findElement(City).sendKeys(city);
	}
	
	public void EnterState(String state) {
		
		driver.findElement(State).sendKeys(state);
	}
	


	public void EnterPostalCode(String postalCode) {
		
		driver.findElement(PostalCode).sendKeys(postalCode);
	}
	
	
	public void EnterCountry() {
		
		WebElement country = driver.findElement(Country);
		Select se = new Select(country);	
		se.selectByValue("92");
	}
	
	public void EnterUserName(String userName) {
		
		driver.findElement(UserName).sendKeys(userName);
	}
	
	public void EnterPasssword(String password) {
		
		driver.findElement(Password).sendKeys(password);
	}
	
	public void EnterCnfrmPasssword(String cnfrmPassword) {
		
		driver.findElement(CnfrmPwd).sendKeys(cnfrmPassword);
	}
	
	public void ClickSubmit() {
		
		driver.findElement(Submit).click();
	}
	


}
