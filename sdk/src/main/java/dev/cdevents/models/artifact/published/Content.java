
package dev.cdevents.models.artifact.published;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sbom",
    "user"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("sbom")
    private Sbom sbom;
    @JsonProperty("user")
    private String user;

    @JsonProperty("sbom")
    public Sbom getSbom() {
        return sbom;
    }

    @JsonProperty("sbom")
    public void setSbom(Sbom sbom) {
        this.sbom = sbom;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.sbom == null)? 0 :this.sbom.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
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
        return (((this.sbom == rhs.sbom)||((this.sbom!= null)&&this.sbom.equals(rhs.sbom)))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))));
    }

}
