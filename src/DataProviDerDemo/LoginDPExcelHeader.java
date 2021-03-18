package DataProviDerDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginDPExcelHeader {

    @Test (dataProvider = "getData")
    public void loginTest(String user, String pass)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys(user);

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys(pass);

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.close();
    }


    @DataProvider
    public Object[][] getData() throws IOException {


       // 1. Read the excel file
        FileInputStream fis = new FileInputStream("Data\\MyDataDemo.xls");

       // 2. Convert object form of file into workBook
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        // 3. identify sheet and create a sheet object
        HSSFSheet sheet = workbook.getSheet("Sheet2");

        // 4. count the active rows in excel sheet

        int rowCount = sheet.getPhysicalNumberOfRows();

        // rows x columns
        Object[][] data = new Object[rowCount-1][2];

        for(int i=0;i<rowCount-1;i++) //i=0
        {
            HSSFRow row = sheet.getRow(i+1);

            HSSFCell user = row.getCell(0);
            data[i][0]  = user.toString().trim();

            HSSFCell pass = row.getCell(1);
            data[i][1] = pass.toString().trim();

        }



        return data;

    }

}
