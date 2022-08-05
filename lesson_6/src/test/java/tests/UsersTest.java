package tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.users.Data;
import models.users.ListUserResponse;
import org.junit.Test;
import steps.users.GetUsersStep;

public class UsersTest {

    GetUsersStep getUsersStep = new GetUsersStep();

    @Test
    @Step("Получить список пользователей")
    public void getListUsersTest(){

        Response response = getUsersStep.getUserList();

        ListUserResponse listUserResponse = ListUserResponse.createActualListUser(response);

        getUsersStep.checkValidateListUser(listUserResponse);
    }

    @Test
    @Step("Получить одного пользователей")
    public void getSingleUsersTest(){

        Response response = getUsersStep.getUser();

        Data data = Data.createActualUser(response);

        getUsersStep.checkValidateUser(data);
    }

    @Test
    @Step("Получить несуществующего пользователя пользователей")
    public void getErrorUserTest(){

        Response response = getUsersStep.getErrorUser();

        getUsersStep.checkResponseNotFound(response);
    }
}
