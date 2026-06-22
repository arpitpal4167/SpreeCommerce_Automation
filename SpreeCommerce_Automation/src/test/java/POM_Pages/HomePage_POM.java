package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class HomePage_POM extends BasePage {

    private Logger log = LogManager.getLogger(HomePage_POM.class);

    public HomePage_POM(WebDriver driver) {
        super(driver);
    }

    // User Icon
    @FindBy(xpath = "//a[contains(@href,'login') or contains(@href,'account') or contains(@href,'user')]")
    private WebElement btn_User;
    
    // Sign Out
    @FindBy(xpath = "//button[contains(.,'Sign Out') or contains(.,'Logout') or contains(.,'Log out')]")
    private WebElement signout;

    // Search Icon
    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[3]/button[1]")
    private WebElement searchicon;

    // Search Input
    @FindBy(xpath = "//*[@id='search-overlay']/div/div/div/form/div/input")
    private WebElement searchInput;

    public void click_on_UserIcon() {
        btn_User.click();
        log.info("Clicked User icon");
    }

    public void click_on_signout() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signout);

    }

    public void click_on_searchIcon() {
        searchicon.click();
        log.info("Search opened");
    }

    public void search_product(String product) {
        searchInput.clear();
        searchInput.sendKeys(product);
        searchInput.sendKeys(Keys.ENTER);
        log.info("Product searched: {}", product);
    }

    public void logout_process() throws InterruptedException {
    	Thread.sleep(2000);
    	click_on_UserIcon();
        Thread.sleep(2000);
        click_on_signout();
    }

    public void search_productname(String product) throws InterruptedException {
        click_on_searchIcon();
        Thread.sleep(2000);
        search_product(product);
    }
}