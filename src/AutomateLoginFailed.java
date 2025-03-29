import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

import java.time.Duration;

public class AutomateLoginFailed {
    String webURL="https://practicetestautomation.com/practice-test-login/";
    String username = "user@123";
    String passwd = "user123";
    String ExpectedResult1 = "Your password is invalid!"; 
    String ExpectedResult2="Your username is invalid!";
    WebDriver driver;

    @Before
    public void driverSetup(){
        // String chromeDriverLocation = System.getProperty("user.home") + "/Selenium/ChromeDriver/chromedriver";
        // System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void driverDrop(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyLoginFailed() throws InterruptedException {
    
        driver.get(webURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // sign-in link and click
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signinElement = driver.findElement(By.xpath("//button[@id='submit']"));
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(passwd);
        signinElement.click();

        // After login
        WebElement errElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']")));
        String obtainedResult = errElement.getText();

        // Display result
        if(obtainedResult==ExpectedResult1){
            assertEquals(obtainedResult,ExpectedResult1);
        }
        else{
            assertEquals(obtainedResult,ExpectedResult2);
        }
    }

    public static void main(String[] args) {
        AutomateLoginFailed loginAutomationInstance = new AutomateLoginFailed();
        try {
            loginAutomationInstance.driverSetup();
            loginAutomationInstance.verifyLoginFailed();
            loginAutomationInstance.driverDrop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
