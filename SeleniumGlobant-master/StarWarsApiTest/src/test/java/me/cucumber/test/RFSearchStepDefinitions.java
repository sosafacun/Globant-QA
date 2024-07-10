/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.cucumber.test;

import POJOs.Film;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultPage;
import utils.baseTest.BaseTest;

/**
 *
 * @author idmig
 */
public class RFSearchStepDefinitions {

    RequestSpecification httpRequest;
    Film filmLooked;
    ResultPage resultPage;
    BaseTest baseTest;
    String filmTitle;

    @Before
    public void setUpMethod() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        httpRequest = RestAssured.given();        
    }

    @After
    public void tearDown() {        
    }

    @Given("the user is on SW api requesting a random movie")
    public void the_user_is_on_sw_api_requesting_a_random_movie() {
        baseTest = new BaseTest();
        baseTest.beforeMethod("https://www.wikipedia.org/wiki/Wikipedia:Portada");
        Response responseFilms = httpRequest.get("/films");
        List<Film> films = responseFilms.jsonPath().getList("results", Film.class);
        filmLooked = films.get((int) (Math.random() * films.size()));
    }

    @Given("the user search on Wikipedia that movie")
    public void the_user_search_on_wikipedia_that_movie() {
        HomePage homePage = baseTest.loadFirstPage();
        resultPage = homePage.searchText(filmLooked.getTitle());
        filmTitle = resultPage.getPageTitle().getText();
        System.out.println(filmTitle);
    }

    @When("the user click on edit link")
    public void the_user_click_on_edit_link() {   
        resultPage = resultPage.clickOnEditLink();
    }

    @Then("the user should be able to see the article title correctly displayed for that")
    public void the_user_should_be_able_to_see_the_article_title_correctly_displayed_for_that() {
        Assert.assertEquals(resultPage.getPageTitle().getText(), filmTitle);  
        baseTest.afterMethod();
    }

}
