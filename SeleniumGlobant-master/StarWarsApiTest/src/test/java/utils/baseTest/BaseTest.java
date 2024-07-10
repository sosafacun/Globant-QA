package utils.baseTest;


import org.testng.annotations.*;
import pages.HomePage;
import utils.MyDriver;

public class BaseTest {

    MyDriver driver;   
    
    public void beforeMethod(String url) {
        System.out.println("Naviganting to " + url);
        driver = new MyDriver();
        //driver.getWebDriver().manage().window().maximize();
        navigateTo(url);
    }

 
    public void navigateTo(String url) {
        driver.getWebDriver().get(url);
    }

 
    public HomePage loadFirstPage() {
        return new HomePage(driver.getWebDriver());
    }

    /**
     * Use of quit() method helps to avoid socket reset error
     */
    @AfterMethod
    public void afterMethod() {
       driver.getWebDriver().quit();
    }
}
