package POM_Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class LoginPage_POM extends BasePage {

    private WebDriver wd;
    private Logger log = LogManager.getLogger(LoginPage_POM.class);

    public LoginPage_POM(WebDriver driver) {
        super(driver);
        this.wd = driver;
    }

    @FindBy(id = "email")
    private WebElement Login_emailInput;

    @FindBy(id = "password")
    private WebElement Login_passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_signup;

    public void enteremail(String Lemail) {
        Login_emailInput.clear();
        Login_emailInput.sendKeys(Lemail);
        log.info("Entered email");
    }

    public void enterpassword(String Lpass) {
        Login_passwordInput.clear();
        Login_passwordInput.sendKeys(Lpass);
        log.info("Entered password");
    }

    public void clicksignupbtn() {
        btn_signup.click();
        log.info("Clicked Login button");
    }

    public void login(String Lemail, String Lpass) {
        wd.get("https://demo.spreecommerce.org/us/en/account");

        System.out.println("Current URL = " + wd.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));

        enteremail(Lemail);
        enterpassword(Lpass);
        clicksignupbtn();
    }
}