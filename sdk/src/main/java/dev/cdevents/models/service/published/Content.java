
package dev.cdevents.models.service.published;

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

}
