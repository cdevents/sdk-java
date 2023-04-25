package dev.cdevents.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.PipelineRunFinishedSubject;

import java.net.URI;

public class PipelineRunFinishedCDEvent extends CDEvent {

    private static final String CDEVENT_VERSION = "0.1.0";
    @JsonProperty(required = true)
    private PipelineRunFinishedSubject subject;

    /**
     * Constructor to init CDEvent and set the Subject for {@link PipelineRunFinishedCDEvent}.
     */
    public PipelineRunFinishedCDEvent() {
        initCDEvent(currentCDEventType());
        setSubject(new PipelineRunFinishedSubject(CDEventConstants.SubjectType.PIPELINERUN));
    }

    /**
     * @return subject
     */
    public PipelineRunFinishedSubject getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(PipelineRunFinishedSubject subject) {
        this.subject = subject;
    }

    /**
     * @return the current CDEvent type
     */
    @Override
    public String currentCDEventType() {
        return CDEventConstants.CDEventTypes.PipelineRunFinishedEvent.getEventType().concat(CDEVENT_VERSION);
    }

    /**
     * @return the pipeline-run-finished-event schema URL
     */
    @Override
    public String schemaURL() {
        return String.format("https://cdevents.dev/%s/schema/pipeline-run-finished-event", CDEventConstants.CDEVENTS_SPEC_VERSION);
    }

    /**
     * @param subjectId
     * sets the subject Id
     */
    public void setSubjectId(String subjectId) {
        getSubject().setId(subjectId);
    }

    /**
     * @param subjectSource
     * sets the pipeline source
     */
    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource);
    }

    /**
     * @param pipelineName
     * sets the pipeline name
     */
    public void setSubjectPipelineName(String pipelineName) {
        getSubject().getContent().setPipelineName(pipelineName);
    }

    /**
     * @param subjectUrl
     * sets the pipeline URL
     */
    public void setSubjectUrl(URI subjectUrl) {
        getSubject().getContent().setUrl(subjectUrl);
    }

    /**
     * @param subjectOutcome
     * sets the {@link PipelineRunFinishedCDEvent} outcome
     */
    public void setSubjectOutcome(CDEventConstants.Outcome subjectOutcome) {
        getSubject().getContent().setOutcome(subjectOutcome);
    }

    /**
     * @param subjectErrors
     * sets the {@link PipelineRunFinishedCDEvent} errors
     */
    public void setSubjectErrors(String subjectErrors) {
        getSubject().getContent().setErrors(subjectErrors);
    }
}
