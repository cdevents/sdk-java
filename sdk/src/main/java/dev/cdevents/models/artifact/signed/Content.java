
package dev.cdevents.models.artifact.signed;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "signature"
})
@Generated("jsonschema2pojo")
public class Content {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    private String signature;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.signature == null)? 0 :this.signature.hashCode()));
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
        return ((this.signature == rhs.signature)||((this.signature!= null)&&this.signature.equals(rhs.signature)));
    }

}
