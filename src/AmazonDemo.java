import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.in");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Amarendra Chitale");
driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

driver.findElement(By.xpath("//img[@alt='NLP Life Transforming Neuro Magical Stories']")).click();
    }

    }
