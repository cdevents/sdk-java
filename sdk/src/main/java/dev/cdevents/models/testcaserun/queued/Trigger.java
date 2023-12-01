
package dev.cdevents.models.testcaserun.queued;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "uri"
})
@Generated("jsonschema2pojo")
public class Trigger {

    @JsonProperty("type")
    private Trigger.Type type;
    @JsonProperty("uri")
    private URI uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public Trigger.Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Trigger.Type type) {
        this.type = type;
    }

    @JsonProperty("uri")
    public URI getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(URI uri) {
        this.uri = uri;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        MANUAL("manual"),
        PIPELINE("pipeline"),
        EVENT("event"),
        SCHEDULE("schedule"),
        OTHER("other");
        private final String value;
        private final static Map<String, Trigger.Type> CONSTANTS = new HashMap<String, Trigger.Type>();

        static {
            for (Trigger.Type c: values()) {
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
        public static Trigger.Type fromValue(String value) {
            Trigger.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
