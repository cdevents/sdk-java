
package dev.cdevents.models.testcaserun.finished;

import java.net.URI;
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

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TestCase) == false) {
            return false;
        }
        TestCase rhs = ((TestCase) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))));
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
