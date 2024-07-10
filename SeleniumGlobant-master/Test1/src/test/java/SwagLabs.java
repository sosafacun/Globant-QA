import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SwagLabs {
    public WebDriver driver = new FirefoxDriver();
    @Before
    public  void setUpDriver(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.saucedemo.com/v1/");
    }
    @Test
    public void logIn(){

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
    @Test
    public void completePurchase(){
        logIn();
        addToCart();
        By contents = By.xpath("//div[@id='contents_wrapper']");
        fluentWaitForElement(contents);

        WebElement checkOutButton = driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']"));
        checkOutButton.click();

        fluentWaitForElement(contents);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement postalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));

        firstName.sendKeys("Kiwi");
        lastName.sendKeys("Melon");
        postalCode.sendKeys("15948");

        WebElement continueButton = driver.findElement(By.xpath("(//input[@value='CONTINUE'])[1]"));
        continueButton.click();

        fluentWaitForElement(contents);

        WebElement finishPurchaseButton = driver.findElement(By.xpath("//a[normalize-space()='FINISH']"));
        finishPurchaseButton.click();

        By orderCompleteMessage = By.xpath("//div[@id='checkout_complete_container']");
        fluentWaitForElement(orderCompleteMessage);
    }
    public void addToCart(){
        WebElement addBackpackbtn = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        WebElement addTestShirt = driver.findElement(By.xpath("//div[6]//div[3]//button[1]"));
        WebElement addLabsOnesie = driver.findElement(By.xpath("//div[5]//div[3]//button[1]"));
        addLabsOnesie.click();
        addBackpackbtn.click();
        addTestShirt.click();
        addBackpackbtn.click();

        WebElement cartButton = driver.findElement(By.xpath("(//a[@class='shopping_cart_link fa-layers fa-fw'])[1]"));
        cartButton.click();
    }
    public void fluentWaitForElement(By expectedElement){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
    }
    @After
    public void quit(){
        driver.quit();
    }
}
