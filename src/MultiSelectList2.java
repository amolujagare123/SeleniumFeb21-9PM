import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectList2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.click.in/pune/60/post.html");

        WebElement jobLocation = driver.findElement(By.id("source_118"));

        Select selJobLocation = new Select(jobLocation);

        selJobLocation.selectByIndex(1);
        selJobLocation.selectByIndex(2);
        selJobLocation.selectByIndex(4);

        driver.findElement(By.xpath("//*[@id=\"post_form\"]/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/img[1]")).click();

        WebElement locationAdded = driver.findElement(By.id("fld_118"));

        Select selLocationAdded = new Select(locationAdded);

        selLocationAdded.selectByIndex(1);
        selLocationAdded.selectByIndex(2);

        driver.findElement(By.xpath("//*[@id=\"post_form\"]/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/img[2]")).click();
    }
}
