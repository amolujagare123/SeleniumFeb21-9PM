package TestNGDemo.DemoReal;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

    WebDriver driver;

    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }


    @Test (priority = 2)
    public void facebbok()
    {
        driver.get("https://facebook.com");
    }
    @Test (priority = 3)
    public void instagram()
    {
        driver.get("https://instagram.com");

        Assert.assertEquals(true,false, "this test is failed");
    }

    @Test (priority = 1)
    public void twitter()
    {
        driver.get("https://twitter.com");
    }
}
