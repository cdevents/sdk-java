
package dev.cdevents.models.artifact.downloaded;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "id",
    "source",
    "type",
    "timestamp",
    "schemaUri",
    "chainId",
    "links"
})
@Generated("jsonschema2pojo")
public class Context {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    private String version;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    private String source;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private Context.Type type = Context.Type.fromValue("dev.cdevents.artifact.downloaded.0.1.0");
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Date timestamp;
    @JsonProperty("schemaUri")
    private URI schemaUri;
    @JsonProperty("chainId")
    private String chainId;
    @JsonProperty("links")
    private List<Object> links = new ArrayList<Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public Context.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(Context.Type type) {
        this.type = type;
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

    @JsonProperty("schemaUri")
    public URI getSchemaUri() {
        return schemaUri;
    }

    @JsonProperty("schemaUri")
    public void setSchemaUri(URI schemaUri) {
        this.schemaUri = schemaUri;
    }

    @JsonProperty("chainId")
    public String getChainId() {
        return chainId;
    }

    @JsonProperty("chainId")
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    @JsonProperty("links")
    public List<Object> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Object> links) {
        this.links = links;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.chainId == null)? 0 :this.chainId.hashCode()));
        result = ((result* 31)+((this.schemaUri == null)? 0 :this.schemaUri.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Context) == false) {
            return false;
        }
        Context rhs = ((Context) other);
        return (((((((((this.chainId == rhs.chainId)||((this.chainId!= null)&&this.chainId.equals(rhs.chainId)))&&((this.schemaUri == rhs.schemaUri)||((this.schemaUri!= null)&&this.schemaUri.equals(rhs.schemaUri))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        DEV_CDEVENTS_ARTIFACT_DOWNLOADED_0_1_0("dev.cdevents.artifact.downloaded.0.1.0");
        private final String value;
        private final static Map<String, Context.Type> CONSTANTS = new HashMap<String, Context.Type>();

        static {
            for (Context.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
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
        public static Context.Type fromValue(String value) {
            Context.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
