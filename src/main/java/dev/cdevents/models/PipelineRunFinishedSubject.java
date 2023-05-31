package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRunFinishedSubject extends Subject {

    @JsonProperty(required = true)
    private PipelineRunFinishedSubjectContent content;


    /**
     * @return the PipelineRunFinished subject's Content
     */
    public PipelineRunFinishedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(PipelineRunFinishedSubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
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
         * @return URL
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
}
