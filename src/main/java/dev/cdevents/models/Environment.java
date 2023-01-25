package dev.cdevents.models;

import java.net.URI;

public class Environment {
    private String id;
    private URI source;
    private String name;
    private String url;

    public Environment(String id, URI source, String name, String url) {
        this.id = id;
        this.source = source;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
