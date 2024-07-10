package testng.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


//Estas pruebas están hechas para que pasen sí o sí. Es mas un test sobre confiabilidad y robustez del código mas sobre detección de errores.
//El locked_user no va a hacer que la prueba falle porque el algoritmo va a intentar loggearse con otro usuario.
//El error_user no va a conseguir finalizar una compra, pero no va a tirar un fallo.
//glitch_performance_user no va a tirar un timeout, el test va a quedar esperando a que pueda entrar.
//El problem_user tira por consola que no puede finalizar una compra por falla de info personal.

public class test {
    //public WebDriver driver = new FirefoxDriver();
    public WebDriver driver = new ChromeDriver();
    @Test
    public void completePurchaseTest(){
        CompletePurchase test = new CompletePurchase(driver);
        test.completePurchase();
    }
    @Test
    public void fillAndEmptyCart(){
        FillAndEmptyShoppingCart test = new FillAndEmptyShoppingCart(driver);
        test.fillAndEmptyShoppingCart();
    }
    @Test
    public void inAndOut(){
        LogInAndLogOut test = new LogInAndLogOut(driver);
        test.inAndOut();
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}
