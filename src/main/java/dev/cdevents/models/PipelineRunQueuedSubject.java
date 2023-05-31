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

    }
}
