import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StarWarsAPITest {
    public Response response = given().get("https://swapi.dev/api/people/2");
    public SoftAssert softAssert = new SoftAssert();
    @Test
    public void getResponseExample(){
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();
    }
    @Test
    public void checkGeneralData(){
        Map<Object, Object> characterData = response.jsonPath().getMap("");

        softAssert.assertEquals(characterData.get("skin_color"), "gold");
        List<String> films = (List<String>) characterData.get("films");
        softAssert.assertEquals(films.size(), 6);

        softAssert.assertAll();
    }
    @Test
    public void checkSecondMovieDataFromPeople2Data(){
        Map<String, List<String>> characterData = response.jsonPath().getMap("");

        Response movieResponse = given().get(characterData.get("films").get(1));
        softAssert.assertEquals(movieResponse.getStatusCode(), 200);

        Map<String, List<String>> movieData = movieResponse.jsonPath().getMap("");

        //Esto debería fallar porque no es correcto.
        softAssert.assertTrue(isDateFormatValid(String.valueOf(movieData.get("release_date"))));

        softAssert.assertTrue(movieData.get("characters").size() > 1);
        softAssert.assertTrue(movieData.get("planets").size() > 1);
        softAssert.assertTrue(movieData.get("starships").size() > 1);
        softAssert.assertTrue(movieData.get("vehicles").size() > 1);
        softAssert.assertTrue(movieData.get("species").size() > 1);

        softAssert.assertAll();
    }

    public boolean isDateFormatValid(String dateToValidate){
        String correctFormat = "dd-MM-yyyy";
        DateFormat validFormat = new SimpleDateFormat(correctFormat);

        LocalDate dateToValidateDate = LocalDate.parse(dateToValidate);

        validFormat.setLenient(false);
        try {
            validFormat.parse(String.valueOf(dateToValidateDate));
        } catch (ParseException e){
            return false;
        }
        return true;

    }

}
