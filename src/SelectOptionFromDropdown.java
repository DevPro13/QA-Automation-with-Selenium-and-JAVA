import static org.junit.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectOptionFromDropdown {
    /*
     Write a Selenium test script to select an option from a dropdown menu.
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
    public void VerfyoptionSelectableFromDropDown()throws InterruptedException{
        //goto website
        driver.get(webURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //get dropdown element
        WebElement dropDownElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='carselect']")));
        Select carSelect=new Select(dropDownElement);
        List<WebElement> carSelectOptions= carSelect.getOptions();
        //select by index
        for(Integer i=0;i<carSelectOptions.size();++i){
            carSelect.selectByIndex(i);
            assertEquals(carSelectOptions.get(i).getText(), carSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);
        }
        //select by visible text
        for(WebElement option: carSelectOptions){
            String optionValue=option.getText();
            //select by value
            carSelect.selectByVisibleText(optionValue);
            assertEquals(optionValue, carSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);

        }
        //select by value
        for(WebElement option: carSelectOptions){
            String optionValue=option.getText().toLowerCase();
            //select by value
            carSelect.selectByValue(optionValue);
            assertEquals(option.getText(), carSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);
        }
    }
    public static void main(String[] args) {
        SelectOptionFromDropdown test1=new SelectOptionFromDropdown();
        try{
            test1.DriverSetup();
            test1.VerfyoptionSelectableFromDropDown();
            test1.DriverDrop();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}
