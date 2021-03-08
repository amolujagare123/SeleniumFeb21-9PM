package JunitExamples.demos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by hp on 02-03-2021.
 */
public class Withbeforeafter {

        public WebDriver driver;

     @Before
        public void openbrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @After
        public void closebrowser() {

            driver.close();
    }


    @Test
        public void Guru99(){


        driver.get("http://demo.guru99.com/v4/");

            WebElement username = driver.findElement(By.name("uid"));
            username.sendKeys("mngr308878");

            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("bavyjAd");

            WebElement submit = driver.findElement(By.name("btnLogin"));
            submit.click();


        }
        @Test
        public void BilingDemo(){

            driver.get("http://billing.scriptinglogic.net/index.php/sessions/login\n");

            WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
            username.sendKeys("amolujagare@gmail.com");

            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("admin123");

            WebElement submit = driver.findElement(By.xpath("//input[@name='btn_login']"));
            submit.click();


        }


        @Test
        public void Stockdemo(){

            driver.get("https://stock.scriptinglogic.net/");

            WebElement username = driver.findElement(By.cssSelector("input[id=login-username]"));
            username.sendKeys("admin");

            WebElement password = driver.findElement(By.cssSelector("input[id=login-password]"));
            password.sendKeys("admin");

            WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
            submit.click();


        }




}
