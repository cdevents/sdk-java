
package dev.cdevents.models.artifact.packaged;

import javax.annotation.processing.Generated;
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

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.change == null)? 0 :this.change.hashCode()));
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
        return ((this.change == rhs.change)||((this.change!= null)&&this.change.equals(rhs.change)));
    }

}
