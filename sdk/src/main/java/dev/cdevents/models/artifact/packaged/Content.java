
package dev.cdevents.models.artifact.packaged;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "change",
    "sbom"
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
    @JsonProperty("sbom")
    private Sbom sbom;

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

    @JsonProperty("sbom")
    public Sbom getSbom() {
        return sbom;
    }

    @JsonProperty("sbom")
    public void setSbom(Sbom sbom) {
        this.sbom = sbom;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.sbom == null)? 0 :this.sbom.hashCode()));
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
        return (((this.sbom == rhs.sbom)||((this.sbom!= null)&&this.sbom.equals(rhs.sbom)))&&((this.change == rhs.change)||((this.change!= null)&&this.change.equals(rhs.change))));
    }

}
