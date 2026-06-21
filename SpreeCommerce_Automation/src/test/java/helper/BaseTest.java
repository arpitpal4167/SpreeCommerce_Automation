package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeOptions;

import reports.ExtentManager;

public class BaseTest {

    public WebDriver wd;
    public Properties prop;

    public static Logger Log = LogManager.getLogger(BaseTest.class);

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getReport();
    }

    @BeforeMethod
    public void initialize_n_OpenBrowser(Method method) throws IOException {

        test = extent.createTest(method.getName());

        prop = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + "\\src\\test\\resources\\config.properties");

        prop.load(fis);

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            wd = new ChromeDriver(options);
       
        } else if (browser.equalsIgnoreCase("firefox")) {
            wd = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-extensions");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--user-data-dir=C:\\JenkinsEdgeProfile");

            wd = new EdgeDriver(options);
        }

        wd.manage().window().maximize();
        wd.get(prop.getProperty("url"));

        Log.info("Browser launched");
        test.info("Browser launched");
    }

    @AfterMethod
    public void closeBrowser() {

        if (wd != null) {
            wd.quit();
        }

        Log.info("Browser closed");
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
    }
}