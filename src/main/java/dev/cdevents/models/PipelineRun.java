package dev.cdevents.models;

import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRun {
    private String id;
    private URI source;
    private String pipelineName;
    private CDEventConstants.Outcome outcome;
    private URI url;
    private String errors;

    public PipelineRun() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public CDEventConstants.Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(CDEventConstants.Outcome outcome) {
        this.outcome = outcome;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
