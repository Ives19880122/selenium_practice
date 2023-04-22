package JavaScriptExecution;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Slf4j
public class ScrollingElementIntoViewTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws Exception{
        js.executeScript("window.location = 'https://www.yahoo.com.tw'");
        Thread.sleep(2000);
        // 向下滾動
        js.executeScript("window.scrollBy(0,3000);");
        Thread.sleep(2000);
        // 向上滾動
        js.executeScript("window.scrollBy(0,-3000);");
        Thread.sleep(2000);
        // 找尋元素並滾動到指定位置
        WebElement elm = driver.findElement(By.xpath("//li/a/span[contains(text(),'訂餐廳')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",elm);
        Thread.sleep(2000);
        // 稍微向上滾動
        js.executeScript("window.scrollBy(0,-190);");
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
