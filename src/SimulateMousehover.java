import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimulateMousehover {
    /*Write a Selenium test script to simulate mouse hover action on a specific element using
the Actions class.
 */
    String webURL="https://www.letskodeit.com/practice";
    WebDriver driver;
     @Before
    public void driverSetup(){
        String chromeDriverLocation = System.getProperty("user.home") + "/Selenium/ChromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void removeDriver(){
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void verifyMouseHover()throws InterruptedException{
        driver.get(webURL);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        String hoverElementXpath="//a[@id='opentab']";
        WebElement hoverElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hoverElementXpath)));
        Actions action=new Actions(driver);
        action.moveToElement(hoverElement);
        action.perform();
        Thread.sleep(2000);
    }
}
