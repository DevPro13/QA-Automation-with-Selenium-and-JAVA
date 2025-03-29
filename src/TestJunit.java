import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestJunit {
   WebDriver driver;
   @BeforeClass
   public static void beforeClass(){
      System.out.println("This is before class!!");
   }
   @AfterClass
   public static void afterClass(){
      System.out.println("This is After class!!");
   }
   @Before
   public void driverSetup(){
      String chromeDriverLocation=System.getProperty("user.home")+"/Selenium/ChromeDriver/chromedriver";
      System.setProperty("webdriver.chrome.driver",chromeDriverLocation);
      driver = new ChromeDriver();
      driver.manage().window().maximize();
   }
   @After
   public void driverDrop(){
      driver.close();
   }

   @Test
   public void DropDownSelect() throws InterruptedException {
      String webURL="https://demo.automationtesting.in/Register.html";
      driver.get(webURL);
      Thread.sleep(2000);
   }

     
    public static void main(String[] args) {
      TestJunit test= new TestJunit();

    }
}