package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class Registration_Page extends BasePage{

	private Logger log = LogManager.getLogger(Registration_Page.class);
	public Registration_Page(WebDriver driver) {
		super(driver);
	}
	
	//Locators repository
	
	 @FindBy(xpath = "//a[@href='/us/en/account']")
	    private WebElement RegistrationIcon;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/div[3]/p/a")
	private WebElement click_Signup;
	
	@FindBy(id = "firstName")
	private WebElement firstnameInput;
	
	@FindBy(id = "lastName")
	private WebElement lastnameInput;
	
	@FindBy(id = "email")
	private WebElement emailInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "passwordConfirmation")
	private WebElement confirmpasswordInput;
	
	@FindBy(id = "policy-consent")
	private WebElement checkbox;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/div[2]/form/div[6]/button")
	private WebElement btn_createaccount;
	
	//Action repository
	
	public void UserIcon()
	{
	    RegistrationIcon.click();
	    log.info("Clicked Registration icon");
	}
	
	public void clicksignup()
	{
		click_Signup.click();
		log.info("Clicked SignUp");
	}
	
	public void enterfirstname(String fname)
	{
		firstnameInput.clear();
		firstnameInput.sendKeys(fname);
		log.info("Entered Firstname: {}",fname);
		
	}
	
	public void enterlastname(String lname)
	{
		lastnameInput.clear();
		lastnameInput.sendKeys(lname);
		log.info("Entered Lastname");
	}
	
	public void enteremail(String email)
	{
		emailInput.clear();
		emailInput.sendKeys(email);
		log.info("Entered Email");
	}
	
	public void enterpassword(String password)
	{
		passwordInput.clear();
		passwordInput.sendKeys(password);
		log.info("Entered Password");
		}
	
	public void enterconfirmpassword(String confirmpass)
	{
		confirmpasswordInput.clear();
		confirmpasswordInput.sendKeys(confirmpass);
		log.info("Entered ConfirmPassword");
		
	}
	
	public void clickcheckbox()
	{
		checkbox.click();
		log.info("Clicked Checkbox terms&condition");
		
	}
	
	public void click_createaccount() {
		btn_createaccount.click();
		log.info("Account created");
	}
	
	public void Registrations(String fname, String lname, String email, String password, String confirmpass) throws InterruptedException
	{
		UserIcon();
		Thread.sleep(2000);
		clicksignup();
		Thread.sleep(2000);
		enterfirstname(fname);
		Thread.sleep(2000);
		enterlastname(lname);
		Thread.sleep(2000);
		enteremail(email);
		Thread.sleep(2000);
		enterpassword(password);
		Thread.sleep(2000);
		enterconfirmpassword(confirmpass);
		Thread.sleep(2000);
		clickcheckbox();
		Thread.sleep(2000);
		click_createaccount();
		Thread.sleep(2000);
	}
	
	
	

}
