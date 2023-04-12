package utility;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WaitTypes {
   private WebDriver driver;
   public WaitTypes(WebDriver driver){
       this.driver = driver;
   }

   public WebElement waitForElement(By locator,int timeout){
       WebElement element = null;
       try {
           log.info("最長等待了{}秒元素可用",timeout);
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
           element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
           log.info("元素在頁面上出現了");
       }catch (Exception e){
           log.error("元素沒有在頁面上出現");
       }
       return element;
   }

    public WebElement clickWhenReady(By locator,int timeout){
        WebElement element = null;
        try {
            log.info("最長等待了{}秒元素可點擊",timeout);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            log.info("在頁面上點擊了元素");
        }catch (Exception e){
            log.error("元素沒有在頁面上出現");
        }
        return element;
    }
}
