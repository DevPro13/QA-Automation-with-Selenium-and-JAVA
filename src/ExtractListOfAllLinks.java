import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtractListOfAllLinks {
    /*
     Write a Selenium test script to extract a list of all links (all the elements that have anchor
tag) present on a web page and print them.
     */
    String webURL="https://www.letskodeit.com/practice";
    WebDriver driver;
 @Before
    public void DriverSetup(){
        String chromeDriverLocation = System.getProperty("user.home") + "/Selenium/ChromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void DriverDrop(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Test
    public void ListOfAllLinks() throws InterruptedException{
     driver.get(webURL);
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     List<WebElement>linkElementList=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a")));
     for(WebElement linkItem:linkElementList){
          System.out.println(linkItem.getText());
     }
    }
    public static void main(String[] args) {
     ExtractListOfAllLinks extractListOfAllLinksInstance=new ExtractListOfAllLinks();
     try{
     extractListOfAllLinksInstance.DriverSetup();
     extractListOfAllLinksInstance.ListOfAllLinks();
     extractListOfAllLinksInstance.DriverDrop();
     }
     catch(InterruptedException e){
          e.printStackTrace();
     }

    }
    
}
