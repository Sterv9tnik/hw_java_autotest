package steps.resources;

import io.restassured.response.Response;
import steps.CommonSiteSteps;

import static io.restassured.RestAssured.given;

public class GetResourseStep extends CommonSiteSteps {

    public Response getListResource(){
        return given().spec(getListResourceRequestSpec())
                .get();
    }

}
