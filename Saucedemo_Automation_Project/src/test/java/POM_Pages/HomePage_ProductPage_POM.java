package POM_Pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import helper.BasePage;

public class HomePage_ProductPage_POM extends BasePage
{

	private Logger log = LogManager.getLogger(HomePage_ProductPage_POM.class);
	
	public HomePage_ProductPage_POM(WebDriver wd)
	{
		super(wd);
	}
	
	//Locator repository 
	@FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")WebElement menu;
	@FindBy(partialLinkText = "Logout")WebElement logout;
	@FindBy(id  = "add-to-cart-sauce-labs-bike-light")WebElement addcart;
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")WebElement cart;
	
	public void click_on_menu()
	{
		menu.click();
		log.info("Navigating to to menu");
	}
	
	public void click_on_logout()
	{
		logout.click();
		log.info("Navigating to login page");
	}
	
	public void click_on_add_to_cart_button()
	{
		addcart.click();
		log.info("Product added to cart");
	}
	
	public void click_on_cart_icon()
	{
		cart.click();
		log.info("Navigating to cart page");
	}
	
	public void logout_process() throws InterruptedException
	{
	Thread.sleep(2000);	
	click_on_menu();
	Thread.sleep(2000);	
	click_on_logout();
	Thread.sleep(2000);	
	
	}
}


