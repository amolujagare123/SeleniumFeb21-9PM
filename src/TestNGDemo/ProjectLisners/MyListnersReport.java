package TestNGDemo.ProjectLisners;

import TestNGDemo.DemoReal.Utilities.initTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static TestNGDemo.ProjectLisners.util.InitializeReport.initExtentReport;
import static TestNGDemo.ProjectLisners.util.InitializeReport.screenshotForListners;

public class MyListnersReport extends initTests implements ITestListener {

    public static ExtentReports extent;
    static ExtentTest test;

    public void onStart(ITestContext context) {
        System.out.println("==>onStart");
        if(extent==null)
            extent = initExtentReport();
    }



    public void onTestStart(ITestResult result) {
        System.out.println("==>onTestStart");
       test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("==>onTestSuccess");
        test.pass("this test is passed:"+result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("==>onTestFailure");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+screenshotForListners(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("==>onTestSkipped");
        test.skip("this test is skipped");
    }


    public void onFinish(ITestContext context) {

        System.out.println("==>onFinish");

        extent.flush();
    }

}
