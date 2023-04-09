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
public class RadioButtonsAndCheckBoxesTest {

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
        log.info("找RadioButton BMW 點擊");
        WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();
        Thread.sleep(2000);
        log.info("找RadioButton Benz 點擊");
        WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
        benzRadioBtn.click();
        Thread.sleep(2000);
        log.info("找CheckBox BMW 點擊");
        WebElement bmwCheckBtn = driver.findElement(By.id("bmwcheck"));
        bmwCheckBtn.click();
        Thread.sleep(2000);
        log.info("找CheckBox Benz 點擊");
        WebElement benzCheckBtn = driver.findElement(By.id("benzcheck"));
        benzCheckBtn.click();

        log.info("BMW Radio 是否被選中:{}",bmwRadioBtn.isSelected());
        log.info("Benz Radio 是否被選中:{}",benzRadioBtn.isSelected());
        log.info("BMW CheckBox 是否被選中:{}",bmwCheckBtn.isSelected());
        log.info("Benz CheckBox 是否被選中:{}",benzCheckBtn.isSelected());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
