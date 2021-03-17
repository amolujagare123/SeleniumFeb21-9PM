package TestNGDemo.DemoReal;

import TestNGDemo.DemoReal.Utilities.initTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites extends initTests {



    @Test
    public void naukri()
    {
        driver.get("https://naukri.com");
    }

    @Test
    public void monster()
    {
        driver.get("https://monster.com");
    }

    @Test
    public void shine()
    {
        driver.get("https://shine.com");
    }

}
