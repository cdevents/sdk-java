package dev.cdevents.models;

import java.net.URI;

public class Environment {
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
     * url.
     */
    private String url;

    /**
     * @param id
     * @param source
     * @param name
     * @param url
     */
    public Environment(final String id, final URI source, final String name, final String url) {
        this.id = id;
        this.source = source;
        this.name = name;
        this.url = url;
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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
