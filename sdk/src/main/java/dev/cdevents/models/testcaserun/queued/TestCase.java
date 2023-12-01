
package dev.cdevents.models.testcaserun.queued;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "version",
    "name",
    "type",
    "uri"
})
@Generated("jsonschema2pojo")
public class TestCase {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private String id;
    @JsonProperty("version")
    private String version;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private TestCase.Type type;
    @JsonProperty("uri")
    private URI uri;

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

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public TestCase.Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(TestCase.Type type) {
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

    @Generated("jsonschema2pojo")
    public enum Type {

        PERFORMANCE("performance"),
        FUNCTIONAL("functional"),
        UNIT("unit"),
        SECURITY("security"),
        COMPLIANCE("compliance"),
        INTEGRATION("integration"),
        E_2_E("e2e"),
        OTHER("other");
        private final String value;
        private final static Map<String, TestCase.Type> CONSTANTS = new HashMap<String, TestCase.Type>();

        static {
            for (TestCase.Type c: values()) {
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
        public static TestCase.Type fromValue(String value) {
            TestCase.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
