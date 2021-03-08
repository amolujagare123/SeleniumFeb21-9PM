package TestNGDemo.AssertDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest2 {

    @Test
    public void logintest1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement  txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        String expected = "Dashboard";
        String actual ="";
        try {
            actual = driver.findElement(By.xpath("//a[contains(@class,'active-tab')]")).getText();
        }
        catch (Exception e)
        {

        }
        Thread.sleep(3000);

       Assert.assertEquals(actual,expected,"we are not on the dashboard page");






    }
}
