import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumDemo2 {

    public static void main(String[] args) {

        // 1. open a browser / chrome

       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
*/

       /* WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/


        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();


        // 2. maximize

        driver.manage().window().maximize();

       // driver.manage().window().fullscreen();
        // 3. open website

        driver.get("https://facebook.com"); // www.facebook.com

        driver.navigate().to("http://gmail.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

}
