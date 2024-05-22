
package dev.cdevents.models.ticket.created;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "summary",
    "ticketType",
    "group",
    "creator",
    "assignees",
    "priority",
    "labels",
    "milestone",
    "uri"
})
@Generated("jsonschema2pojo")
public class Content {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("ticketType")
    private Object ticketType;
    @JsonProperty("group")
    private String group;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("creator")
    private String creator;
    @JsonProperty("assignees")
    private List<String> assignees = new ArrayList<String>();
    @JsonProperty("priority")
    private Object priority;
    @JsonProperty("labels")
    private List<String> labels = new ArrayList<String>();
    @JsonProperty("milestone")
    private String milestone;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    private String uri;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("ticketType")
    public Object getTicketType() {
        return ticketType;
    }

    @JsonProperty("ticketType")
    public void setTicketType(Object ticketType) {
        this.ticketType = ticketType;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("creator")
    public String getCreator() {
        return creator;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("creator")
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @JsonProperty("assignees")
    public List<String> getAssignees() {
        return assignees;
    }

    @JsonProperty("assignees")
    public void setAssignees(List<String> assignees) {
        this.assignees = assignees;
    }

    @JsonProperty("priority")
    public Object getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Object priority) {
        this.priority = priority;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @JsonProperty("milestone")
    public String getMilestone() {
        return milestone;
    }

    @JsonProperty("milestone")
    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.creator == null)? 0 :this.creator.hashCode()));
        result = ((result* 31)+((this.milestone == null)? 0 :this.milestone.hashCode()));
        result = ((result* 31)+((this.assignees == null)? 0 :this.assignees.hashCode()));
        result = ((result* 31)+((this.ticketType == null)? 0 :this.ticketType.hashCode()));
        result = ((result* 31)+((this.priority == null)? 0 :this.priority.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.group == null)? 0 :this.group.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
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
        return ((((((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.creator == rhs.creator)||((this.creator!= null)&&this.creator.equals(rhs.creator))))&&((this.milestone == rhs.milestone)||((this.milestone!= null)&&this.milestone.equals(rhs.milestone))))&&((this.assignees == rhs.assignees)||((this.assignees!= null)&&this.assignees.equals(rhs.assignees))))&&((this.ticketType == rhs.ticketType)||((this.ticketType!= null)&&this.ticketType.equals(rhs.ticketType))))&&((this.priority == rhs.priority)||((this.priority!= null)&&this.priority.equals(rhs.priority))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.group == rhs.group)||((this.group!= null)&&this.group.equals(rhs.group))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))));
    }

}
