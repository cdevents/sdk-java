package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.*;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.exception.CDEventsException;
import dev.cdevents.models.CDEvent;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.*;

import static dev.cdevents.constants.CDEventConstants.SCHEMA_CLASSPATH;

public final class CDEvents {

    private CDEvents() {
    }

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();
    private static Logger log = LoggerFactory.getLogger(CDEvents.class);

    /**
     * @param cdEvent
     * @return json string of a cdEvent
     */
    public static String cdEventAsJson(CDEvent cdEvent) {
        try {
            return objectMapper.writeValueAsString(cdEvent);
        } catch (JsonProcessingException e) {
            log.error("Error while mapping cdEvent as Json {}", e.getMessage());
            throw new CDEventsException("Error while mapping cdEvent as Json {}", e);
        }
    }

    /**
     * Creates a CloudEvent from the cdEvent.
     * @param cdEvent
     * @return CloudEvent
     */
    public static CloudEvent cdEventAsCloudEvent(CDEvent cdEvent) {
        if (!validateCDEvent(cdEvent)) {
            log.error("CDEvent validation failed against schema URL - {}", cdEvent.schemaURL());
            throw new CDEventsException("CDEvent validation failed against schema URL - " + cdEvent.schemaURL());
        }
        String cdEventJson = cdEventAsJson(cdEvent);
        log.info("CDEvent with type {} as json - {}", cdEvent.currentCDEventType(), cdEventJson);
        try {
            CloudEvent ceToSend = new CloudEventBuilder()
                    .withId(UUID.randomUUID().toString())
                    .withSource(new URI(cdEvent.eventSource()))
                    .withType(cdEvent.currentCDEventType())
                    .withDataContentType("application/json")
                    .withData(cdEventJson.getBytes(StandardCharsets.UTF_8))
                    .withTime(OffsetDateTime.now())
                    .build();
            return ceToSend;
        } catch (URISyntaxException e) {
            throw new CDEventsException("Exception occurred while building CloudEvent from CDEvent ", e);
        }
    }

    /**
     * Validates the cdEvent against the Schema URL.
     * @param cdEvent
     * @return valid cdEvent
     */
    public static boolean validateCDEvent(CDEvent cdEvent) {
        Set<ValidationMessage> errors = getJsonSchemaValidationMessages(cdEvent);

        if (!errors.isEmpty()) {
            log.error("CDEvent validation failed with errors {}", errors);
            return false;
        }
        return true;
    }

    /**
     * Creates cdEvent from cdEventJson string and validates against schema.
     * @param cdEventJson
     * @return CDEvent, needs type casting to specific CDEvent class
     */
    public static CDEvent cdEventFromJson(String cdEventJson) {
        if (!validateCDEventJson(cdEventJson)) {
            throw new CDEventsException("CDEvent Json validation failed against schema");
        }
        String eventType = getUnVersionedEventTypeFromJson(cdEventJson);
        CDEventConstants.CDEventTypes cdEventType = getCDEventTypeEnum(eventType);
        try {
            CDEvent cdEvent = (CDEvent) new ObjectMapper().readValue(cdEventJson, cdEventType.getEventClass());
            return cdEvent;
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while creating CDEvent from json {}", cdEventJson);
            throw new CDEventsException("Exception occurred while creating CDEvent from json ", e);
        }
    }

    /**
     * Validates the cdEventJson against the Schema URL.
     * @param cdEventJson
     * @return true, If cdEventJson is valid
     */
    public static boolean validateCDEventJson(String cdEventJson) {
        String eventType = getUnVersionedEventTypeFromJson(cdEventJson);
        CDEventConstants.CDEventTypes cdEventType = getCDEventTypeEnum(eventType);
        try {
            CDEvent cdEvent = (CDEvent) new ObjectMapper().readValue(cdEventJson, cdEventType.getEventClass());
            Set<ValidationMessage> errors = getJsonSchemaValidationMessages(cdEvent);

            if (!errors.isEmpty()) {
                log.error("CDEvent Json validation failed against schema URL {}", cdEvent.schemaURL());
                log.error("CDEvent Json validation failed with errors {}", errors);
                return false;
            }
        } catch (JsonProcessingException e) {
            throw new CDEventsException("Exception occurred while validating CDEvent json with schema file ", e);
        }
        return true;
    }

    private static Set<ValidationMessage> getJsonSchemaValidationMessages(CDEvent cdEvent) {
        Map<String, String> schemaMap = new HashMap<>();
        schemaMap.put(cdEvent.schemaURL(), SCHEMA_CLASSPATH + cdEvent.schemaFileName());
        schemaMap.put(cdEvent.baseURI() + "links/embeddedlinksarray", SCHEMA_CLASSPATH+ "links/embeddedlinksarray.json");
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012, builder ->
            // This creates a mapping from $id which starts with https://cdevents.dev/0.4.0/schema to the retrieval URI classpath:schema/
            builder.schemaMappers(schemaMappers -> schemaMappers.mappings(schemaMap))
        );
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        config.setPathType(PathType.JSON_POINTER);
        JsonSchema schema = jsonSchemaFactory.getSchema(SchemaLocation.of(cdEvent.schemaURL()), config);

        JsonNode jsonNode = objectMapper.convertValue(cdEvent, ObjectNode.class);
        return schema.validate(jsonNode);
    }

    private static CDEventConstants.CDEventTypes getCDEventTypeEnum(String eventType) {
        return Arrays.stream(CDEventConstants.CDEventTypes.values())
                .filter(type -> eventType.equals(type.getEventType()))
                .findFirst()
                .orElseThrow(
                () -> {
                    log.error("Invalid CDEvent type found {} from cdEventJson", eventType);
                    return new CDEventsException("Invalid CDEvent type found from cdEventJson");
                }
        );
    }

    private static String getUnVersionedEventTypeFromJson(String cdEventJson) {
        String unVersionedEventType = "";
        try {
            JsonNode rootNode = objectMapper.readTree(cdEventJson);
            if (rootNode.get("context") != null && rootNode.get("context").get("type") != null) {
                String versionedEventType = rootNode.get("context").get("type").asText();
                if (versionedEventType.startsWith(CDEventConstants.EVENT_PREFIX)) {
                    String[] type = versionedEventType.split("\\.");
                    String subject = type[CDEventConstants.EVENT_SUBJECT_INDEX];
                    String predicate = type[CDEventConstants.EVENT_PREDICATE_INDEX];
                    unVersionedEventType = CDEventConstants.EVENT_PREFIX + subject + "." + predicate + ".";
                } else {
                    throw new CDEventsException("Invalid CDEvent type found in CDEvent Json " + versionedEventType);
                }
            } else {
                throw new CDEventsException("Unable to find context and type in CDEvent Json");
            }
            return unVersionedEventType;
        } catch (JsonProcessingException e) {
            throw new CDEventsException("Exception occurred while reading CDEvent Json for eventType ", e);
        }

    }
}
