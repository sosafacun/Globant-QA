package me.cucumber.test;

import POJOs.People;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultPage;
import utils.baseTest.BaseTest;

public class CSearchStepDefinitions {

    RequestSpecification httpRequest;
    People characterLooked;
    ResultPage resultPage;
    BaseTest baseTest;

    @Before
    public void setUpMethod() {       
        RestAssured.baseURI = "https://swapi.dev/api/";
        httpRequest = RestAssured.given();                       
    }        
   
    @After
    public void tearDown() {  
       
    }


    @Given("the user is on SW api requesting character id {int}")
    public void the_user_is_on_SW_api_requesting_character_id(Integer int1) {
        baseTest = new BaseTest();
        baseTest.beforeMethod("https://www.wikipedia.org/wiki/Wikipedia:Portada"); 
        Response response = httpRequest.get("people/" + int1);
        characterLooked = response.as(People.class);
    }

    @When("the user search on Wikipedia {string}")
    public void the_user_search_on_Wikipedia(String cName) {
        HomePage homePage = baseTest.loadFirstPage();
        resultPage = homePage.searchText(characterLooked.getName());
    }

    @Then("the user should be able to see the article page correctly displayed for {string}")
    public void the_user_should_be_able_to_see_the_article_page_correctly_displayed_for_the_requested_character(String cName) {
        Assert.assertTrue(resultPage.isTitleCorrect(cName));
        baseTest.afterMethod();
    }
}
