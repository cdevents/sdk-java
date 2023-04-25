package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.events.PipelineRunFinishedCDEvent;
import dev.cdevents.exception.CDEventsException;
import dev.cdevents.models.CDEvent;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CDEvents {

    private CDEvents() {
    }

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();
    private static Logger log = LoggerFactory.getLogger(CDEvents.class);

    /**
     * Creates a PipelineRunFinishedCDEvent with the default structure of CDEvent.
     * @return PipelineRunFinishedCDEvent
     */
    public static PipelineRunFinishedCDEvent createPipelineRunFinishedEvent() {
        PipelineRunFinishedCDEvent pipelineRunFinishedCDEvent = new PipelineRunFinishedCDEvent();
        return pipelineRunFinishedCDEvent;
    }


    /**
     * @param cdEvent
     * @return json string of a cdEvent
     */
    public static String cdEventAsJson(CDEvent cdEvent) {
        String asJson = "";
        try {
            asJson = objectMapper.writeValueAsString(cdEvent);
        } catch (JsonProcessingException e) {
            log.error("Error while mapping cdEvent as Json {}", e.getMessage());
        }
        return asJson;
    }


    /**
     * Creates a CloudEvent from the cdEvent.
     * @param cdEvent
     * @return CloudEvent
     */
    public static CloudEvent cdEventAsCloudEvent(CDEvent cdEvent) {

        String cdEventJson = cdEventAsJson(cdEvent);
        if (cdEventJson.isEmpty()) {
            log.error("cdEvent json is empty, failed to create CDEvent as Json");
            throw new CDEventsException("Failed to create CDEvent as Json");
        }
        if (!validateCDEvent(cdEvent)) {
            log.error("CDEvent validation failed against schema URL - {}", cdEvent.schemaURL());
            throw new CDEventsException("CDEvent validation failed against schema URL - " + cdEvent.schemaURL());
        }
        CloudEvent ceToSend = new CloudEventBuilder()
                .withId(UUID.randomUUID().toString())
                .withSource(cdEvent.getContext().getSource())
                .withType(cdEvent.getContext().getType())
                .withDataContentType("application/json")
                .withData(cdEventJson.getBytes(StandardCharsets.UTF_8))
                .withTime(OffsetDateTime.now())
                .build();

        return ceToSend;
    }

    /**
     * Validates the cdEvent against the Schema URL.
     * @param cdEvent
     * @return valid cdEvent
     */
    public static boolean validateCDEvent(CDEvent cdEvent) {
        String cdEventJson = cdEventAsJson(cdEvent);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        JsonSchema jsonSchema = factory.getSchema(URI.create(cdEvent.schemaURL()));

        JsonNode jsonNode = objectMapper.convertValue(cdEvent, ObjectNode.class);
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

        if (!errors.isEmpty()) {
            log.error("CDEvent validation failed with errors {}", errors);
            return false;
        }
        return true;
    }

}
