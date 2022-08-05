package models.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Resource {

    public String id;

    public String name;

    public Integer year;

    public String color;

    @JsonProperty("pantone_value")
    public String pantoneValue;
}
