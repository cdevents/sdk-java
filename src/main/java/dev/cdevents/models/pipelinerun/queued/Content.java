
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

}
