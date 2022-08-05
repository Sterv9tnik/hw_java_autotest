package models.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResourcesResponce {

    public String page;

    @JsonProperty("per_page")
    public String perPage;

    public String total;

    @JsonProperty("total_pages")
    public String totalPages;

    public List<Resource> data;

    public static ListResourcesResponce createActualListResources(Response response){
        return response.getBody().as(ListResourcesResponce.class);
    }

}
