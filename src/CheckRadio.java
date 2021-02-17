import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckRadio {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/Scriptinglogic%20docs/class%20Activities/Selenium/Mywebsite/amol.html");


        WebElement checkSel = driver.findElement(By.id("check1"));

        System.out.println(checkSel.isSelected());

        checkSel.click();

        WebElement radCucumber = driver.findElement(By.id("rad2"));
        radCucumber.click();

        WebElement checkJava = driver.findElement(By.id("check0"));

        System.out.println(checkJava.isSelected());


    }
}
