package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class CDEvent {

    @JsonProperty(required = true)
    private Context context;

    @JsonProperty
    private Object customData = new Object();

    @JsonProperty
    private String customDataContentType = "application/json";


    public abstract String currentCDEventType();

    public abstract String schemaURL();

    public void setSource(URI source){
        this.getContext().setSource(source);
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Object getCustomData() {
        return customData;
    }

    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    public String getCustomDataContentType() {
        return customDataContentType;
    }

    public void setCustomDataContentType(String customDataContentType) {
        this.customDataContentType = customDataContentType;
    }

    public void initCDEvent(String cdeventType){
        setContext(new Context(UUID.randomUUID().toString(),LocalDateTime.now(), cdeventType, CDEventConstants.CDEVENTS_SPEC_VERSION));
    }

    @Override
    public String toString() {
        return "CDEvent{" +
                "context=" + context +
                ", customData=" + customData +
                ", customDataContentType='" + customDataContentType + '\'' +
                '}';
    }
}
