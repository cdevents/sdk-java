
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
    "linkKind",
    "target",
    "tags"
})
@Generated("jsonschema2pojo")
public class Embeddedlinkrelation {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    private Embeddedlinkrelation.LinkType linkType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkKind")
    private String linkKind;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public Embeddedlinkrelation.LinkType getLinkType() {
        return linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkType")
    public void setLinkType(Embeddedlinkrelation.LinkType linkType) {
        this.linkType = linkType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkKind")
    public String getLinkKind() {
        return linkKind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linkKind")
    public void setLinkKind(String linkKind) {
        this.linkKind = linkKind;
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
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.linkKind == null)? 0 :this.linkKind.hashCode()));
        result = ((result* 31)+((this.target == null)? 0 :this.target.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embeddedlinkrelation) == false) {
            return false;
        }
        Embeddedlinkrelation rhs = ((Embeddedlinkrelation) other);
        return (((((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType)))&&((this.linkKind == rhs.linkKind)||((this.linkKind!= null)&&this.linkKind.equals(rhs.linkKind))))&&((this.target == rhs.target)||((this.target!= null)&&this.target.equals(rhs.target))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

    @Generated("jsonschema2pojo")
    public enum LinkType {

        RELATION("RELATION");
        private final String value;
        private final static Map<String, Embeddedlinkrelation.LinkType> CONSTANTS = new HashMap<String, Embeddedlinkrelation.LinkType>();

        static {
            for (Embeddedlinkrelation.LinkType c: values()) {
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
        public static Embeddedlinkrelation.LinkType fromValue(String value) {
            Embeddedlinkrelation.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
