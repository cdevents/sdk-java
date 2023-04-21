package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRunFinishedSubject extends Subject{

    @JsonProperty(required = true)
    private PipelineRunFinishedSubjectContent content;


    public PipelineRunFinishedSubjectContent getContent() {
        return content;
    }

    public void setContent(PipelineRunFinishedSubjectContent content) {
        this.content = content;
    }

    public PipelineRunFinishedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new PipelineRunFinishedSubjectContent());

    }

    public class PipelineRunFinishedSubjectContent {

        @JsonProperty
        private String pipelineName;

        @JsonProperty
        private URI url;

        @JsonProperty
        private CDEventConstants.Outcome outcome;

        @JsonProperty
        private String errors;

        public String getPipelineName() {
            return pipelineName;
        }

        public void setPipelineName(String pipelineName) {
            this.pipelineName = pipelineName;
        }

        public URI getUrl() {
            return url;
        }

        public void setUrl(URI url) {
            this.url = url;
        }

        public CDEventConstants.Outcome getOutcome() {
            return outcome;
        }

        public void setOutcome(CDEventConstants.Outcome outcome) {
            this.outcome = outcome;
        }

        public String getErrors() {
            return errors;
        }

        public void setErrors(String errors) {
            this.errors = errors;
        }

        @Override
        public String toString() {
            return "PipelineRunFinishedSubjectContent{" +
                    "pipelineName='" + pipelineName + '\'' +
                    ", url=" + url +
                    ", outcome=" + outcome +
                    ", errors='" + errors + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PipelineRunFinishedSubject{" +
                "content=" + content +
                "} " + super.toString();
    }
}
