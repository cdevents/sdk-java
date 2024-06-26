
package dev.cdevents.custom.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "user",
    "description",
    "nested"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("user")
    private String user;
    @JsonProperty("description")
    private String description;
    @JsonProperty("nested")
    private Nested nested;

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("nested")
    public Nested getNested() {
        return nested;
    }

    @JsonProperty("nested")
    public void setNested(Nested nested) {
        this.nested = nested;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.nested == null)? 0 :this.nested.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Content) == false) {
            return false;
        }
        Content rhs = ((Content) other);
        return ((((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.nested == rhs.nested)||((this.nested!= null)&&this.nested.equals(rhs.nested))));
    }

}
