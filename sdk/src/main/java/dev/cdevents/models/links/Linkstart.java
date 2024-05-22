
package dev.cdevents.models.links;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chainId",
    "linkType",
    "timestamp",
    "start",
    "tags"
})
@Generated("jsonschema2pojo")
public class Linkstart {

    /**
     * This represents the full lifecycles of a series of events in CDEvents
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    @JsonPropertyDescription("This represents the full lifecycles of a series of events in CDEvents")
    private String chainId;
    /**
     * The type associated with the link. In this case, 'START', suggesting the start of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    @JsonPropertyDescription("The type associated with the link. In this case, 'START', suggesting the start of some CI/CD lifecycle")
    private Linkstart.LinkType linkType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Date timestamp;
    /**
     * This is the context ID of the starting CDEvent in the chain.
     * (Required)
     * 
     */
    @JsonProperty("start")
    @JsonPropertyDescription("This is the context ID of the starting CDEvent in the chain.")
    private Start start;
    @JsonProperty("tags")
    private Tags__3 tags;

    /**
     * This represents the full lifecycles of a series of events in CDEvents
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    public String getChainId() {
        return chainId;
    }

    /**
     * This represents the full lifecycles of a series of events in CDEvents
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    /**
     * The type associated with the link. In this case, 'START', suggesting the start of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Linkstart.LinkType getLinkType() {
        return linkType;
    }

    /**
     * The type associated with the link. In this case, 'START', suggesting the start of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Linkstart.LinkType linkType) {
        this.linkType = linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * This is the context ID of the starting CDEvent in the chain.
     * (Required)
     * 
     */
    @JsonProperty("start")
    public Start getStart() {
        return start;
    }

    /**
     * This is the context ID of the starting CDEvent in the chain.
     * (Required)
     * 
     */
    @JsonProperty("start")
    public void setStart(Start start) {
        this.start = start;
    }

    @JsonProperty("tags")
    public Tags__3 getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags__3 tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.start == null)? 0 :this.start.hashCode()));
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.chainId == null)? 0 :this.chainId.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Linkstart) == false) {
            return false;
        }
        Linkstart rhs = ((Linkstart) other);
        return ((((((this.start == rhs.start)||((this.start!= null)&&this.start.equals(rhs.start)))&&((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType))))&&((this.chainId == rhs.chainId)||((this.chainId!= null)&&this.chainId.equals(rhs.chainId))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }


    /**
     * The type associated with the link. In this case, 'START', suggesting the start of some CI/CD lifecycle
     * 
     */
    @Generated("jsonschema2pojo")
    public enum LinkType {

        START("START");
        private final String value;
        private final static Map<String, Linkstart.LinkType> CONSTANTS = new HashMap<String, Linkstart.LinkType>();

        static {
            for (Linkstart.LinkType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        LinkType(String value) {
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
        public static Linkstart.LinkType fromValue(String value) {
            Linkstart.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
