package TestNGDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginDemoBeforeAfter {
    WebDriver driver;

    @BeforeMethod // this method runs before every test method
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod // this method runs after every test method
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void logintest1()
    {

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
     //   btnLogin.click();
    }

    @Test
    public void logintest2()
    {

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("tyty");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("yty");

        WebElement btnLogin = driver.findElement(By.name("submit"));
    //    btnLogin.click();
    }

    @Test
    public void logintest3()
    {

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.name("submit"));
      //  btnLogin.click();
    }
}
