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
     * Empty constructor.
     */
    public Subject() {
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

    /**
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }

        Subject subject = (Subject) o;

        if (!getId().equals(subject.getId())) {
            return false;
        }
        if (getSource() != null ? !getSource().equals(subject.getSource()) : subject.getSource() != null) {
            return false;
        }
        return getType() == subject.getType();
    }

    /**
     * @return hash code value
     */
    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
