package testing;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SwagLabsTesting {
    public static WebDriver driver = new FirefoxDriver();
    public static void main(String[] args) {
        setUpDriver();
        logIn();
        driver.quit();
    }
    public static void logIn(){

        By loginBox = By.xpath("//div[@class='login-box']");
        fluentWaitForElement(loginBox);
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.sendKeys("standard_user");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("secret_sauce");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        logInButton.click();
        By contents = By.xpath("//div[@id='contents_wrapper']");
        fluentWaitForElement(contents);
    }
    public static void setUpDriver(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.saucedemo.com/v1/");
    }
    public static void fluentWaitForElement(By expectedElement){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
    }
    public static void waitForAlert() throws InterruptedException {
        int i=0;
        while(i++<5)
        {
            try
            {
                Alert alert = driver.switchTo().alert();
                break;
            }
            catch(NoAlertPresentException e)
            {
                Thread.sleep(1000);
                continue;
            }
        }
    }
}
