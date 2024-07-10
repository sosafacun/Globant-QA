package testng.tests;

import org.openqa.selenium.WebDriver;
import testng.services.SwagLabsOperations;

public class FillAndEmptyShoppingCart {
    private final WebDriver driver;
    public FillAndEmptyShoppingCart(WebDriver driver){
        this.driver = driver;
        swagOps = new SwagLabsOperations(this.driver);
    }
    public SwagLabsOperations swagOps;
    public void fillAndEmptyShoppingCart(){
        System.out.println("=============Fill and Empty Cart=============");
        swagOps.setUpDriver();
        swagOps.login();
        System.out.println("Filling the cart...");
        swagOps.addRandomItemsAndSeeCart(3);
        System.out.println("Emptying the cart...");
        swagOps.emptyCart();
        System.out.println("Emptied the cart properly...");
    }
}
