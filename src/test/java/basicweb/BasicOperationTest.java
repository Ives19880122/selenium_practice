package basicweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@Slf4j
public class BasicOperationTest {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        baseUrl = "https://tw.yahoo.com";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        log.info("開啟網頁");
        driver.get(baseUrl);
        log.info("點擊登入頁");
        driver.findElement(By.id("header-signin-link")).click();
        log.info("輸入登入資訊");
        driver.findElement(By.name("username")).sendKeys("sample@yahoo.com.tw");
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
