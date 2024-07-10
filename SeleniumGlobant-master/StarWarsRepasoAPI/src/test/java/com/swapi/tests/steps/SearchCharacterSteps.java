package com.swapi.tests.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import utils.MyWebDriver;
import utils.WikipediaServices;

public class SearchCharacterSteps {

    //Variables que se van a usar durante el test
    private String characterName;
    private String wikiPageTitle;
    //Depency Injection para los drivers y las acciones de la página.
    private WebDriver driver;
    private WikipediaServices wikiService;
    private Response response;
    //Constructor con la DI
    public SearchCharacterSteps(){
        MyWebDriver myWebDriver = new MyWebDriver();
        this.driver = myWebDriver.getDriver();
        wikiService = new WikipediaServices(driver);
        //setea al driver en wikipedia.org
        wikiService.setHomePage();
    }
    @Given("I am a user at the Wikipedia WebPage requesting SW character {int}")
    public void iAmAUserAtWikipedia(int characterNumber) {
        //Guarda el response para poder obtener el "name" y guardarlo en una variable privada de la clase
        response = wikiService.getCharacterData(characterNumber);
        characterName = response.jsonPath().getString("name");
    }

    @When("I search the requested character name on Wikipedia search page")
    public void searchCharacterOnWikipedia() {
        //Desde la página principal de wikipedia busca el nombre
        wikiService.searchTerm(characterName);
    }

    @Then("I should be able to see the article page correctly displayed for the requested character")
    public void verifyWikipediaArticle() {
        //Añade " - Wikipedia" porque así aparecen los títulos de la página
        wikiPageTitle = characterName + " - Wikipedia";
        //Verifica que sea correcto con un softAssert
        wikiService.verifyPageTitle(wikiPageTitle, driver.getTitle());
    }
    @After
    public void quit(){
        //Una vez terminado el test tira el softAssert.AssertAll(); para poder verificar los resultados
        wikiService.finishAssertions();
        driver.quit();
    }
}
