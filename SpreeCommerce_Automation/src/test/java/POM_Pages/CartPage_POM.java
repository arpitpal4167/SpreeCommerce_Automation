package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class CartPage_POM extends BasePage{
	
	private Logger log = LogManager.getLogger(CartPage_POM.class);
	public CartPage_POM(WebDriver driver) 
	{
		super(driver);
		
}
	
	@FindBy(xpath = "//header//button[2]")
	private WebElement cartIcon;

	@FindBy(xpath = "//a[@href='/us/en/cart']")
	private WebElement viewCart;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/div[1]/div/div[1]/div[3]/button")
	private WebElement removeProduct;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/div[1]/div/div[1]/div[3]/button")
	private WebElement btn_ConShopping;
	
	@FindBy(xpath = "/html/body/main/div/div/div[2]/div/div/a[1]")
	private WebElement btn_checkout;
	
	public void click_on_cartIcon()
	{
		cartIcon.click();
		log.info("Clicked on Cart Icon");
	}
	
	public void click_on_viewCart()
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", viewCart);

	    log.info("Clicked on View Cart");
	}
	
	public void click_on_contiuneShopping()
	{
		btn_ConShopping.click();
		log.info("Clicked on Contiune Shopping");
	}
	
	public void click_on_checkout()
	{
		btn_checkout.click();
		log.info("Clicked on Checkout button");
	}

}
