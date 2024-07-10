package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);        
    }

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;
    
    @FindBy(id = "ca-edit")
    private WebElement editLink;
    

    public boolean isTitleCorrect(String title){

        waitElementVisibility(pageTitle);
        return pageTitle.isDisplayed() &&
                pageTitle.getText().toLowerCase().equals(title.toLowerCase());
    }
    
    public ResultPage clickOnEditLink(){
        waitToBeClickable(editLink).click();
        return new ResultPage(super.getDriver());
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }
    
}
