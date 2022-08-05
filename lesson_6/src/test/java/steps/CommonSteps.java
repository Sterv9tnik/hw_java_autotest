package steps;

import io.restassured.builder.RequestSpecBuilder;

public class CommonSteps {

    protected RequestSpecBuilder getSiteSpecBuilder(){
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json; charset=UTF-8");
    }

}
