package waittype;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.WaitTypes;

import java.time.Duration;

@Slf4j
public class ExplicitWaitWithUtilityDemoTest {

    WebDriver driver;
    String baseUrl;
    WaitTypes wt;

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        wt = new WaitTypes(driver);
        baseUrl = "https://pzsc.chanchao.com.tw/";
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        log.info("開啟網頁");
        driver.get(baseUrl);
        log.info("爬取現況人數資料");
        WebElement peopleCount = wt.waitForElement(By.xpath("//span[contains(text(),'體適能中心')]//following-sibling::span"),10);
        log.info("體適能中心現況人數:{}",peopleCount.getText());
        WebElement swimCount = wt.waitForElement(By.xpath("//span[contains(text(),'游泳池')]//following-sibling::span"),10);
        log.info("游泳池現況人數:{}",swimCount.getText());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
