package basicweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.URL;
import java.time.Duration;

@Slf4j
public class ElementDisplayedTest {

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
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        log.info("text的顯示:{}",textBox.isDisplayed());
        Thread.sleep(2000);

        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
        log.info("點擊隱藏按鈕");
        Thread.sleep(2000);
        log.info("text的顯示:{}",textBox.isDisplayed());

        WebElement show = driver.findElement(By.id("show-textbox"));
        show.click();
        log.info("點擊顯示按鈕");
        log.info("text的顯示:{}",textBox.isDisplayed());

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
