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
// import javafx.scene.control.Alert;
public class HandleAlert {
    String webURL="https://om.qc.cgt.us/";
    String username="test_processing@cedargate.com";
    String passwd="";//Please use shared password from email for application QC.
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
    public void VerifySuccessfulLogin() throws InterruptedException{
        driver.get(webURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // sign-in link and click
        WebElement signinLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("getLoginForm")));
        signinLink.click();
        // login form
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement signinElement = driver.findElement(By.xpath("//input[@type='submit']"));
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(passwd);
        signinElement.click();
        //verify successful login
        String expectedResult="Processing OM User";
        WebElement successLoggedInElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top']//nav//ul[2]/li/a/span[@class='username']")));
        String obtainedResult=successLoggedInElement.getText();
        assertEquals(expectedResult,obtainedResult);

        //Verify deletealert
        WebElement accountModuleElement=driver.findElement(By.xpath("//a[@href='/account/index']"));
        accountModuleElement.click();
        //Click on first notification Icon
        WebElement notificationElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Notification']")));
        notificationElement.click();
        WebElement deleteIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Delete']")));
        deleteIcon.click();
        String expectedString="Once removed, you will not be able to recover this item!";
        WebElement AlertBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal-text']")));
        String obtainedString=AlertBox.getText();
        assertEquals(expectedString,obtainedString);
        /*
        //This is not a actual alert box occured after pressing delete button.
        //If alert has occured occured after pressing delete buttion, it would had been handles this way.
        //Switch to alert first
        Alert alertBox=driver.switchTo().alert(); 
        //accepting the alert
        alertBox.accept();
        //pressing cancel or rejecting
        alertBox.dismiss();
        //passing data
        alertBox.SendKeys("Hello World!");
        //Getiing text
        alertBox.getText();
        */
    }
}
