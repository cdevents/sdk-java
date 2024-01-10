
package dev.cdevents.models.incident.reported;

import java.net.URI;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "environment",
    "ticketURI",
    "service",
    "artifactId"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("description")
    private String description;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    private Environment environment;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ticketURI")
    private URI ticketURI;
    @JsonProperty("service")
    private Service service;
    @JsonProperty("artifactId")
    private String artifactId;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("environment")
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ticketURI")
    public URI getTicketURI() {
        return ticketURI;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ticketURI")
    public void setTicketURI(URI ticketURI) {
        this.ticketURI = ticketURI;
    }

    @JsonProperty("service")
    public Service getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(Service service) {
        this.service = service;
    }

    @JsonProperty("artifactId")
    public String getArtifactId() {
        return artifactId;
    }

    @JsonProperty("artifactId")
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
        result = ((result* 31)+((this.ticketURI == null)? 0 :this.ticketURI.hashCode()));
        result = ((result* 31)+((this.artifactId == null)? 0 :this.artifactId.hashCode()));
        result = ((result* 31)+((this.service == null)? 0 :this.service.hashCode()));
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
        return ((((((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment))))&&((this.ticketURI == rhs.ticketURI)||((this.ticketURI!= null)&&this.ticketURI.equals(rhs.ticketURI))))&&((this.artifactId == rhs.artifactId)||((this.artifactId!= null)&&this.artifactId.equals(rhs.artifactId))))&&((this.service == rhs.service)||((this.service!= null)&&this.service.equals(rhs.service))));
    }

}
