import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillinDemoWithCssPath {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://billing.scriptinglogic.net/");

        //WebElement txtUsername = driver.findElement(By.cssSelector("input#email"));
        WebElement txtUsername = driver.findElement(By.cssSelector("#email"));
        txtUsername.sendKeys("amolujagare@gmail.com");

       // WebElement txtPassword = driver.findElement(By.cssSelector("input#password "));
        WebElement txtPassword = driver.findElement(By.cssSelector("#password"));
        txtPassword.sendKeys("admin123");

       // WebElement btnLogin = driver.findElement(By.cssSelector("input.btn"));
        WebElement btnLogin = driver.findElement(By.cssSelector(".btn"));
        btnLogin.click();
    }
}
