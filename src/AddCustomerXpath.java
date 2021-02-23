import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddCustomerXpath {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("admin");

        WebElement  txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

       // Thread.sleep(10000); // compulsory 10 sec wait.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // maximum wit is 10 sec

       // WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[@href='add_customer.php']"));
        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[text()='Add Customer']"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.xpath("//input[@name='name']"));
        txtName.sendKeys("Kajal");

        WebElement txtContact1 = driver.findElement(By.xpath("//input[@name='contact1']"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.xpath("//input[@name='contact2']"));
        txtContact2.sendKeys("3232323");


        WebElement txtAddress = driver.findElement(By.xpath("//textarea[@name='address']"));
        txtAddress.sendKeys("xyz pqr");

        WebElement btnSubmit = driver.findElement(By.xpath("//input[@value='Add']"));
        btnSubmit.click();
    }

}
