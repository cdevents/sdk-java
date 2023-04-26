package dev.cdevents.exception;

public class CDEventsException extends  RuntimeException {


    /**
     * Custom CDEventsException to throw.
     * @param message
     */
    public CDEventsException(String message) {
        super(message);
    }
}
