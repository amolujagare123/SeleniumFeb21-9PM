package DataProviDerDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDP {

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
    }


    @DataProvider
    public Object[][] getData()
    {
        // rows x columns
        Object[][] data = new Object[4][2];

        data[0][0] = "admin"; // username
        data[0][1] = "admin"; // password

        data[1][0] = "amol";
        data[1][1] = "565665";

        data[2][0] = "rohit";
        data[2][1] = "565566";

        data[3][0] = "tushar";
        data[3][1] = "tushar45455";

        return data;

    }

}
