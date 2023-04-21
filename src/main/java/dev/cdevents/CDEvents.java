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

public class CDEvents {

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();
    private static Logger log = LoggerFactory.getLogger(CDEvents.class);

    public static PipelineRunFinishedCDEvent createPipelineRunFinishedEvent() {
        PipelineRunFinishedCDEvent pipelineRunFinishedCDEvent = new PipelineRunFinishedCDEvent();
        return pipelineRunFinishedCDEvent;
    }


    public static String cdEventToJson(CDEvent cdEvent){
        try {
            return objectMapper.writeValueAsString(cdEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static CloudEvent asCloudEvent(CDEvent cdEvent){

        String cdEventJson = cdEventToJson(cdEvent);
        if(!validateCDEvent(cdEvent)){
            throw new RuntimeException("CDEvent validation failed against schema URL - "+cdEvent.schemaURL());
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

    public static boolean validateCDEvent(CDEvent cdEvent){
        String cdEventJson = cdEventToJson(cdEvent);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        System.out.println(cdEvent.schemaURL());
        JsonSchema jsonSchema = factory.getSchema(URI.create(cdEvent.schemaURL()));

        JsonNode jsonNode = objectMapper.convertValue(cdEvent, ObjectNode.class);
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

        if(!errors.isEmpty()){
            log.error("CDEvent validation failed with errors {}", errors);
            System.out.println("CDEvent validation failed with errors "+errors);
            return false;
        }
        return true;
    }
}
