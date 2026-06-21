package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import helper.BasePage;

public class CheckoutPage_POM extends BasePage {

	private Logger log = LogManager.getLogger(CheckoutPage_POM.class);

	public CheckoutPage_POM(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[@id=\"ship-country\"]")
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
	
	
	
	
	public void enterShippingAddress(String country, String fname, String lname, String company, String address,
			String city, String state, String postalCode, String phone) throws InterruptedException {
		
		Select sc = new Select(selectCountry);
		sc.selectByVisibleText(country);

		shipfirstname.clear();
		Thread.sleep(2000);
		shipfirstname.sendKeys(fname);
		Thread.sleep(2000);
		shipLastName.clear();
		Thread.sleep(2000);
		shipLastName.sendKeys(lname);
		Thread.sleep(2000);
		shipCompany.sendKeys(company);
		Thread.sleep(2000);
		shipAddress.sendKeys(address);
		Thread.sleep(2000);
		shipCity.sendKeys(city);

		Select st = new Select(shipState);
		st.selectByVisibleText(state);

		shipPostalcode.sendKeys(postalCode);
		shipPhone.sendKeys(phone);
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
