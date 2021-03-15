package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static ExtentReportDemo.util.TakingScreenShot.takeScreenshot;

public class LoginDemo {

    ExtentSparkReporter reporter;
    ExtentReports extent;

    @BeforeClass
    public void initExtentReport()
    {
        reporter = new ExtentSparkReporter("Reports\\report.html");
        extent = new ExtentReports();

        reporter.config().setDocumentTitle("Stock Management Project");
        reporter.config().setReportName("All regression tests");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project Name","Stock Management");
        extent.setSystemInfo("Dev Name","Tushar Paal");
        extent.setSystemInfo("Testers Name","Kajal Sahu");
        extent.setSystemInfo("Report Date","15/03/2021");
    }

    @AfterClass
    public void createReport()
    {
        extent.flush();
    }

    @Test
    public void loginTestValidInput() throws IOException {
        ExtentTest test = extent.createTest("loginTestValidInput");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expected = "https://stock.scriptinglogic.net/dashboard.php1";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "this is not  a dashboard");
            test.pass("we are on dash board");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }

    }

    @Test
    public void loginTestInValidInput() throws IOException {
        ExtentTest test = extent.createTest("loginTestInValidInput");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("dsds");

        test.info("wrong username is entered");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("ewewe");

        test.info("wrong password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expected = "https://stock.scriptinglogic.net/index.php?msg=Wrong%20Username%20or%20Password&type=error";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "incorrect error page");
            test.pass("we got proper error");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());

            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }
    }

    @Test
    public void loginTestBlankInput() throws IOException {
        ExtentTest test = extent.createTest("loginTestBlankInput");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");

        test.info("username is not entered");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        test.info("password is not entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expected = "https://stock.scriptinglogic.net/";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "incorrect error page");
            test.pass("we got proper error");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }
    }
}
