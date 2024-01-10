
package dev.cdevents.models.testcaserun.started;

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

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
        result = ((result* 31)+((this.trigger == null)? 0 :this.trigger.hashCode()));
        result = ((result* 31)+((this.testSuiteRun == null)? 0 :this.testSuiteRun.hashCode()));
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
        return (((((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment)))&&((this.trigger == rhs.trigger)||((this.trigger!= null)&&this.trigger.equals(rhs.trigger))))&&((this.testSuiteRun == rhs.testSuiteRun)||((this.testSuiteRun!= null)&&this.testSuiteRun.equals(rhs.testSuiteRun))))&&((this.testCase == rhs.testCase)||((this.testCase!= null)&&this.testCase.equals(rhs.testCase))));
    }

}
