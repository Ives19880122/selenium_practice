package basicweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@Slf4j
public class ElementStateTest {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        baseUrl = "https://www.google.com.tw";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        log.info("開啟網頁");
        driver.get(baseUrl);
        log.info("確認網頁狀態");
        WebElement element = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        log.info("輸入匡是否啟用:{}",element.isEnabled());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
