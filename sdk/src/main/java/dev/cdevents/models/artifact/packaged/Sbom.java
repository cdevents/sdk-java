
package dev.cdevents.models.artifact.packaged;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uri"
})
@Generated("jsonschema2pojo")
public class Sbom {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    private String uri;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sbom) == false) {
            return false;
        }
        Sbom rhs = ((Sbom) other);
        return ((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri)));
    }

}
