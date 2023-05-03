package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class BuildFinishedSubject extends Subject {

    @JsonProperty(required = true)
    private BuildFinishedSubjectContent content = new BuildFinishedSubjectContent();

    /**
     * @return the BuildStarted subject's Content
     */
    public BuildFinishedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(BuildFinishedSubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public BuildFinishedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
    }

    public class BuildFinishedSubjectContent {

        @JsonProperty(required = true)
        private String artifactId;

        /**
         * @return artifactId
         */
        public String getArtifactId() {
            return artifactId;
        }

        /**
         * @param artifactId
         */
        public void setArtifactId(String artifactId) {
            this.artifactId = artifactId;
        }
    }

}
