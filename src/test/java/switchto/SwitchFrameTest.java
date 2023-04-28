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
public class SwitchFrameTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "https://jqueryui.com/datepicker/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception{
        log.info("開啟網頁");
        driver.get(baseUrl);
        driver.switchTo().frame(0);
        // driver.switchTo().frame("name"); 採用name找frame
        // driver.switchTo().frame("id"); 採用id來找到frame
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.click();
        Thread.sleep(3000);
        WebElement date = driver.findElement(By.xpath("//td[@data-year=2023 and @data-month=3]/a[@data-date=19]"));
        date.click();
        log.info("測試完成,result:{}",datepicker.getAttribute("value"));
        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
