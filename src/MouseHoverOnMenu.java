import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MouseHoverOnMenu {
    /*
     Write a Selenium test script to perform mouse hover action on a menu item and verify
that sub-menus are displayed.
     */
    String webURL="https://www.letskodeit.com/practice";
    WebDriver driver;
     @Before
    public void driverSetup(){
        //String chromeDriverLocation = System.getProperty("user.home") + "/Selenium/ChromeDriver/chromedriver";
        //System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        //driver = new ChromeDriver();
        driver=new FirefoxDriver();
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
     String hoverMenuElementXpath="//button[@id='mousehover']";
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement hoverMenuElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hoverMenuElementXpath)));

    //move to that element
    jsExecutor.executeScript("arguments[0].scrollIntoView(true);",hoverMenuElement);
     List<WebElement> sub_menuElements=driver.findElements(By.xpath("//div[@class='mouse-hover-content']/a"));
     Thread.sleep(1000);
    Actions action=new Actions(driver);
    WebDriverWait wait_for_submenus_displayed=new WebDriverWait(driver,Duration.ofSeconds(10));
     // Perform the hover action on elements
    action.moveToElement(hoverMenuElement).perform();
    Thread.sleep(10000);
    wait_for_submenus_displayed.until(ExpectedConditions.visibilityOf(sub_menuElements.get(0)));
    System.out.println(sub_menuElements.get(0).getText());
    System.out.println(sub_menuElements.get(1).getText());
    assertTrue(sub_menuElements.get(0).isDisplayed());
    assertEquals("Top", sub_menuElements.get(0).getText());
    assertEquals("Reload", sub_menuElements.get(1).getText());
    }
    public static void main(String[] args) {
        MouseHoverOnMenu obj1=new MouseHoverOnMenu();
        try{
        obj1.driverSetup();
        obj1.verifyMouseHover();
        obj1.removeDriver();
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    }
}
