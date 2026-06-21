package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utility_Files.ExtentManager_Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    public WebDriver wd;
    public Properties prop;
    public static Logger Log = LogManager.getLogger(BaseTest.class);
    
 

    @BeforeMethod
    public void initialize_n_OpenBrowser(Method method) throws IOException {

        prop = new Properties();

        FileInputStream fis = new FileInputStream(
            System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"
        );

        prop.load(fis);

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            wd = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            wd = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            wd = new EdgeDriver();
        } 
        else {
            System.out.println("Invalid browser name in config.properties");
        }

        wd.manage().window().maximize();
        wd.get(prop.getProperty("url"));

        Log.info("Browser launched and navigated to URL");
    }

    @AfterMethod
    public void closeBrowser() {
        wd.quit();
        Log.info("Browser closed");
    }
}