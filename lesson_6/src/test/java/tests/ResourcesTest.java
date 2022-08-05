package tests;

import io.restassured.response.Response;
import models.resources.ListResourcesResponce;
import org.junit.Test;
import steps.resources.GetResourseStep;

public class ResourcesTest {

    GetResourseStep getResourseStep = new GetResourseStep();

    @Test
    public void getListUsersTest(){

        Response response = getResourseStep.getListResource();

        ListResourcesResponce listUserResponse = ListResourcesResponce.createActualListResources(response);

        System.out.println(listUserResponse.toString());
    }
}
