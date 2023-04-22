package JavaScriptExecution;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@Slf4j
public class WindowSizeTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws Exception{
        js.executeScript("window.location = 'https://www.yahoo.com.tw'");
        long height = (long)js.executeScript("return window.innerHeight;");
        long width = (long)js.executeScript("return window.innerWidth;");
        log.info("視窗高度:{},視窗寬度:{}",height,width);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
