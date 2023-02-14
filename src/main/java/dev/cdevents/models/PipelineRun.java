package dev.cdevents.models;

import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRun {
    /**
     * id.
     */
    private String id;
    /**
     * source.
     */
    private URI source;
    /**
     * pipelineName.
     */
    private String pipelineName;
    /**
     * outcome.
     */
    private CDEventConstants.Outcome outcome;
    /**
     * url.
     */
    private URI url;
    /**
     * errors.
     */
    private String errors;

    /**
     * PipelineRun.
     */
    public PipelineRun() {
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return source
     */
    public URI getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(URI source) {
        this.source = source;
    }

    /**
     * @return pipelineName
     */
    public String getPipelineName() {
        return pipelineName;
    }

    /**
     * @param pipelineName
     */
    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    /**
     * @return outcome
     */
    public CDEventConstants.Outcome getOutcome() {
        return outcome;
    }

    /**
     * @param outcome
     */
    public void setOutcome(CDEventConstants.Outcome outcome) {
        this.outcome = outcome;
    }

    /**
     * @return url
     */
    public URI getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * @return errors
     */
    public String getErrors() {
        return errors;
    }

    /**
     * @param errors
     */
    public void setErrors(String errors) {
        this.errors = errors;
    }

}
