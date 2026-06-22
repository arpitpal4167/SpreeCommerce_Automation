package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class CheckoutPage_POM extends BasePage {

	private Logger log = LogManager.getLogger(CheckoutPage_POM.class);

	public CheckoutPage_POM(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "ship-country")
	private WebElement selectCountry;
	
	@FindBy(id = "ship-first_name")
	private WebElement shipfirstname;

	@FindBy(id = "ship-last_name")
	private WebElement shipLastName;

	@FindBy(id = "ship-company")
	private WebElement shipCompany;

	@FindBy(id = "ship-address1")
	private WebElement shipAddress;

	@FindBy(id = "ship-city")
	private WebElement shipCity;

	@FindBy(id = "ship-state")
	private WebElement shipState;

	@FindBy(id = "ship-postal_code")
	private WebElement shipPostalcode;

	@FindBy(id = "ship-phone")
	private WebElement shipPhone;

	@FindBy(xpath = "//*[@id=\"checkout-section-payment\"]/div/div[1]/div[1]/label")
	private WebElement paymentOption;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/label/button")
	private WebElement sameshipAddress;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/button")
	private WebElement btn_placeorder;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[1]/div[2]/div[5]/a")
	private WebElement btn_contiuneshopping;
	
	
	
	
	public void enterShippingAddress(String country, String fname, String lname,
	        String company, String address, String city,
	        String state, String postalCode, String phone) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-country")));

	    Select sc = new Select(selectCountry);
	    sc.selectByVisibleText(country);

	    wait.until(ExpectedConditions.visibilityOf(shipfirstname));
	    shipfirstname.clear();
	    shipfirstname.sendKeys(fname);

	    wait.until(ExpectedConditions.visibilityOf(shipLastName));
	    shipLastName.clear();
	    shipLastName.sendKeys(lname);

	    wait.until(ExpectedConditions.visibilityOf(shipCompany));
	    shipCompany.clear();
	    shipCompany.sendKeys(company);

	    wait.until(ExpectedConditions.visibilityOf(shipAddress));
	    shipAddress.clear();
	    shipAddress.sendKeys(address);

	    wait.until(ExpectedConditions.visibilityOf(shipCity));
	    shipCity.clear();
	    shipCity.sendKeys(city);

	    wait.until(ExpectedConditions.visibilityOf(shipState));
	    Select st = new Select(shipState);
	    st.selectByVisibleText(state);

	    wait.until(ExpectedConditions.visibilityOf(shipPostalcode));
	    shipPostalcode.clear();
	    shipPostalcode.sendKeys(postalCode);

	    wait.until(ExpectedConditions.visibilityOf(shipPhone));
	    shipPhone.clear();
	    shipPhone.sendKeys(phone);

	    log.info("Shipping Address Entered Successfully");
	}
	
	public void selectPaymentOption()
	{
	    paymentOption.click();
	}

	public void clickSameShippingAddress()
	{
	    sameshipAddress.click();
	}

	public void clickPlaceOrder()
	{
	    btn_placeorder.click();
	}
	
	public void click_contiune_shopping()
	{
		btn_contiuneshopping.click();
	}

}
