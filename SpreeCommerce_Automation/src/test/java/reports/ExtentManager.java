package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReport() {

    	ExtentSparkReporter spark =
    			new ExtentSparkReporter(System.getProperty("user.dir")
    			+ "/Reports/ExtentReport.html");

        spark.config().setReportName("Spree Commerce Automation Report");
        spark.config().setDocumentTitle("Automation Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Arpit Pal");
        extent.setSystemInfo("Framework", "Selenium + TestNG + POM + DDF");

        return extent;
    }
}