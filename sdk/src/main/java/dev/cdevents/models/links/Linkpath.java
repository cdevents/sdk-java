
package dev.cdevents.models.links;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chainId",
    "timestamp",
    "linkType",
    "from",
    "to",
    "tags"
})
@Generated("jsonschema2pojo")
public class Linkpath {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    private String chainId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Date timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    private Linkpath.LinkType linkType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("from")
    private From__1 from;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("to")
    private To to;
    @JsonProperty("tags")
    private Tags__1 tags;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    public String getChainId() {
        return chainId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    public void setChainId(String chainId) {
        this.chainId = chainId;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Linkpath.LinkType getLinkType() {
        return linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Linkpath.LinkType linkType) {
        this.linkType = linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("from")
    public From__1 getFrom() {
        return from;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("from")
    public void setFrom(From__1 from) {
        this.from = from;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("to")
    public To getTo() {
        return to;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("to")
    public void setTo(To to) {
        this.to = to;
    }

    @JsonProperty("tags")
    public Tags__1 getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags__1 tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.chainId == null)? 0 :this.chainId.hashCode()));
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.from == null)? 0 :this.from.hashCode()));
        result = ((result* 31)+((this.to == null)? 0 :this.to.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Linkpath) == false) {
            return false;
        }
        Linkpath rhs = ((Linkpath) other);
        return (((((((this.chainId == rhs.chainId)||((this.chainId!= null)&&this.chainId.equals(rhs.chainId)))&&((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType))))&&((this.from == rhs.from)||((this.from!= null)&&this.from.equals(rhs.from))))&&((this.to == rhs.to)||((this.to!= null)&&this.to.equals(rhs.to))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

    @Generated("jsonschema2pojo")
    public enum LinkType {

        PATH("PATH");
        private final String value;
        private final static Map<String, Linkpath.LinkType> CONSTANTS = new HashMap<String, Linkpath.LinkType>();

        static {
            for (Linkpath.LinkType c: values()) {
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
        public static Linkpath.LinkType fromValue(String value) {
            Linkpath.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
