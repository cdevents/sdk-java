package dev.cdevents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.CustomTypeEvent;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomCDEventsTest {

    private static String CUSTOM_SPEC_FOLDER = CDEventConstants.SPEC_REPO + File.separator + "custom";
    private static final ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createCustomTypeEventAsCloudEvent() {

        CustomTypeEvent cdEvent =  new CustomTypeEvent();
        // define event type in the format dev.cdeventsx.<tool-name>-<subject-name>.<predicate-name>.<major.minor.patch>
        cdEvent.setType("dev.cdeventsx.mytool-resource.created.0.1.0");

        cdEvent.setSource(URI.create("http://mytool.cdevents"));
        cdEvent.setSubjectId("pkg:custom/myapp@sha256%3A0b31b1c02f124rgt324ds");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectType("mytool-resource");

        //define a map with the context properties
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("user", "mybot-myapp");
        contentMap.put("description", "a useful resource");
        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("key", "value");
        nestedMap.put("list", Arrays.asList("data1", "data2"));
        contentMap.put("nested", nestedMap);
        cdEvent.setSubjectContentProperty(contentMap);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidCustomTypeEventWithNoSubject() {
        CustomTypeEvent cdEvent =  new CustomTypeEvent();
        cdEvent.setSource(URI.create("http://mytool.cdevents"));
        cdEvent.setType("dev.cdeventsx.mytool-resource.created.0.1.0");

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " +cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testCustomTypeEventFromJsonConformance() throws IOException {

        File customResourceCreatedExample = new File(CUSTOM_SPEC_FOLDER + File.separator + "conformance.json");
        JsonNode expectedNode = objectMapper.readTree(customResourceCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CustomTypeEvent expectedEvent = (CustomTypeEvent) CDEvents.cdEventFromJson(expectedJson);

        CustomTypeEvent createdEvent =  new CustomTypeEvent();
        // set the fields which are matching with the expectedEvent
        createdEvent.setType("dev.cdeventsx.mytool-resource.created.0.1.0");
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setContextSchemaUri(URI.create("https://myorg.com/schema/mytool"));
        createdEvent.setChainId("6ca3f9c5-1cef-4ce0-861c-2456a69cf137");
        createdEvent.setSubjectId("pkg:resource/name@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectType("mytool-resource");
        //define a map with the context properties
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("user", "mybot-myapp");
        contentMap.put("description", "a useful resource");
        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("key", "value");
        nestedMap.put("list", Arrays.asList("data1", "data2"));
        contentMap.put("nested", nestedMap);
        createdEvent.setSubjectContentProperty(contentMap);

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        // uncomment once Links are implemented for SDK
        // assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
}
