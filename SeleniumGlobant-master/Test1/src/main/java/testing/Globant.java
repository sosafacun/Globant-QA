package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Globant {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String searchTerm = "Microsoft";

        driver.get("https://wikipedia.org");
        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement input = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.cssSelector("button"));


        input.sendKeys(searchTerm);
        searchButton.click();

        if(driver.getTitle().equals("Microsoft - Wikipedia")){
            System.out.println("Matches");

            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            for(WebElement link:allLinks){
                System.out.println(link.getText() + " - " + link.getAttribute("href"));
            }
        } else {
            System.out.println("Does not match");
        }

        driver.quit();

    }
}
