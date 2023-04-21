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

    public Subject(CDEventConstants.SubjectType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public CDEventConstants.SubjectType getType() {
        return type;
    }

    public void setType(CDEventConstants.SubjectType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", type=" + type +
                '}';
    }
}
