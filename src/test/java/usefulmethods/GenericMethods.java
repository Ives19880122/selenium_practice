package usefulmethods;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class GenericMethods {

    WebDriver driver;

    public GenericMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){
        type = type.toLowerCase();
        if("id".equals(type)){
            log.info("用id查找路徑:{}",locator);
            return driver.findElement(By.id(locator));
        }else if("xpath".equals(type)){
            log.info("用xpath查找路徑:{}",locator);
            return driver.findElement(By.xpath(locator));
        }else{
            log.info("定位的路徑不支援");
        }
        return null;
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase();
        if("id".equals(type)){
            log.info("用id查找路徑:{}",locator);
            return driver.findElements(By.id(locator));
        }else if("xpath".equals(type)){
            log.info("用xpath查找路徑:{}",locator);
            return driver.findElements(By.xpath(locator));
        }else{
            log.info("定位的路徑不支援");
        }
        return null;
    }
}
