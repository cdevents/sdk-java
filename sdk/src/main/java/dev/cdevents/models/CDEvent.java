package dev.cdevents.models;

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
     * @return schema json for validating the CDEvent structure
     */
    String eventSchema();

    /**
     * Initialize the CDEvent with the context values.
     */
    void initCDEvent();

    /**
     * @return source of the event
     */
    String eventSource();

}
