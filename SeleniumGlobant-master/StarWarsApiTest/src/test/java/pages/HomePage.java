package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.basePage.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);       
    }

    @FindBy(css = "[name='search']")
    private WebElement searchInput;

    @FindBy(css = "#searchform button")
    private WebElement searchButton;

    /**
     * Uses ExpectedConditions.refreshed before every interaction with a WebElement to avoid stale element exception
     * @param text to search
     * @return a page with the search result
     */
    
    public ResultPage searchText(String text) {        
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchInput)));
        searchInput.sendKeys(text);
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchInput)));
        searchInput.submit();        
        return new ResultPage(super.getDriver());
    }
}
