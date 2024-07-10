import com.beust.ah.A;
import groovyjarjarantlr4.v4.codegen.model.ArgAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class BankMockTest {
    public Response bankResponse = given().get("https://656912ebde53105b0dd6b040.mockapi.io/Kiwi/BankMock");
    public SoftAssert softAssert = new SoftAssert();

    @Given("The endpoint is empty")
    public void isEndpointEmpty(){
        String dataNotFound = bankResponse.getBody().asString();
        Assert.assertEquals(dataNotFound, "\"Not found\"");
    }
    @When("The Test requests data from the endpoint")
    public void requestDataFromEndpoint(){
    }
    @Then("The endpoint should return nothing")
    public void checkIfEndpointIsEmpty() {
    }

    @When("POST POJO data")
    public void postPOJOData(){

    }

    @Then("The endpoint should have 10 people")
    public void checkForTenPeople(){

    }
}
