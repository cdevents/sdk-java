
package dev.cdevents.models.links.embedded;

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
    "linkType",
    "from",
    "tags"
})
@Generated("jsonschema2pojo")
public class Embeddedlinkpath {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    private Embeddedlinkpath.LinkType linkType;
    /**
     * When consuming a CDEvent, you are consuming a parent event. So, when looking at the 'from' key, this is the parent's parent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    @JsonPropertyDescription("When consuming a CDEvent, you are consuming a parent event. So, when looking at the 'from' key, this is the parent's parent.")
    private From__1 from;
    @JsonProperty("tags")
    private Tags__1 tags;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Embeddedlinkpath.LinkType getLinkType() {
        return linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Embeddedlinkpath.LinkType linkType) {
        this.linkType = linkType;
    }

    /**
     * When consuming a CDEvent, you are consuming a parent event. So, when looking at the 'from' key, this is the parent's parent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    public From__1 getFrom() {
        return from;
    }

    /**
     * When consuming a CDEvent, you are consuming a parent event. So, when looking at the 'from' key, this is the parent's parent.
     * (Required)
     * 
     */
    @JsonProperty("from")
    public void setFrom(From__1 from) {
        this.from = from;
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
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.from == null)? 0 :this.from.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embeddedlinkpath) == false) {
            return false;
        }
        Embeddedlinkpath rhs = ((Embeddedlinkpath) other);
        return ((((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType)))&&((this.from == rhs.from)||((this.from!= null)&&this.from.equals(rhs.from))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

    @Generated("jsonschema2pojo")
    public enum LinkType {

        PATH("PATH");
        private final String value;
        private final static Map<String, Embeddedlinkpath.LinkType> CONSTANTS = new HashMap<String, Embeddedlinkpath.LinkType>();

        static {
            for (Embeddedlinkpath.LinkType c: values()) {
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
        public static Embeddedlinkpath.LinkType fromValue(String value) {
            Embeddedlinkpath.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
