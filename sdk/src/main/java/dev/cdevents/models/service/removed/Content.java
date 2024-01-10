
package dev.cdevents.models.service.removed;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "environment"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("environment")
    private Environment environment;

    @JsonProperty("environment")
    public Environment getEnvironment() {
        return environment;
    }

    @JsonProperty("environment")
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
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
        return ((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment)));
    }

}
