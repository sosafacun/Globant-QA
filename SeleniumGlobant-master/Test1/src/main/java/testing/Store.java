package testing;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Store {
    public static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {

        setUpDriver();
        signUp();
        watchVideo();
        purchaseLaptop();

        driver.quit();
    }
    @Test
    public static void setUpDriver(){
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    @Test
    public static void signUp() throws InterruptedException {

        System.out.println("Signing in...");

        WebElement signUp = driver.findElement(By.cssSelector("a[data-target='#signInModal']"));
        signUp.click();
        WebElement nameSignUp = driver.findElement(By.cssSelector("#sign-username"));
        nameSignUp.sendKeys("cuiwi");
        WebElement passSignUp = driver.findElement(By.cssSelector("#sign-password"));
        passSignUp.sendKeys("Aaaa123");
        WebElement signUpButton = driver.findElement(By.cssSelector("button[onclick='register()']"));
        signUpButton.click();

        waitForAlert();

        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals("This user already exist.")){
            alert.accept();
            Thread.sleep(500);
            WebElement closeButton = driver.findElement(By.cssSelector("div[id='signInModal'] button[aria-label='Close']"));
            closeButton.click();
            System.out.println("Not signed up");
        } else {
            alert.accept();
            Thread.sleep(500);
            System.out.println("Signed up");
        }

        Thread.sleep(1000);

    }
    @Test
    public static void watchVideo() throws InterruptedException {
        System.out.println("Watching video...");

        WebElement aboutUsTab = driver.findElement(By.cssSelector("a[data-target='#videoModal']"));
        aboutUsTab.click();
        Thread.sleep(1000);
        WebElement exampleVideo = driver.findElement(By.cssSelector("button[title='Play Video']"));
        exampleVideo.click();
        Thread.sleep(3500);

        WebElement closeButton = driver.findElement(By.cssSelector("div[id='videoModal'] button[aria-label='Close']"));
        closeButton.click();

        System.out.println("Video Watched");
    }
    @Test
    public static void purchaseLaptop() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Browsing and purchasing laptops.");

        WebElement laptopMenu = driver.findElement(By.xpath("//a[3]"));
        laptopMenu.click();
        Thread.sleep(2000);

        WebElement laptopOption = driver.findElement(By.xpath("(//a[normalize-space()='Sony vaio i5'])[1]"));
        laptopOption.click();
        Thread.sleep(1500);

        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
        addToCartButton.click();

        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);

        WebElement cartMenu = driver.findElement(By.cssSelector("#cartur"));
        cartMenu.click();
        Thread.sleep(1000);

        WebElement PlaceOrder = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
        PlaceOrder.click();
        Thread.sleep(2500);

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Kiwi");

        WebElement country = driver.findElement(By.cssSelector("#country"));
        country.sendKeys("Argentina");

        WebElement city = driver.findElement(By.cssSelector("#city"));
        city.sendKeys("CABA");

        WebElement card = driver.findElement(By.cssSelector("#card"));
        card.sendKeys("1594875386");

        WebElement month = driver.findElement(By.cssSelector("#month"));
        month.sendKeys("July");

        WebElement year = driver.findElement(By.cssSelector("#year"));
        year.sendKeys("1997");

        WebElement purchaseButton = driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']"));
        purchaseButton.click();

        Thread.sleep(1500);

        WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okButton.click();

        Thread.sleep(3500);

        System.out.println("Finished buying a laptop...");
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
