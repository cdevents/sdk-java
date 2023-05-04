package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class ArtifactPublishedSubject extends Subject {

    @JsonProperty(required = true)
    private Object content = new Object();

    /**
     * @return the Artifact subject's Content
     */
    public Object getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(Object content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public ArtifactPublishedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
    }

}
