package usefulmethods;

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
public class GetAttributeDemoTest {

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
    public void test(){
        driver.navigate().to(resource);
        WebElement elm = driver.findElement(By.id("name"));
        String type = elm.getAttribute("type");
        log.info("屬性值為:{}",type);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
