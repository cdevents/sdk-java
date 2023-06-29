
package dev.cdevents.models.pipelinerun.finished;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pipelineName",
    "url",
    "outcome",
    "errors"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("pipelineName")
    private String pipelineName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("outcome")
    private String outcome;
    @JsonProperty("errors")
    private String errors;

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

    @JsonProperty("outcome")
    public String getOutcome() {
        return outcome;
    }

    @JsonProperty("outcome")
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @JsonProperty("errors")
    public String getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(String errors) {
        this.errors = errors;
    }

}
