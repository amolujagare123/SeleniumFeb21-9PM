package TestNGDemo.ProjectLisners.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InitializeReport {

    static ExtentSparkReporter reporter;
    static ExtentReports extent;

    public static ExtentReports initExtentReport()
    {
        reporter = new ExtentSparkReporter("Reports1\\report.html");
        extent = new ExtentReports();

        reporter.config().setDocumentTitle("Stock Management Project");
        reporter.config().setReportName("All regression tests");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project Name","Stock Management");
        extent.setSystemInfo("Dev Name","Tushar Paal");
        extent.setSystemInfo("Testers Name","Kajal Sahu");
        extent.setSystemInfo("Report Date","15/03/2021");

        return extent;
    }

    public static String screenshotForListners(WebDriver driver) throws IOException {
        // 1. create a object reference of an interface TakesScreenshot
        //    and assign the driver to it (type cast it to TakesScreenshot)

        TakesScreenshot ts = (TakesScreenshot) driver;
        // 2. using the object reference of TakesScreenshot (ts) call the method getScreenshotAs
        // and store this into a file object

        File scrFile =  ts.getScreenshotAs(OutputType.FILE);

        // 3. create a real image file / copy the file object into a real file

        Date date = new Date(); // date to string --> FDS / PSD

        SimpleDateFormat sd = new SimpleDateFormat("_yyyyddMM_hhmmss");

        String timestamp = sd.format(date);

        String name = "IMG"+timestamp+".jpg";

        FileUtils.copyFile(scrFile,new File("Reports1\\screenshots\\"+name));

        return name;
    }
}
