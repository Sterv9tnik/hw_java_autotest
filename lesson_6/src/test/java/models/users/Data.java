package models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty("data")
    private User user;

    public static Data createActualUser(Response response){
        return response.getBody().as(Data.class);
    }
}
