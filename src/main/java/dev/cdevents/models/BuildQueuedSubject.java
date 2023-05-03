package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class BuildQueuedSubject extends Subject {

    @JsonProperty(required = true)
    private Object content = new Object();

    /**
     * @return the BuildQueued subject's Content
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
    public BuildQueuedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
    }

}
