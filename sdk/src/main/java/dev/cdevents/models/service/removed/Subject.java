
package dev.cdevents.models.service.removed;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "source",
    "type",
    "content"
})
@Generated("jsonschema2pojo")
public class Subject {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private String id;
    @JsonProperty("source")
    private String source;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private Subject.Type type = Subject.Type.fromValue("service");
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    private Content content;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public Subject.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(Subject.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.content == null)? 0 :this.content.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subject) == false) {
            return false;
        }
        Subject rhs = ((Subject) other);
        return (((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.content == rhs.content)||((this.content!= null)&&this.content.equals(rhs.content))));
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        SERVICE("service");
        private final String value;
        private final static Map<String, Subject.Type> CONSTANTS = new HashMap<String, Subject.Type>();

        static {
            for (Subject.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Subject.Type fromValue(String value) {
            Subject.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
