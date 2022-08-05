package steps.users;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.users.Data;
import models.users.ListUserResponse;
import steps.CommonSiteSteps;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetUsersStep extends CommonSiteSteps {

    @Step("Get запрос на получение списка пользователей")
    public Response getUserList(){
        return given().spec(getListUserRequestSpec())
                .get();
    }

    @Step("Get запрос на получение одного пользователя")
    public Response getUser(){
        return given().spec(getUserRequestSpec())
                .get();
    }

    @Step("Get запрос на получение несуществующего пользователя")
    public Response getErrorUser(){
        return given().spec(getErrorUserRequestSpec())
                .get();
    }

    @Step("Проверка данных списка пользователей")
    public void checkValidateListUser(ListUserResponse listUserResponse){
        assertEquals(listUserResponse.getPage(), "2");
        assertEquals(listUserResponse.getPerPage(), "6");
        assertEquals(listUserResponse.getTotal(), "12");
        assertEquals(listUserResponse.getTotalPages(), "2");
        assertEquals(listUserResponse.getData().size(), 6);
    }

    @Step("Проверка данных пользователя")
    public void checkValidateUser(Data data){
        assertEquals(data.getUser().getId(), "2");
        assertEquals(data.getUser().getEmail(), "janet.weaver@reqres.in");
        assertEquals(data.getUser().getFirstName(), "Janet");
        assertEquals(data.getUser().getLastName(), "Weaver");
        assertEquals(data.getUser().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
    }

    @Step("Проверка ошибки пользователя")
    public void checkResponseNotFound(Response response){
        assertEquals(response.statusCode(), 404);
    }
}
