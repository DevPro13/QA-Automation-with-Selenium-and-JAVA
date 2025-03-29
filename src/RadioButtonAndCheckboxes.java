import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonAndCheckboxes {
    /*
     Write a Selenium test script to select a radio button and verify that it is selected, and
also select checkboxes.
     */
     String webURL="https://www.letskodeit.com/practice";
    WebDriver driver;
    @Before
    public void DriverSetup(){
          //String chromeDriverLocation = System.getProperty("user.home") + "/Selenium/ChromeDriver/chromedriver";
          //ystem.setProperty("webdriver.chrome.driver", chromeDriverLocation);
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
    public void verifyRadioButtonAndCheckboxex() throws InterruptedException{
     driver.get(webURL);
     String radioButtionsXpath="//div[@id='radio-btn-example']//input[@type='radio']";
     String CheckBoxXpath="//div[@id='checkbox-example-div']//input[@type='checkbox']";
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     List<WebElement> radioWebElementsList=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(radioButtionsXpath)));
     List<WebElement> checkBoxItemElements=driver.findElements(By.xpath(CheckBoxXpath));
     for(WebElement radioitem:radioWebElementsList){
          if(radioitem.isSelected()){
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is selected");
          }
          else{
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is not selected");
          }
     }
     //select 1st option
     radioWebElementsList.get(0).click();
     String expectedItem1=radioWebElementsList.get(0).getAttribute("value").toUpperCase();
     Thread.sleep(2000);
     for(WebElement radioitem:radioWebElementsList){
          if(radioitem.isSelected()){
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is selected");
               assertEquals(expectedItem1,radioitem.getAttribute("value").toUpperCase());
          }
          else{
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is not selected");
          }
     }
     Thread.sleep(2000);
     //select 2nd option
     radioWebElementsList.get(1).click();
     String expectedItem2=radioWebElementsList.get(1).getAttribute("value").toUpperCase();
     Thread.sleep(2000);
     for(WebElement radioitem:radioWebElementsList){
          if(radioitem.isSelected()){
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is selected");
               assertEquals(expectedItem2,radioitem.getAttribute("value").toUpperCase());
          }
          else{
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is not selected");
          }
     }
     Thread.sleep(2000);
     //select 3rd option
     radioWebElementsList.get(2).click();
     String expectedItem3=radioWebElementsList.get(2).getAttribute("value").toUpperCase();
     Thread.sleep(2000);
     for(WebElement radioitem:radioWebElementsList){
          if(radioitem.isSelected()){
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is selected");
               assertEquals(expectedItem3,radioitem.getAttribute("value").toUpperCase());
          }
          else{
               System.out.println(radioitem.getDomAttribute("value").toUpperCase()+" is not selected");
          }
     }

     //check box
     //select all items
     for(WebElement checkBoxitem:checkBoxItemElements){
          if(checkBoxitem.isSelected()){
               System.out.println(checkBoxitem.getDomAttribute("value").toUpperCase()+" is selected");
          }
          else{
               System.out.println(checkBoxitem.getDomAttribute("value").toUpperCase()+" is not selected");
               checkBoxitem.click();
               Thread.sleep(2000);
          }
     }
     for(WebElement checkBoxitem:checkBoxItemElements){
          assertTrue(checkBoxitem.isSelected());
     }
     System.out.println("PASS");
    }
}
    
