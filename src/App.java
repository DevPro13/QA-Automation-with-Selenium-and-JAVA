import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String webURL="https://demo.guru99.com/test/login.html";
        String userNameXpath="//input[@id='email']";
        String passWdXpath="//input[@id='passwd']";
        String buttonXpath="//button[@type='submit']";
        String userName="username";
        String passWd="password";
        driver.get(webURL);
        WebElement userWebElement=driver.findElement(By.xpath(userNameXpath));
        WebElement passWebElement=driver.findElement(By.xpath(passWdXpath));
        WebElement buttonWebElement=driver.findElement(By.xpath(buttonXpath));
        userWebElement.sendKeys(userName);
        passWebElement.sendKeys(passWd);
        buttonWebElement.click();
        driver.close();
    }
}
