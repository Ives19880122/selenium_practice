package usefulmethods;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.URL;
import java.time.Duration;

@Slf4j
public class GenericMethodsDemoTest {

    private WebDriver driver;
    private URL resource;
    private GenericMethods gm;

    @Before
    public void setUp(){
        resource = this.getClass().getResource("/PracticePage.html");
        driver = new EdgeDriver();
        gm = new GenericMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.navigate().to(resource);
        WebElement elm = gm.getElement("name","id");
        elm.sendKeys("test");
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

}
