package dev.cdevents.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.PipelineRunFinishedSubject;

import java.net.URI;

public class PipelineRunFinishedCDEvent extends CDEvent {

    @JsonProperty(required = true)
    private PipelineRunFinishedSubject subject;

    public PipelineRunFinishedCDEvent() {
        initCDEvent(currentCDEventType());
        setSubject(new PipelineRunFinishedSubject(CDEventConstants.SubjectType.PIPELINERUN));
    }

    public PipelineRunFinishedSubject getSubject() {
        return subject;
    }

    public void setSubject(PipelineRunFinishedSubject subject) {
        this.subject = subject;
    }

    @Override
    public String currentCDEventType() {
        return CDEventConstants.CDEventTypes.PipelineRunFinishedEvent.getEventType();
    }

    @Override
    public String schemaURL() {
        return String.format("https://cdevents.dev/%s/schema/pipeline-run-finished-event", CDEventConstants.CDEVENTS_SPEC_VERSION);
    }

    public void setSubjectId(String subjectId){
        getSubject().setId(subjectId);
    }

    public void setSubjectSource(URI subjectSource){
        getSubject().setSource(subjectSource);
    }

    public void setSubjectPipelineName(String pipelineName ){
        getSubject().getContent().setPipelineName(pipelineName );
    }

    public void setSubjectUrl(URI subjectUrl){
        getSubject().getContent().setUrl(subjectUrl);
    }

    public void setSubjectOutcome(CDEventConstants.Outcome subjectOutcome){
        getSubject().getContent().setOutcome(subjectOutcome);
    }

    public void setSubjectErrors(String subjectErrors){
        getSubject().getContent().setErrors(subjectErrors);
    }

    @Override
    public String toString() {
        return "PipelineRunFinishedCDEvent{" +
                "subject=" + subject +
                "} " + super.toString();
    }
}
