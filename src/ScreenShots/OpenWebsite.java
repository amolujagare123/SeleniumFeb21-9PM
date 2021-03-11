package ScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class OpenWebsite {

    @Test
    public void myTest() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

        // 1. create a object reference of an interface TakesScreenshot
        //    and assign the driver to it (type cast it to TakesScreenshot)
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. using the object reference of TakesScreenshot (ts) call the method getScreenshotAs
        // and store this into a file object

       File scrFile =  ts.getScreenshotAs(OutputType.FILE);

       // 3. create a real image file / copy the file object into a real file

       FileUtils.copyFile(scrFile,new File("D:\\MyProg\\image.jpg"));






    }
}
