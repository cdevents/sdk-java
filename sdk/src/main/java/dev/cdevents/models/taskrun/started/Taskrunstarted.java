
package dev.cdevents.models.taskrun.started;

import javax.annotation.Generated;
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
public class Taskrunstarted {

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

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.context == null)? 0 :this.context.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.customDataContentType == null)? 0 :this.customDataContentType.hashCode()));
        result = ((result* 31)+((this.subject == null)? 0 :this.subject.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Taskrunstarted) == false) {
            return false;
        }
        Taskrunstarted rhs = ((Taskrunstarted) other);
        return (((((this.context == rhs.context)||((this.context!= null)&&this.context.equals(rhs.context)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.customDataContentType == rhs.customDataContentType)||((this.customDataContentType!= null)&&this.customDataContentType.equals(rhs.customDataContentType))))&&((this.subject == rhs.subject)||((this.subject!= null)&&this.subject.equals(rhs.subject))));
    }

}
