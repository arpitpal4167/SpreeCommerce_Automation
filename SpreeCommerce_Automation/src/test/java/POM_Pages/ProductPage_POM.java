package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class ProductPage_POM extends BasePage{
	
	private Logger log = LogManager.getLogger(ProductPage_POM.class);
	public ProductPage_POM(WebDriver driver) 
	{
		super(driver);

}
	
	
	 @FindBy(xpath = "(//a[contains(@href,'products')])[1]")
	    private WebElement product;
	
	 @FindBy(xpath = "//button[contains(text(),'Add To Cart') or contains(text(),'Add to Cart')]")
	 private WebElement btn_addtocart;
	
	@FindBy(xpath = "//*[@id=\"radix-_R_snpffb_\"]/div[1]/button")
	private WebElement btn_back;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Close') or contains(text(),'Close')]")
	private WebElement btn_closePopup;
	
	public void select_product() throws InterruptedException
	{
		product.click();
		Thread.sleep(2000);
		log.info("product selected");
	}
	
	public void click_on_addtocart() throws InterruptedException
	{
	    Thread.sleep(3000);
	    btn_addtocart.click();
	    log.info("Product added to cart");
	}
	
	public void close_cart_popup()
	{
	    btn_closePopup.click();
	    log.info("Cart popup closed");
	}
	
	public void back_to_product()
	{
		btn_back.click();
		log.info("back to productpage");
	}
	
	
}
