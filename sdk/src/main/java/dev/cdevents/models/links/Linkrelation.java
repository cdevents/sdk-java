
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
    "linkKind",
    "timestamp",
    "source",
    "target",
    "tags"
})
@Generated("jsonschema2pojo")
public class Linkrelation {

    /**
     * This represents the full lifecycles of a series of events in CDEvents
     * (Required)
     * 
     */
    @JsonProperty("chainId")
    @JsonPropertyDescription("This represents the full lifecycles of a series of events in CDEvents")
    private String chainId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    private Linkrelation.LinkType linkType;
    @JsonProperty("linkKind")
    private String linkKind;
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
    @JsonProperty("source")
    @JsonPropertyDescription("")
    private Source source;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("target")
    @JsonPropertyDescription("")
    private Target target;
    @JsonProperty("tags")
    private Tags__2 tags;

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
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Linkrelation.LinkType getLinkType() {
        return linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Linkrelation.LinkType linkType) {
        this.linkType = linkType;
    }

    @JsonProperty("linkKind")
    public String getLinkKind() {
        return linkKind;
    }

    @JsonProperty("linkKind")
    public void setLinkKind(String linkKind) {
        this.linkKind = linkKind;
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
    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("target")
    public Target getTarget() {
        return target;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("target")
    public void setTarget(Target target) {
        this.target = target;
    }

    @JsonProperty("tags")
    public Tags__2 getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags__2 tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.chainId == null)? 0 :this.chainId.hashCode()));
        result = ((result* 31)+((this.linkKind == null)? 0 :this.linkKind.hashCode()));
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.target == null)? 0 :this.target.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Linkrelation) == false) {
            return false;
        }
        Linkrelation rhs = ((Linkrelation) other);
        return ((((((((this.chainId == rhs.chainId)||((this.chainId!= null)&&this.chainId.equals(rhs.chainId)))&&((this.linkKind == rhs.linkKind)||((this.linkKind!= null)&&this.linkKind.equals(rhs.linkKind))))&&((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.target == rhs.target)||((this.target!= null)&&this.target.equals(rhs.target))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

    @Generated("jsonschema2pojo")
    public enum LinkType {

        RELATION("RELATION");
        private final String value;
        private final static Map<String, Linkrelation.LinkType> CONSTANTS = new HashMap<String, Linkrelation.LinkType>();

        static {
            for (Linkrelation.LinkType c: values()) {
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
        public static Linkrelation.LinkType fromValue(String value) {
            Linkrelation.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
