
package dev.cdevents.models.taskrun.finished;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taskName",
    "url",
    "pipelineRun",
    "outcome",
    "errors"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("taskName")
    private String taskName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pipelineRun")
    private PipelineRun pipelineRun;
    @JsonProperty("outcome")
    private String outcome;
    @JsonProperty("errors")
    private String errors;

    @JsonProperty("taskName")
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty("taskName")
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("pipelineRun")
    public PipelineRun getPipelineRun() {
        return pipelineRun;
    }

    @JsonProperty("pipelineRun")
    public void setPipelineRun(PipelineRun pipelineRun) {
        this.pipelineRun = pipelineRun;
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
