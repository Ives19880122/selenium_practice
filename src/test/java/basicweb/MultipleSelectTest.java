package basicweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.time.Duration;
import java.util.List;

@Slf4j
public class MultipleSelectTest {

    WebDriver driver;
    URL resource;

    @Before
    public void setUp(){
        resource = this.getClass().getResource("/PracticePage.html");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception{
        driver.navigate().to(resource);
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(element);

        // 注意值分大小寫
        Thread.sleep(2000);
        log.info("Select orange by value");
        select.selectByValue("orange");

        Thread.sleep(2000);
        log.info("DeSelect orange by value");
        select.deselectByValue("orange");

        Thread.sleep(2000);
        log.info("Select peach by index");
        select.selectByIndex(2);
        
        Thread.sleep(2000);
        log.info("Select apple by text");
        select.selectByVisibleText("苹果");
        
        // 顯示所有被選中的值
        List<WebElement> options = select.getAllSelectedOptions();
        int size = options.size();
        log.info("all selected count : {}",size);
        for(WebElement option : options){
            String optionsText = option.getText();
            log.info(optionsText);
        }

        Thread.sleep(2000);
        log.info("de-select all selected options");
        select.deselectAll();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
