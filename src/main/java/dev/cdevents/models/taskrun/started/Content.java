
package dev.cdevents.models.taskrun.started;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taskName",
    "url",
    "pipelineRun"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("taskName")
    private String taskName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pipelineRun")
    private PipelineRun pipelineRun;

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

}
