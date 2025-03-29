import static org.junit.Assert.assertEquals;
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

public class AutomationLoginSuccess {
    String webURL="https://demo.guru99.com/test/login.html";
    WebDriver driver;
    @Before
    public void driverSetup(){
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
    public void verifyLogin() throws InterruptedException{
        driver.get(webURL);
        String ExpectedResult="Successfully Logged in...";
        String userNameXpath="//input[@id='email']";
        String passWdXpath="//input[@id='passwd']";
        String buttonXpath="//button[@type='submit']";
        String resultDivElementXpath="//div[@class='error-copy']";
        String userName="username";
        String passWd="password";
        driver.get(webURL);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userWebElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userNameXpath)));
        driver.findElement(By.xpath(userNameXpath));
        WebElement passWebElement=driver.findElement(By.xpath(passWdXpath));
        WebElement buttonWebElement=driver.findElement(By.xpath(buttonXpath));
        userWebElement.sendKeys(userName);
        passWebElement.sendKeys(passWd);
        buttonWebElement.click();
        WebElement outputDivElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(resultDivElementXpath)));
        String obtainedResult=outputDivElement.getText();
        //System.out.println(obtainedResult);
        assertEquals(obtainedResult,ExpectedResult);
    }
}
