import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToIframe {
    /*
     Write a Selenium test script to switch to an iframe, perform some action, and then switch back to the default content.
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
    public void verifySwitchToIframe() throws InterruptedException{
        driver.get(webURL);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));//wait till 20 seconds.
        //switch to iframe using frameElement
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='courses-iframe']")));
        /*
        //switch to by frame id
        driver.switchTo().frame("courses-iframe");
        //Switch to by frame index and frame index starts form 0
        driver.switchTo().frame(0);
        //switch back to parent frame
        driver.switchTo().parentFrame();
        */
        //perform some action
        //I am going to click on the sign in button
        WebElement iframeSignInElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-inverse-collapse\"]//div//a[@href='/login']")));
        iframeSignInElement.click();
        Thread.sleep(2000);
        //switch back to default or root frame/ primary frame
        driver.switchTo().defaultContent();
        //click on signin on parent page
        WebElement parentSignInElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-inverse-collapse\"]//div//a[@href='/login']")));
        parentSignInElement.click();
        Thread.sleep(2000);


    }
    
}
