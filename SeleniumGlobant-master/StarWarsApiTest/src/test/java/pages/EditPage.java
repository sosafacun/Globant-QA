/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author idmig
 */
public class EditPage extends ResultPage {

    public EditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstHeadingTitle")
    private WebElement pageTitle;

    @Override
    public WebElement getPageTitle() {
        return pageTitle;
    }
    
    
    @Override
    public boolean isTitleCorrect(String text){

        return true;
    }
    
}
