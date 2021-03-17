package TestNGDemo.DemoReal;

import TestNGDemo.DemoReal.Utilities.initTests;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites  extends initTests  {




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
