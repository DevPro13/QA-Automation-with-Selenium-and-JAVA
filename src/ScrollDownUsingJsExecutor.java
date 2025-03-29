import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ScrollDownUsingJsExecutor {
/*Write a Selenium test script to execute JavaScript code to scroll down to the bottom of a
web page. (use JavaScript Executor)
*/
String webURL="https://ecommercepractice.letskodeit.com/about";
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
    public void VerifyScrollDownWithJsExecutor() throws InterruptedException{
        driver.get(webURL);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(2000);
        //move to top
        jsExecutor.executeScript("window.scrollBy(0,-1000);");
        Thread.sleep(2000);
        //move to buttom
        WebElement footer=driver.findElement(By.xpath("//div[@class=\"Footer-module--contentBottomContainer--95bf8\"]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",footer);
        Thread.sleep(2000);
        //another way
        //go to top
        String scriptTop="window.scrollTo(0,-document.body.scrollHeight);";
        jsExecutor.executeScript(scriptTop);
        Thread.sleep(2000);
        //again go down
        String scriptButtom="window.scrollTo(0,document.body.scrollHeight);";
        jsExecutor.executeScript(scriptButtom);
        Thread.sleep(2000);

    }

    
}