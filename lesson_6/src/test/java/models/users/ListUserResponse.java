package models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUserResponse {

    public String page;

    @JsonProperty("per_page")
    public String perPage;

    public String total;

    @JsonProperty("total_pages")
    public String totalPages;

    public List<User> data;

    public static ListUserResponse createActualListUser(Response response){
        return response.getBody().as(ListUserResponse.class);
    }
}
