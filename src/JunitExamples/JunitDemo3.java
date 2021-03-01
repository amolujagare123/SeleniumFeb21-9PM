package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitDemo3 {

    public WebDriver driver;


    @Before // this method will run before every test method
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After // this method will run after every test method
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(4000);
        driver.close();
    }


    @Test
    public void logintest1()
    {
// null pointer exception -->  driver - is not associated/assigned with any value

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
       // btnLogin.click();
    }


    @Test
    public void logintest2()
    {
        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("dfdf");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("dfdfdf");

        WebElement btnLogin = driver.findElement(By.name("submit"));
       // btnLogin.click();
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
       // btnLogin.click();
    }
}
