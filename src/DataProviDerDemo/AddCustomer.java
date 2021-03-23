package DataProviDerDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
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
import java.io.FileNotFoundException;
import java.io.IOException;
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

        FileInputStream fis = new FileInputStream("Data\\addCustomer.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("addCostomer");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];


        for(int i =0; i<rowCount-1 ;i++)
        {

            XSSFRow row = sheet.getRow(i+1);

           /* XSSFCell name = row.getCell(0);
            data[i][0]  = name.toString().trim();

            XSSFCell address = row.getCell(1);
            data[i][1] = address.toString().trim();

            XSSFCell contact1 = row.getCell(2);
            data[i][2] = contact1.toString().trim();

            XSSFCell contact2 = row.getCell(3);
            data[i][3] = contact2.toString().trim();*/

            for(int j=0;j<colCount;j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j]  = cell.toString().trim();
            }


        }

        return  data;
    }

}
