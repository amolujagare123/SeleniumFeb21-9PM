package TestNGDemo.AssertDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddCustomer {

    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        // Thread.sleep(10000); // compulsory 10 sec wait.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // maximum wit is 10 sec

    }


    @Test
    public void addcustomerTest()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys("Kajal");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("3232323");


        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("xyz pqr");

        WebElement btnSubmit = driver.findElement(By.name("Submit"));
        btnSubmit.click();


        String expected = "Duplicate Entry. Please Verify";
        String actual = "";

        try {
           actual =  driver.findElement(By.xpath("//div[contains(@class,'error')]")).getText();
        }
        catch (Exception e )
        {

        }

        Assert.assertEquals(actual,expected,"incorrect error message");
    }

    @Test
    public void addcustomerTest1()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();


        WebElement btnSubmit = driver.findElement(By.name("Submit"));
        btnSubmit.click();

        String expected = "PLEASE ENTER A CUSTOMER NAME";
        String actual = "";

        try {
            actual =  driver.findElement(By.xpath("//label[@for='name']")).getText();
        }
        catch (Exception e )
        {

        }

        Assert.assertEquals(actual,expected,"incorrect error message");
    }


    @Test
    public void addcustomerTest3()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();
        String custName = "Kajal123";

        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys(custName);

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("3232323");


        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("xyz pqr");

        WebElement btnSubmit = driver.findElement(By.name("Submit"));
        btnSubmit.click();


        String expected = "[ "+custName+" ] Customer Details Added !";
        String actual = "";

        try {
            actual =  driver.findElement(By.xpath("//div[contains(@class,'confirmation')]")).getText();
            System.out.println("actual="+actual);

        }
        catch (Exception e )
        {

        }

        Assert.assertEquals(actual,expected,"incorrect error message");
    }

}
