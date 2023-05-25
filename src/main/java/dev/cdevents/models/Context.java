package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDateTime;

public class Context {
    @JsonProperty(required = true)
    private String id;

    @JsonProperty(required = true)
    private String type;

    @JsonProperty(required = true)
    private URI source;

    @JsonProperty(required = true)
    private String version;

    @JsonProperty(required = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime timestamp;

    /**
     * Empty constructor.
     */
    public Context() {
    }

    /**
     * @param id
     * @param timestamp
     * @param type
     * @param version
     */
    public Context(String id, LocalDateTime timestamp, String type, String version) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.version = version;
    }

    /**
     * @return Context id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return source
     */
    public URI getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(URI source) {
        this.source = source;
    }

    /**
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
