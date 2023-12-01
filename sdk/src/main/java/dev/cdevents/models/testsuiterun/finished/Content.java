
package dev.cdevents.models.testsuiterun.finished;

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
    "environment",
    "testSuite",
    "outcome",
    "severity",
    "reason"
})
@Generated("jsonschema2pojo")
public class Content {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    private Environment environment;
    @JsonProperty("testSuite")
    private TestSuite testSuite;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outcome")
    private Content.Outcome outcome;
    @JsonProperty("severity")
    private Content.Severity severity;
    @JsonProperty("reason")
    private String reason;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @JsonProperty("testSuite")
    public TestSuite getTestSuite() {
        return testSuite;
    }

    @JsonProperty("testSuite")
    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outcome")
    public Content.Outcome getOutcome() {
        return outcome;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outcome")
    public void setOutcome(Content.Outcome outcome) {
        this.outcome = outcome;
    }

    @JsonProperty("severity")
    public Content.Severity getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(Content.Severity severity) {
        this.severity = severity;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Generated("jsonschema2pojo")
    public enum Outcome {

        PASS("pass"),
        FAIL("fail"),
        CANCEL("cancel"),
        ERROR("error");
        private final String value;
        private final static Map<String, Content.Outcome> CONSTANTS = new HashMap<String, Content.Outcome>();

        static {
            for (Content.Outcome c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Outcome(String value) {
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
        public static Content.Outcome fromValue(String value) {
            Content.Outcome constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Severity {

        LOW("low"),
        MEDIUM("medium"),
        HIGH("high"),
        CRITICAL("critical");
        private final String value;
        private final static Map<String, Content.Severity> CONSTANTS = new HashMap<String, Content.Severity>();

        static {
            for (Content.Severity c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Severity(String value) {
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
        public static Content.Severity fromValue(String value) {
            Content.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
