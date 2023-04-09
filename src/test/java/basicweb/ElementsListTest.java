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
import java.util.List;

@Slf4j
public class ElementsListTest {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception{
        log.info("開啟網頁");
        driver.get(baseUrl);
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='cars' and @type='radio']"));
        int size = radioButtons.size();
        log.info("集合大小為:{}",size);
        for (WebElement btn : radioButtons){
            boolean isChecked = btn.isSelected();
            if(!isChecked){
                btn.click();
                Thread.sleep(2000);
            }
        }
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
