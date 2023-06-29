
package dev.cdevents.models.artifact.packaged;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "change"
})
@Generated("jsonschema2pojo")
public class Content {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("change")
    private Change change;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("change")
    public Change getChange() {
        return change;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("change")
    public void setChange(Change change) {
        this.change = change;
    }

}
