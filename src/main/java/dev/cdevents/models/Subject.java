package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class Subject {

    @JsonProperty(required = true)
    private String id;

    @JsonProperty
    private URI source;

    @JsonProperty(required = true)
    private CDEventConstants.SubjectType type;

    /**
     * Constructor to set the Subject Type.
     * @param type
     */
    public Subject(CDEventConstants.SubjectType type) {
        this.type = type;
    }

    /**
     * @return Subject id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return source
     */
    public URI getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(URI source) {
        this.source = source;
    }

    /**
     * @return subject type
     */
    public CDEventConstants.SubjectType getType() {
        return type;
    }


    /**
     * @param type
     */
    public void setType(CDEventConstants.SubjectType type) {
        this.type = type;
    }
}
