package dev.cdevents.models;

import java.net.URI;

public class Repository {
    private String id;
    private URI source;
    private String name;
    private String owner;
    private URI url;
    private URI viewUrl;

    public Repository() {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public URI getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(URI viewUrl) {
        this.viewUrl = viewUrl;
    }
}
