
package dev.cdevents.models.branch.created;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "context",
    "subject",
    "customData",
    "customDataContentType"
})
@Generated("jsonschema2pojo")
public class Branchcreated {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("context")
    private Context context;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    private Subject subject;
    @JsonProperty("customData")
    private Object customData;
    @JsonProperty("customDataContentType")
    private String customDataContentType;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("context")
    public Context getContext() {
        return context;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("context")
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    public Subject getSubject() {
        return subject;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @JsonProperty("customData")
    public Object getCustomData() {
        return customData;
    }

    @JsonProperty("customData")
    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    @JsonProperty("customDataContentType")
    public String getCustomDataContentType() {
        return customDataContentType;
    }

    @JsonProperty("customDataContentType")
    public void setCustomDataContentType(String customDataContentType) {
        this.customDataContentType = customDataContentType;
    }

}
