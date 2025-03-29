import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardCombination {
    /*Write a Selenium test script to copy a text from web page(Ctrl + C) and paste to another
text box element (Ctrl + V). (refer to sending combination of keywords) */
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
    public void VerifyCopyPaste() throws InterruptedException{
        String testString="Hello World. This text is put here via automation tool.";
        String sourceTextBoxElementXpath="//input[@id='autosuggest']";
        String destTextBoxElementXpath="//div[@id='alert-example-div']//input[@class='inputs']"; 
        driver.get(webURL);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sourceTextBoxElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceTextBoxElementXpath)));
        WebElement destTextBoxElement=driver.findElement(By.xpath(destTextBoxElementXpath));
        Actions action=new Actions(driver);
        sourceTextBoxElement.sendKeys(testString);
        action.moveToElement(sourceTextBoxElement).click().keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();

        action.moveToElement(destTextBoxElement).click().keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();
        String obtainedString=destTextBoxElement.getAttribute("value");
        Thread.sleep(3000);
        assertEquals(testString,obtainedString);




    }

}
