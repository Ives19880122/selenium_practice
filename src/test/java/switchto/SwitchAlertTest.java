package switchto;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Slf4j
public class SwitchAlertTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws Exception{
        driver.get(baseUrl);
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Ives");
        WebElement alert = driver.findElement(By.id("alertbtn"));
        alert.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

    @Test
    public void test2() throws Exception{
        driver.get(baseUrl);
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Ives");
        WebElement confirm = driver.findElement(By.id("confirmbtn"));
        confirm.click();
        Thread.sleep(3000);
        // accept 與 dismiss 只能執行其中一個
        driver.switchTo().alert().accept();
        // driver.switchTo().alert().dismiss();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(1000);
        driver.quit();
    }
}
