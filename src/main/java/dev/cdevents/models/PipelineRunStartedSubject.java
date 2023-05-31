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
    }
}
