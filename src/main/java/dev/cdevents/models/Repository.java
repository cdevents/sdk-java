package dev.cdevents.models;

import java.net.URI;

public class Repository {
    /**
     * id.
     */
    private String id;
    /**
     * source.
     */
    private URI source;
    /**
     * name.
     */
    private String name;
    /**
     * owner.
     */
    private String owner;
    /**
     * url.
     */
    private URI url;
    /**
     * viewUrl.
     */
    private URI viewUrl;

    /**
     * Repository
     */
    public Repository() {
    }

    /**
     * @return id
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return url
     */
    public URI getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * @return viewUrl
     */
    public URI getViewUrl() {
        return viewUrl;
    }

    /**
     * @param viewUrl
     */
    public void setViewUrl(URI viewUrl) {
        this.viewUrl = viewUrl;
    }
}
