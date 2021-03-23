package DataProviDerDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static DataProviDerDemo.util.DataProviderUtil.readAndGetSheet;

public class AddCustomerDemo {
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
    }

    @Test(dataProvider = "getData")
    public void addCustomerTest(String name,String add,String con1,String con2)  {


       // Thread.sleep(10000); // compulsory 10 sec wait.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // maximum wit is 10 sec

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys(name);

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys(con1);

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys(con2);


        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys(add);

        WebElement btnSubmit = driver.findElement(By.name("Submit"));
        btnSubmit.click();
    }


    @DataProvider
    public Object[][] getData() throws IOException {

       Object[][] data = readAndGetSheet("Data\\addCustomer.xlsx","addCostomer");

       return  data;

       // return readAndGetSheet("Data\\addCustomer.xlsx","addCostomer");
    }

}
