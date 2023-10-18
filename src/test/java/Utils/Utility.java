package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class Utility {
    private RequestSpecification request;
    configReader confReader;

    Properties properties;

    public Utility() {
        confReader = new configReader();
        properties = confReader.loadProperties();
        SetBaseURL();
    }

    public void SetBaseURL(){
        RestAssured.baseURI =  confReader.getValue("URL", properties);
        request = RestAssured.given().relaxedHTTPSValidation();
        request.param("apikey",confReader.getValue("apikey", properties));
    }
    public Response sendGetRequest(Map<String, String> params) {
        Response response = null;
        try {

            if(!(params == null || params.isEmpty())) {
                for (Map.Entry<String, String> entry : params.entrySet())
                    request = request.param(entry.getKey(), entry.getValue());
            }
            response = request
                    .when()
                    .get()
                    .then()
                    .extract()
                    .response();
        } catch (Exception e) {
            Assert.fail("Error occurred while sending GET request :" + e);
        }
        return response;
    }
}
