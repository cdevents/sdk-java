package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRunStartedSubject extends Subject {

    @JsonProperty(required = true)
    private PipelineRunStartedSubjectContent content;


    /**
     * @return the PipelineRunStarted subject's Content
     */
    public PipelineRunStartedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(PipelineRunStartedSubjectContent content) {
        this.content = content;
    }

    /**
     * Empty constructor.
     */
    public PipelineRunStartedSubject() {
    }

    /**
     * @param subjectType
     */
    public PipelineRunStartedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new PipelineRunStartedSubjectContent());

    }

    public class PipelineRunStartedSubjectContent {

        @JsonProperty
        private String pipelineName;

        @JsonProperty
        private URI url;


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
         * @param o
         * @return true or false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof PipelineRunStartedSubjectContent)) {
                return false;
            }

            PipelineRunStartedSubjectContent that = (PipelineRunStartedSubjectContent) o;

            if (getPipelineName() != null ? !getPipelineName().equals(that.getPipelineName()) : that.getPipelineName() != null) {
                return false;
            }
            return getUrl() != null ? getUrl().equals(that.getUrl()) : that.getUrl() == null;
        }

        /**
         * @return hash code value
         */
        @Override
        public int hashCode() {
            int result = getPipelineName() != null ? getPipelineName().hashCode() : 0;
            result = CDEventConstants.HASH_CODE * result + (getUrl() != null ? getUrl().hashCode() : 0);
            return result;
        }
    }
}
