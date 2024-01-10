
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

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.severity == null)? 0 :this.severity.hashCode()));
        result = ((result* 31)+((this.reason == null)? 0 :this.reason.hashCode()));
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
        result = ((result* 31)+((this.testSuite == null)? 0 :this.testSuite.hashCode()));
        result = ((result* 31)+((this.outcome == null)? 0 :this.outcome.hashCode()));
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
        return ((((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.reason == rhs.reason)||((this.reason!= null)&&this.reason.equals(rhs.reason))))&&((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment))))&&((this.testSuite == rhs.testSuite)||((this.testSuite!= null)&&this.testSuite.equals(rhs.testSuite))))&&((this.outcome == rhs.outcome)||((this.outcome!= null)&&this.outcome.equals(rhs.outcome))));
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
