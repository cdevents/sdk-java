package dev.cdevents.models;

import java.net.URI;

public interface CDEvent {

    /**
     * @return current CDEvent type
     */
    String currentCDEventType();

    /**
     * @return schema URL for validating the CDEvent structure
     */
    String schemaURL();

    /**
     * @return base URI of CDEvent's schema
     */
    String baseURI();

    /**
     * @return spec schema file name
     */
    String schemaFileName();

    /**
     * Initialize the CDEvent with the context values.
     */
    void initCDEvent();

    /**
     * @return source of the event
     */
    String eventSource();

    /**
     *
     * @return custom schema URI
     */
    URI contextSchemaUri();

}
