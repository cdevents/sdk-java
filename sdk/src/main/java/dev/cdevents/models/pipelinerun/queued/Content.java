
package dev.cdevents.models.pipelinerun.queued;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pipelineName",
    "url"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("pipelineName")
    private String pipelineName;
    @JsonProperty("url")
    private String url;

    @JsonProperty("pipelineName")
    public String getPipelineName() {
        return pipelineName;
    }

    @JsonProperty("pipelineName")
    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.pipelineName == null)? 0 :this.pipelineName.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
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
        return (((this.pipelineName == rhs.pipelineName)||((this.pipelineName!= null)&&this.pipelineName.equals(rhs.pipelineName)))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
