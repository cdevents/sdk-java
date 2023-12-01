
package dev.cdevents.models.testsuiterun.started;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "trigger",
    "environment",
    "testSuite"
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
    @JsonProperty("testSuite")
    private TestSuite testSuite;

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

    @JsonProperty("testSuite")
    public TestSuite getTestSuite() {
        return testSuite;
    }

    @JsonProperty("testSuite")
    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }

}
