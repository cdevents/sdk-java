
package dev.cdevents.models.testcaserun.finished;

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
    "outcome",
    "severity",
    "reason",
    "environment",
    "testSuiteRun",
    "testCase"
})
@Generated("jsonschema2pojo")
public class Content {

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
    private Environment environment;
    @JsonProperty("testSuiteRun")
    private TestSuiteRun testSuiteRun;
    @JsonProperty("testCase")
    private TestCase testCase;

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

    @JsonProperty("testSuiteRun")
    public TestSuiteRun getTestSuiteRun() {
        return testSuiteRun;
    }

    @JsonProperty("testSuiteRun")
    public void setTestSuiteRun(TestSuiteRun testSuiteRun) {
        this.testSuiteRun = testSuiteRun;
    }

    @JsonProperty("testCase")
    public TestCase getTestCase() {
        return testCase;
    }

    @JsonProperty("testCase")
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.severity == null)? 0 :this.severity.hashCode()));
        result = ((result* 31)+((this.reason == null)? 0 :this.reason.hashCode()));
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
        result = ((result* 31)+((this.testSuiteRun == null)? 0 :this.testSuiteRun.hashCode()));
        result = ((result* 31)+((this.outcome == null)? 0 :this.outcome.hashCode()));
        result = ((result* 31)+((this.testCase == null)? 0 :this.testCase.hashCode()));
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
        return (((((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.reason == rhs.reason)||((this.reason!= null)&&this.reason.equals(rhs.reason))))&&((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment))))&&((this.testSuiteRun == rhs.testSuiteRun)||((this.testSuiteRun!= null)&&this.testSuiteRun.equals(rhs.testSuiteRun))))&&((this.outcome == rhs.outcome)||((this.outcome!= null)&&this.outcome.equals(rhs.outcome))))&&((this.testCase == rhs.testCase)||((this.testCase!= null)&&this.testCase.equals(rhs.testCase))));
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
