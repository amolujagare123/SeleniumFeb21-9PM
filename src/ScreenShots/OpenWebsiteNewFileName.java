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
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenWebsiteNewFileName {

    @Test
    public void myTest() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com");

        // 1. create a object reference of an interface TakesScreenshot
        //    and assign the driver to it (type cast it to TakesScreenshot)
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. using the object reference of TakesScreenshot (ts) call the method getScreenshotAs
        // and store this into a file object

       File scrFile =  ts.getScreenshotAs(OutputType.FILE);


       // 3. create a real image file / copy the file object into a real file

        Date date = new Date(); // date to string --> FDS / PSD

        SimpleDateFormat sd = new SimpleDateFormat("_yyyyddMM_hhmmss");

        String timestamp = sd.format(date);

        String name = "IMG"+timestamp+".jpg";

        FileUtils.copyFile(scrFile,new File("D:\\MyProg\\"+name));








    }
}
