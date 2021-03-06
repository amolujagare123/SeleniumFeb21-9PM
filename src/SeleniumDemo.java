import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {

    public static void main(String[] args) {

        // 1. open a browser / chrome

        /*System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/


        System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver(); // upcasting


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
