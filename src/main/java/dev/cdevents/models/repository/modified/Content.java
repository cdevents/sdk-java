
package dev.cdevents.models.repository.modified;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "owner",
    "url",
    "viewUrl"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("url")
    private String url;
    @JsonProperty("viewUrl")
    private String viewUrl;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("viewUrl")
    public String getViewUrl() {
        return viewUrl;
    }

    @JsonProperty("viewUrl")
    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

}
