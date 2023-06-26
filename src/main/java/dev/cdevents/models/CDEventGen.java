package dev.cdevents.models;

import java.io.IOException;

public interface CDEventGen {

    /**
     * @return current CDEvent type
     */
    public String currentCDEventType();

    /**
     * @return schema URL for validating the CDEvent structure
     */
    public String schemaURL();

    /**
     * @return schema json for validating the CDEvent structure
     */
    public String eventSchema();

    /**
     * Initialize the CDEvent with the context values
     */
    public void initCDEvent();

    public String eventSource();

}
