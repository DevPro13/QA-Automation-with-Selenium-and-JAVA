import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
    /*Window Handling: Write a Selenium test script to switch between multiple browser
windows or tabs and perform actions on each window.
• Use Appropriate waits instead of Thread.sleep()
• All these tests are to be implemented in Junit.
• Please submit assignments in PDF format with screenshot of code and output for each
task. 
*/
 String webURL="https://www.letskodeit.com/practice";
    WebDriver driver;
 @Before
    public void DriverSetup(){
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
    public void verifyWindowHandlings() throws InterruptedException{
        driver.get(webURL);
        String openWindowBtnXpath="//button[@id='openwindow']";
        String openTabBtnXpath="//div[@class='right-align']//a[@id='opentab']";
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement openWindowBtnElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openWindowBtnXpath)));
        WebElement openTabBtnElement=driver.findElement(By.xpath(openTabBtnXpath));
        openTabBtnElement.click();
        openWindowBtnElement.click();
        Set<String> windowHandles= driver.getWindowHandles();// get all the window ids
        System.out.println(windowHandles.size());

    }  
}
