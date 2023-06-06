package basicweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@Slf4j
public class NavigatingBetweenPagesTest {

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
    public void test() throws Exception{
        log.info("開啟網頁");
        driver.get(baseUrl);
        String toUrl = "https://tw.news.yahoo.com/";
        log.info("跳轉至新聞頁");
        driver.navigate().to(toUrl);
        log.info("回到上一頁");
        driver.navigate().back();
        Thread.sleep(2000);
        log.info("回到下一頁");
        driver.navigate().forward();
        Thread.sleep(2000);
        log.info("重新整理");
        driver.navigate().refresh();
        Thread.sleep(2000);
        /*
         * log.info("取得當前頁面資源");
         * driver.getPageSource();
         */
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
