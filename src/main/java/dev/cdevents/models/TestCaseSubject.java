package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class TestCaseSubject extends Subject {

    @JsonProperty(required = true)
    private Object content = new Object();

    /**
     * @return the TestCase subject's Content
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
    public TestCaseSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
    }

}
