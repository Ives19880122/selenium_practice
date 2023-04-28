package switchto;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

@Slf4j
public class SwitchWindowTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception{
        log.info("開啟網頁");
        driver.get(baseUrl);
        String parentWindow = driver.getWindowHandle();
        WebElement open = driver.findElement(By.id("openwindow"));
        open.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles){
            if(!handle.equals(parentWindow)){
                log.info("切換至新開啟視窗");
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.close(); // close current window
            }
        }

        driver.switchTo().window(parentWindow);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
