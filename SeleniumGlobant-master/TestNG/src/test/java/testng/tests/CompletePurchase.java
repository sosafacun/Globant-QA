package testng.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testng.services.FluentWaitForElement;
import testng.services.SwagLabsOperations;


public class CompletePurchase {
    private final WebDriver driver;
    public CompletePurchase(WebDriver driver){
        this.driver = driver;
        swagOps = new SwagLabsOperations(this.driver);
    }
    private final SwagLabsOperations swagOps;
    private final FluentWaitForElement wait = new FluentWaitForElement();
    public void completePurchase(){
        System.out.println("=============Complete a Purchase=============");
        swagOps.setUpDriver();
        swagOps.login();
        System.out.println("Adding random items...");
        swagOps.addRandomItemsAndSeeCart(1);
        System.out.println("Cheking out...");
        swagOps.checkout();

        By pageContents = By.xpath("//div[@id='contents_wrapper']");
        wait.forElement(pageContents, driver);
    }
}
