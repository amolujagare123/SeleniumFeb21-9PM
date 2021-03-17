package TestNGDemo.DemoReal;

import TestNGDemo.DemoReal.Utilities.initTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutorialSites extends initTests {



    @Test
    public void scriptinglogic()
    {
        driver.get("https://scriptinglogic.com");
    }

    @Test
    public void javatpoint()
    {
        driver.get("https://javatpoint.com/");
    }

    @Test
    public void geeksforgeeks()
    {
        driver.get("https://www.geeksforgeeks.org/");
    }
}
