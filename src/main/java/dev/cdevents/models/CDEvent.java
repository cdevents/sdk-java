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


    /**
     * @return current CDEvent type
     */
    public abstract String currentCDEventType();

    /**
     * @return schema URL for validating the CDEvent structure
     */
    public abstract String schemaURL();

    /**
     * @param source
     * Sets the {@link Context} source value
     */
    public void setSource(URI source) {
        this.getContext().setSource(source);
    }

    /**
     * @return context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * @return customData
     */
    public Object getCustomData() {
        return customData;
    }

    /**
     * @param customData
     */
    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    /**
     * @return customDataContentType
     */
    public String getCustomDataContentType() {
        return customDataContentType;
    }

    /**
     * @param customDataContentType
     */
    public void setCustomDataContentType(String customDataContentType) {
        this.customDataContentType = customDataContentType;
    }

    /**
     * @param cdeventType
     * Initialize the CDEvent with the context values
     */
    public void initCDEvent(String cdeventType) {
        setContext(new Context(UUID.randomUUID().toString(), LocalDateTime.now(), cdeventType, CDEventConstants.CDEVENTS_SPEC_VERSION));
    }
}
