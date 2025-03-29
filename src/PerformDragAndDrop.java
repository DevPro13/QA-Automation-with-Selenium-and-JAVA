import static org.junit.Assert.assertEquals;
import java.time.Duration;
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

public class PerformDragAndDrop {
    String webURL="https://www.w3schools.com/html/html5_draganddrop.asp";
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
    public void verifyDragAndDrop() throws InterruptedException{
        driver.get(webURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        Actions action= new Actions(driver);
        WebElement dragElementLocator=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='div1']")));
        WebElement expectedElement=driver.findElement(By.xpath("//*[@id='div1']//img[@id='drag1']"));
        WebElement dropElementLocator=driver.findElement(By.xpath("//*[@id='div2']"));
        //start drag and drop
        // action.clickAndHold(dragElementLocator);
        // action.moveToElement(dropElementLocator);
        // action.release(dropElementLocator);
        // action.perform();
        //This can be used instead to perform the same job
        action.dragAndDrop(dragElementLocator, dropElementLocator).build().perform();
        //Verify expected webElement at destination
        WebElement obtainedElement=driver.findElement(By.xpath("//*[@id='div2']//img[@id='drag1']"));
        assertEquals(expectedElement.getAttribute("id"),obtainedElement.getAttribute("id"));
    }
}
