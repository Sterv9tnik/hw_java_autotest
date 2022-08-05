package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import steps.CommonSteps;

public class CommonSiteSteps extends CommonSteps {

    protected RequestSpecification getListUserRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = getSiteSpecBuilder()
                .setBasePath("/api/users")
                .addQueryParam("page", 2);
        return requestSpecBuilder.build();
    }

    protected RequestSpecification getUserRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = getSiteSpecBuilder()
                .setBasePath("/api/users/2");
        return requestSpecBuilder.build();
    }

    protected RequestSpecification getErrorUserRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = getSiteSpecBuilder()
                .setBasePath("/api/users/23");
        return requestSpecBuilder.build();
    }

    protected RequestSpecification getListResourceRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = getSiteSpecBuilder()
                .setBasePath("api/unknown");
        return requestSpecBuilder.build();
    }
}
