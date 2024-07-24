package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.PathType;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaValidatorsConfig;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import static dev.cdevents.constants.CDEventConstants.CUSTOM_EVENT_PREFIX;
import static dev.cdevents.constants.CDEventConstants.CUSTOM_SCHEMA_CLASSPATH;
import static dev.cdevents.constants.CDEventConstants.EVENT_PREFIX;
import dev.cdevents.events.CustomTypeEvent;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
        try {
            return buildCloudEvent(cdEvent);
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
        if (cdEvent.currentCDEventType().startsWith(EVENT_PREFIX)) {
            return  validateWithOfficialSchema(cdEvent);
        } else {
            return validateWithOfficialCustomSchema(cdEvent);
        }
    }

    /**
     * Creates cdEvent from cdEventJson string and validates against schema.
     * @param cdEventJson json string of any CDEvent type
     * @return CDEvent needs type casting to specific CDEvent class
     */
    public static CDEvent cdEventFromJson(String cdEventJson) {
        String eventType = getUnVersionedEventTypeFromJson(cdEventJson);
        CDEventConstants.CDEventTypes cdEventType = getCDEventTypeEnum(eventType);
        try {
            CDEvent cdEvent = new ObjectMapper().readValue(cdEventJson, cdEventType.getEventClass());
            if (!validateCDEvent(cdEvent)) {
                throw new CDEventsException("CDEvent Json validation failed against schema");
            }
            return cdEvent;
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while creating CDEvent from json {}", cdEventJson);
            throw new CDEventsException("Exception occurred while creating CDEvent from json ", e);
        }
    }

    /**
     * Validates the CDEvent against the official spec/schemas/.
     * @param cdEvent
     * @return true if valid cdEvent
     */
    private static boolean validateWithOfficialSchema(CDEvent cdEvent) {
        Map<String, String> schemaMap = new HashMap<>();
        schemaMap.put(cdEvent.schemaURL(), SCHEMA_CLASSPATH + cdEvent.schemaFileName());
        schemaMap.put(cdEvent.baseURI() + "links/embeddedlinksarray", SCHEMA_CLASSPATH + "links/embeddedlinksarray.json");
        Set<ValidationMessage> errors = getJsonSchemaValidationMessages(cdEvent, schemaMap);
        if (!errors.isEmpty()) {
            log.error("CDEvent validation failed with errors {}", errors);
            return false;
        }
        return true;
    }

    /**
     * Validates the custom CDEvent against the official spec/custom/schema.json.
     * @param customCDEvent
     * @return true if valid cdEvent
     */
    private static boolean validateWithOfficialCustomSchema(CDEvent customCDEvent) {
        Map<String, String> schemaMap = new HashMap<>();
        schemaMap.put(customCDEvent.schemaURL(), CUSTOM_SCHEMA_CLASSPATH + "schema.json");
        schemaMap.put(customCDEvent.baseURI() + "links/embeddedlinksarray", SCHEMA_CLASSPATH + "links/embeddedlinksarray.json");
        log.info("Validate custom CDEvent against official spec/custom/schema.json");
        Set<ValidationMessage> errors = getJsonSchemaValidationMessages(customCDEvent, schemaMap);
        if (!errors.isEmpty()) {
            log.error("Custom CDEvent validation failed against official spec/custom/schema.json, with errors {}", errors);
            return false;
        }
        return true;
    }

    private static CloudEvent buildCloudEvent(CDEvent cdEvent) throws URISyntaxException {
        String cdEventJson = cdEventAsJson(cdEvent);
        log.debug("CDEvent with type {} as json - {}", cdEvent.currentCDEventType(), cdEventJson);
        return new CloudEventBuilder()
                .withId(UUID.randomUUID().toString())
                .withSource(new URI(cdEvent.eventSource()))
                .withType(cdEvent.currentCDEventType())
                .withDataContentType("application/json")
                .withData(cdEventJson.getBytes(StandardCharsets.UTF_8))
                .withTime(OffsetDateTime.now())
                .build();
    }

    private static Set<ValidationMessage> getJsonSchemaValidationMessages(CDEvent cdEvent, Map<String, String> schemaMap) {
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
        try {
            JsonNode rootNode = objectMapper.readTree(cdEventJson);
            if (rootNode.get("context") != null && rootNode.get("context").get("type") != null) {
                String versionedEventType = rootNode.get("context").get("type").asText();
                if (versionedEventType.startsWith(CDEventConstants.EVENT_PREFIX)) {
                    String[] type = versionedEventType.split("\\.");
                    String subject = type[CDEventConstants.EVENT_SUBJECT_INDEX];
                    String predicate = type[CDEventConstants.EVENT_PREDICATE_INDEX];
                    return CDEventConstants.EVENT_PREFIX + subject + "." + predicate + ".";
                } else if (versionedEventType.startsWith(CUSTOM_EVENT_PREFIX)) {
                    return CUSTOM_EVENT_PREFIX;
                } else {
                    throw new CDEventsException("Invalid CDEvent type found in CDEvent Json " + versionedEventType);
                }
            } else {
                throw new CDEventsException("Unable to find context and type in CDEvent Json");
            }
        } catch (JsonProcessingException e) {
            throw new CDEventsException("Exception occurred while reading CDEvent Json for eventType ", e);
        }
    }
}
