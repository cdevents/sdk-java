
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
    "from",
    "end",
    "tags"
})
@Generated("jsonschema2pojo")
public class Linkend {

    /**
     * This represents the full lifecycles of a series of events in CDEvents
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    @JsonPropertyDescription("This represents the full lifecycles of a series of events in CDEvents")
    private String chainId;
    /**
     * The type associated with the link. In this case, 'END', suggesting the end of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    @JsonPropertyDescription("The type associated with the link. In this case, 'END', suggesting the end of some CI/CD lifecycle")
    private Linkend.LinkType linkType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Date timestamp;
    /**
     * This is the context ID of the producing CDEvent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    @JsonPropertyDescription("This is the context ID of the producing CDEvent.")
    private From from;
    /**
     * This is the context ID of the final CDEvent in the chain
     * (Required)
     * 
     */
    @JsonProperty("end")
    @JsonPropertyDescription("This is the context ID of the final CDEvent in the chain")
    private End end;
    @JsonProperty("tags")
    private Tags tags;

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
     * The type associated with the link. In this case, 'END', suggesting the end of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Linkend.LinkType getLinkType() {
        return linkType;
    }

    /**
     * The type associated with the link. In this case, 'END', suggesting the end of some CI/CD lifecycle
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Linkend.LinkType linkType) {
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
     * This is the context ID of the producing CDEvent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    public From getFrom() {
        return from;
    }

    /**
     * This is the context ID of the producing CDEvent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    public void setFrom(From from) {
        this.from = from;
    }

    /**
     * This is the context ID of the final CDEvent in the chain
     * (Required)
     * 
     */
    @JsonProperty("end")
    public End getEnd() {
        return end;
    }

    /**
     * This is the context ID of the final CDEvent in the chain
     * (Required)
     * 
     */
    @JsonProperty("end")
    public void setEnd(End end) {
        this.end = end;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.chainId == null)? 0 :this.chainId.hashCode()));
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.from == null)? 0 :this.from.hashCode()));
        result = ((result* 31)+((this.end == null)? 0 :this.end.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Linkend) == false) {
            return false;
        }
        Linkend rhs = ((Linkend) other);
        return (((((((this.chainId == rhs.chainId)||((this.chainId!= null)&&this.chainId.equals(rhs.chainId)))&&((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType))))&&((this.from == rhs.from)||((this.from!= null)&&this.from.equals(rhs.from))))&&((this.end == rhs.end)||((this.end!= null)&&this.end.equals(rhs.end))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }


    /**
     * The type associated with the link. In this case, 'END', suggesting the end of some CI/CD lifecycle
     * 
     */
    @Generated("jsonschema2pojo")
    public enum LinkType {

        END("END");
        private final String value;
        private final static Map<String, Linkend.LinkType> CONSTANTS = new HashMap<String, Linkend.LinkType>();

        static {
            for (Linkend.LinkType c: values()) {
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
        public static Linkend.LinkType fromValue(String value) {
            Linkend.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
