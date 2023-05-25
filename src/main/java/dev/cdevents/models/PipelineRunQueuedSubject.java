package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class PipelineRunQueuedSubject extends Subject {

    @JsonProperty(required = true)
    private PipelineRunQueuedSubjectContent content;


    /**
     * @return the PipelineRunQueued subject's Content
     */
    public PipelineRunQueuedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(PipelineRunQueuedSubjectContent content) {
        this.content = content;
    }

    /**
     *Empty constructor.
     */
    public PipelineRunQueuedSubject() {
    }

    /**
     * @param subjectType
     */
    public PipelineRunQueuedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new PipelineRunQueuedSubjectContent());

    }

    public class PipelineRunQueuedSubjectContent {

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
            if (!(o instanceof PipelineRunQueuedSubjectContent)) {
                return false;
            }

            PipelineRunQueuedSubjectContent that = (PipelineRunQueuedSubjectContent) o;

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
            result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
            return result;
        }
    }
}
