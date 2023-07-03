
package dev.cdevents.models.pipelinerun.started;

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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pipelineName")
    private String pipelineName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    private String url;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pipelineName")
    public String getPipelineName() {
        return pipelineName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pipelineName")
    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
