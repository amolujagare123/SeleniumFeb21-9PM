import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingDemo {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://billing.scriptinglogic.net/");

        WebElement txtUsername  = driver.findElement(By.id("email"));
        txtUsername.sendKeys("amolujagare@gmail.com");

        WebElement  txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.name("btn_login"));
        btnLogin.click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='View Clients']")).click();

        String clientName = "A1QW Pvt Ltd";


        // click on option button

        driver.findElement(By.xpath("//tr[td/a[text()='"+clientName+"']]/td/div")).click();

        driver.findElement(By.xpath("//tr[td/a[text()='"+clientName+"']]//i[contains(@class,'edit')]")).click();


    }
}
