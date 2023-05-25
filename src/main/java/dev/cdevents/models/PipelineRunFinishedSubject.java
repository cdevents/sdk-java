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
     *Empty constructor.
     */
    public PipelineRunFinishedSubject() {
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

        /**
         * @param o
         * @return true or false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof PipelineRunFinishedSubjectContent)) {
                return false;
            }

            PipelineRunFinishedSubjectContent that = (PipelineRunFinishedSubjectContent) o;

            if (getPipelineName() != null ? !getPipelineName().equals(that.getPipelineName()) : that.getPipelineName() != null) {
                return false;
            }
            if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) {
                return false;
            }
            if (getOutcome() != that.getOutcome()) {
                return false;
            }
            return getErrors() != null ? getErrors().equals(that.getErrors()) : that.getErrors() == null;
        }

        /**
         * @return hash code value
         */
        @Override
        public int hashCode() {
            int result = getPipelineName() != null ? getPipelineName().hashCode() : 0;
            result = CDEventConstants.HASH_CODE * result + (getUrl() != null ? getUrl().hashCode() : 0);
            result = CDEventConstants.HASH_CODE * result + (getOutcome() != null ? getOutcome().hashCode() : 0);
            result = CDEventConstants.HASH_CODE * result + (getErrors() != null ? getErrors().hashCode() : 0);
            return result;
        }
    }
}
