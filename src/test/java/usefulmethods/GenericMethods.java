package usefulmethods;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
        }else if("classname".equals(type)){
            log.info("用classname查找路徑:{}", locator);
            return driver.findElement(By.className(locator));
        } else if ("tagname".equals(type)) {
            log.info("用tagname查找路徑:{}", locator);
            return driver.findElement(By.tagName(locator));
        } else if ("linktext".equals(type)) {
            log.info("用linktext查找路徑:{}", locator);
            return driver.findElement(By.linkText(locator));
        } else if ("partiallinktext".equals(type)) {
            log.info("用partiallinktext查找路徑:{}", locator);
            return driver.findElement(By.partialLinkText(locator));
        } else {
            log.info("定位的路徑不支援");
        }
        return null;
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase();
        List<WebElement> list = new ArrayList<>();
        if("id".equals(type)){
            list = driver.findElements(By.id(locator));
        }else if("xpath".equals(type)){
            list = driver.findElements(By.xpath(locator));
        }else if("name".equals(type)){
            list = driver.findElements(By.name(locator));
        }else if("css".equals(type)){
            list = driver.findElements(By.cssSelector(locator));
        }else if("classname".equals(type)){
            list = driver.findElements(By.className(locator));
        }else if("tagname".equals(type)){
            list = driver.findElements(By.tagName(locator));
        }else if("linktext".equals(type)){
            list = driver.findElements(By.linkText(locator));
        }else if("partiallinktext".equals(type)){
            list = driver.findElements(By.partialLinkText(locator));
        }else{
            log.info("定位的路徑不支援");
        }
        if(list.isEmpty()){
            log.info("用 {} : {} 沒有找到元素",type,locator);
        }else{
            log.info("元素用 {} : {} 找到了",type,locator);
        }
        return list;
    }

    public boolean isElementPresent(String locator, String type){
        List<WebElement> list = getElementList(locator, type);
        return list.isEmpty();
    }
}
