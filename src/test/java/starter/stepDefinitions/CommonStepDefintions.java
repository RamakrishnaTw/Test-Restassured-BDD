package starter.stepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class CommonStepDefintions {

    Base base;
    Scenario scenario;
    public CommonStepDefintions(Base base) {
        this.base = base;
        scenario = base.getScenario();
    }

    @Given("the OMDB feature has valid apikey for Authentication")
    public void apikey_auth(){
       // base.put("apikey","79a4a58e");
    }

    @Then("response should be {string} Status code")
    public void weGetTheStatusCode(String statusCode) {
        Response response = base.get("response");
        scenario.log(response.asPrettyString());
        Assert.assertEquals(Integer.toUnsignedLong(Integer.parseInt(statusCode)), response.statusCode());
    }
}
