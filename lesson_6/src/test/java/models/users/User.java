package models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String id;

    public String email;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public  String lastName;

    public String avatar;



}
