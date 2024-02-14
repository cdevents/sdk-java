
package dev.cdevents.models.testoutput.published;

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
    "outputType",
    "format",
    "uri",
    "testCaseRun"
})
@Generated("jsonschema2pojo")
public class Content {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outputType")
    private Content.OutputType outputType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    private String format;
    @JsonProperty("uri")
    private URI uri;
    @JsonProperty("testCaseRun")
    private TestCaseRun testCaseRun;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outputType")
    public Content.OutputType getOutputType() {
        return outputType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outputType")
    public void setOutputType(Content.OutputType outputType) {
        this.outputType = outputType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("uri")
    public URI getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(URI uri) {
        this.uri = uri;
    }

    @JsonProperty("testCaseRun")
    public TestCaseRun getTestCaseRun() {
        return testCaseRun;
    }

    @JsonProperty("testCaseRun")
    public void setTestCaseRun(TestCaseRun testCaseRun) {
        this.testCaseRun = testCaseRun;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.format == null)? 0 :this.format.hashCode()));
        result = ((result* 31)+((this.outputType == null)? 0 :this.outputType.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.testCaseRun == null)? 0 :this.testCaseRun.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Content) == false) {
            return false;
        }
        Content rhs = ((Content) other);
        return (((((this.format == rhs.format)||((this.format!= null)&&this.format.equals(rhs.format)))&&((this.outputType == rhs.outputType)||((this.outputType!= null)&&this.outputType.equals(rhs.outputType))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.testCaseRun == rhs.testCaseRun)||((this.testCaseRun!= null)&&this.testCaseRun.equals(rhs.testCaseRun))));
    }

    @Generated("jsonschema2pojo")
    public enum OutputType {

        REPORT("report"),
        VIDEO("video"),
        IMAGE("image"),
        LOG("log"),
        OTHER("other");
        private final String value;
        private final static Map<String, Content.OutputType> CONSTANTS = new HashMap<String, Content.OutputType>();

        static {
            for (Content.OutputType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        OutputType(String value) {
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
        public static Content.OutputType fromValue(String value) {
            Content.OutputType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
