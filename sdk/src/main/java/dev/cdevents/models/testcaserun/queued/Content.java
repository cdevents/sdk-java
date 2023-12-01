
package dev.cdevents.models.testcaserun.queued;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "trigger",
    "environment",
    "testSuiteRun",
    "testCase"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("trigger")
    private Trigger trigger;
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

    @JsonProperty("trigger")
    public Trigger getTrigger() {
        return trigger;
    }

    @JsonProperty("trigger")
    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
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

}
