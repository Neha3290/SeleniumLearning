package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageObjectsMethod2 {

	
	WebDriver driver;
	//@FindBy(how=How.LINK_TEXT, using ="REGISTER")
	//WebElement RegisterLink;
	
	@FindBy(linkText="REGISTER")
	WebElement RegisterLink;
	
	//@FindBy(how=How.NAME, using ="firstName")
	//WebElement FirstName;
	
	@FindBy(name="firstName")
	WebElement FirstName;
	
	@FindBy(name="lastName")
	WebElement LastName;
	
	@FindBy(name="phone")
	WebElement Phone;
	
	@FindBy(name="userName")
	WebElement Email;

	@FindBy(name="address1")
	WebElement Address1;
	
	@FindBy(name="address2")
	WebElement Address2;
	
	@FindBy(name="city")
	WebElement City;

	@FindBy(name="state")
	WebElement State;
	
	@FindBy(name="postalCode")
	WebElement PostalCode;
	
	@FindBy(name="country")
	WebElement Country;
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;

	@FindBy(name="confirmPassword")
	WebElement CnfrmPwd;
	
	@FindBy(name="register")
	WebElement Submit;

	
	RegistrationPageObjectsMethod2(WebDriver d) {
		
		//this.driver = d;
		driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	public void ClickRegisterLink() {
		
		RegisterLink.click();
	}
	
	
	public void EnterFName(String fname) {
		
		FirstName.sendKeys(fname);
	}
	
	public void EnterLName(String lname) {
		
		LastName.sendKeys(lname);
	}
	
	public void EnterPhone(String phoneNo) {
		
		Phone.sendKeys(phoneNo);
	}
	
	public void EnterEmail(String email) {
		
		Email.sendKeys(email);
	}
	
	public void EnterAddr1(String address1) {
		
		Address1.sendKeys(address1);
	}
	
	public void EnterAddr2(String address2) {
		
		Address2.sendKeys(address2);
	}
	
	public void EnterCity(String city) {
		
		City.sendKeys(city);
	}
	
	public void EnterState(String state) {
		
		State.sendKeys(state);
	}
	


	public void EnterPostalCode(String postalCode) {
		
		PostalCode.sendKeys(postalCode);
	}
	
	
	public void EnterCountry(String country) {			
		
		Select se = new Select(Country);	
		se.selectByValue(country);
	}
	
	public void EnterUserName(String userName) {
		
		UserName.sendKeys(userName);
	}
	
	public void EnterPasssword(String password) {
		
		Password.sendKeys(password);
	}
	
	public void EnterCnfrmPasssword(String cnfrmPassword) {
		
		CnfrmPwd.sendKeys(cnfrmPassword);
	}
	
	public void ClickSubmit() {
		
		Submit.click();
	}
	



}
