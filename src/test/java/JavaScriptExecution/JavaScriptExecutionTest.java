package JavaScriptExecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class JavaScriptExecutionTest {

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
        // 開啟網頁
        js.executeScript("window.location = 'https://www.yahoo.com.tw'");
        Thread.sleep(3000);
        // 查詢元素
        WebElement element = (WebElement) js.executeScript("return document.getElementById('header-search-input')");
        // 對查詢框輸入值
        element.sendKeys("Spring Boot 範例");
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
