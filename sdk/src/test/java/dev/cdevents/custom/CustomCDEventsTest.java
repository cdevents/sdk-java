package dev.cdevents.custom;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.CDEvents;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.custom.resource.Context;
import dev.cdevents.custom.resource.CustomResourceCDEvent;
import dev.cdevents.custom.resource.Subject;
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

public class CustomCDEventsTest {

    private static String CUSTOM_SPEC_FOLDER = CDEventConstants.SPEC_REPO + File.separator + "custom";
    private static final ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createCustomResourceEventAsCloudEvent() {

        CustomResourceCDEvent cdEvent =  new CustomResourceCDEvent();
        cdEvent.setSource(URI.create("http://mytool.cdevents"));

        cdEvent.setSubjectId("pkg:custom/myapp@sha256%3A0b31b1c02f124rgt324ds");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectUser("testUser");
        cdEvent.setSubjectNestedKey("customKey");
        cdEvent.setSubjectNestedList(Arrays.asList("val1", "val2"));

        cdEvent.setCustomSchemaUri(new File("src/test/resources/customresourcecreated.json").toURI());

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.customCDEventAsCloudEvent(cdEvent, true);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testCustomResourceEventWithNoSchemaURI() {
        CustomResourceCDEvent cdEvent =  new CustomResourceCDEvent();
        cdEvent.setSource(URI.create("http://mytool.cdevents"));
        cdEvent.setSubjectId("pkg:custom/myapp@sha256%3A0b31b1c02f124rgt324ds");

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.customCDEventAsCloudEvent(cdEvent, true);
        });
        String expectedError = "Context schemaUri does not exist.";

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidCustomResourceEventWithNoSubject() {
        CustomResourceCDEvent cdEvent =  new CustomResourceCDEvent();
        cdEvent.setSource(URI.create("http://mytool.cdevents"));
        cdEvent.setCustomSchemaUri(new File("src/test/resources/customresourcecreated.json").toURI());

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.customCDEventAsCloudEvent(cdEvent, false);
        });
        String expectedError = "Custom CDEvent validation failed.";

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testCustomResourceEventFromJsonConformance() throws IOException {

        // Use spec/custom/conformance.json to test once Links are implemented for SDK
        //File customResourceCreatedExample = new File(CUSTOM_SPEC_FOLDER + "conformance.json");
        File customResourceCreatedExample = new File("src/test/resources/custom_resourcecreated_cdevent.json");
        JsonNode expectedNode = objectMapper.readTree(customResourceCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CustomResourceCDEvent expectedEvent = CDEvents.customCDEventFromJson(expectedJson, CustomResourceCDEvent.class, false);
        // set the type which is matching with the createdEvent
        expectedEvent.getContext().setType(Context.Type.DEV_CDEVENTSX_CUSTOM_RESOURCE_CREATED_0_1_0);
        expectedEvent.getSubject().setType(Subject.Type.ARTIFACT);

        CustomResourceCDEvent createdEvent =  new CustomResourceCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setCustomSchemaUri(URI.create("https://myorg.com/schema/mytool"));
        createdEvent.setChainId("6ca3f9c5-1cef-4ce0-861c-2456a69cf137");
        createdEvent.setSubjectId("pkg:resource/name@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectUser("mybot-myapp");
        createdEvent.setSubjectDescription("a useful resource");
        createdEvent.setSubjectNestedKey("value");
        createdEvent.setSubjectNestedList(Arrays.asList("data1", "data2"));

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
}
