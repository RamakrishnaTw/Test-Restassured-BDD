package actions;

import Utils.Utility;
import io.restassured.response.Response;

import java.util.Map;

public class Title {

    Response response;

public Response GetTitleRequest(Map<String, String> params){
   Utility util = new Utility();
    response = util.sendGetRequest(params);
    return response;
}

}
