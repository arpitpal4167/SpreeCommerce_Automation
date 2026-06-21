package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;
import helper.BaseTest;

public class LoginPage_POM extends BasePage{

	private Logger log = LogManager.getLogger(LoginPage_POM.class);
	public LoginPage_POM(WebDriver driver) 
	{
		super(driver);
		
}
	
	//Locators repository
	
	@FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/div[2]/a" )
	private WebElement btn_UserIcon;
	
   @FindBy(id = "email")
   private WebElement Login_emailInput;
   
   @FindBy(id = "password")
   private WebElement Login_passwordInput;
   
   @FindBy(xpath = "/html/body/main/div[1]/div/div[2]/form/div[4]/button")
   private WebElement btn_signup;
   
   @FindBy(xpath = "/html/body/header/div[1]/div/div/div[2]/a/img")
   private WebElement btn_homepage;
   
   public void LoginUserIcon()
	{
	   btn_UserIcon.click();
		log.info("Clicked Registration icon");
	}
   
   public void enteremail(String Lemail) {
	   Login_emailInput.clear();
	   Login_emailInput.sendKeys(Lemail);
	   log.info("Entered email");
   }
   
   public void enterpassword(String Lpass)
   {
	   Login_passwordInput.clear();
	   Login_passwordInput.sendKeys(Lpass);
	   log.info("Entered password");
   }
   
   public void clicksignupbtn()
   {
	   btn_signup.click();
	   log.info("Clicked Signup button");
   }
   
   public void navigatehomepage()
   {
	   btn_homepage.click();
	   log.info("Navigated Home Page");
   }
   
   public void login(String Lemail, String Lpass) throws InterruptedException
   {
	   LoginUserIcon();
	   Thread.sleep(2000);
	   enteremail(Lemail);
	   Thread.sleep(2000);
	   enterpassword(Lpass);
	   Thread.sleep(2000);
	   clicksignupbtn();
	   Thread.sleep(2000);
	   navigatehomepage();
	   Thread.sleep(2000);
   }
	
	
}
