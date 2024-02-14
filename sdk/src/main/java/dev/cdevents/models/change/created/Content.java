
package dev.cdevents.models.change.created;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "repository"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("repository")
    private Repository repository;

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.repository == null)? 0 :this.repository.hashCode()));
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
        return ((this.repository == rhs.repository)||((this.repository!= null)&&this.repository.equals(rhs.repository)));
    }

}
