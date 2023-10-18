package starter.stepDefinitions.title;

import actions.Title;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import starter.stepDefinitions.Base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleStepDefinitions  {


    Base base;

    private Title title;

    public Map<String, String> params;

    public TitleStepDefinitions(Base base){
        this.base = base;
        params = new HashMap<>();
        title = new Title();
    }


    @When("searched with Movie title {string}")
    public void searched_with_Movie_title(String name){
        params.put("t",name);

    }

    @And("made request to OMDB service")
    public void madeRequestToOMDBService() {
        Response response = title.GetTitleRequest(params);
        base.put("response",response);
    }

    @And("Title in the response should be {string}")
    public void verify_title(String title){
        Response response = base.get("response");
        Assert.assertEquals(title.toLowerCase(),response.jsonPath().get("Title").toString().toLowerCase());
    }

    @And("also with Year {string}")
    public void with_year(String year){
        params.put("y",year);
    }

    @And("year in the response should be {string}")
    public void yearInTheResponseShouldBe(String year) {
        Response response = base.get("response");
        Assert.assertEquals(year,response.jsonPath().get("Year").toString());
    }

    @And("with Return type {string}")
    public void withReturnType(String type) {
        params.put("r",type);
    }

    @And("response should be in {string} format")
    public void responseShouldInFormat(String type) {
        Response response = base.get("response");
        String contentTypeHeader = response.header("Content-Type");
        if(type.equals("json")){
            Assert.assertTrue(contentTypeHeader.contains("application/json"));
        }else{
            Assert.assertTrue(contentTypeHeader.contains("text/xml"));
        }

    }

    @When("searched with Movie ID {string}")
    public void searchedWithMovieID(String id) {
        params.put("i",id);
    }

    @When("using {string} as search parameter.")
    public void usingAsSearchParameter(String search) {
        params.put("s",search);
    }

    @And("All Titles in the response should be contains {string}")
    public void allTitlesInTheResponseShouldBeContains(String name) {
        Response response = base.get("response");
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> searchResults =  jsonPath.getList("Search");

        // Loop through each result and check if the "Title" contains "Avatar"
        for (Map<String, Object> result : searchResults) {
            String title = (String) result.get("Title");
            Assert.assertTrue(title.contains("Avatar"));
        }
    }
}
