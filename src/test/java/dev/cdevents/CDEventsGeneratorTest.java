package dev.cdevents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.generated.ArtifactPackagedCDEvent;
import dev.cdevents.events.generated.ArtifactPublishedCDEvent;
import dev.cdevents.events.generated.PipelineRunFinishedCDEvent;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CDEventsGeneratorTest {

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createPipelineRunFinishedEventAsCloudEvent() {
        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("Name-pipeline");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url").toString());
        cdEvent.setSubjectErrors("errors to place");
        cdEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS.getOutcome());

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void createPipelineRunFinishedEventOptionalFieldsUnset() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/pipelinerun_finished_optional.json");

        JsonNode expectedJsonNode = objectMapper.readTree(inputStream);
        JsonNode expectedContextNode = expectedJsonNode.get("context");
        JsonNode expectedSubjectNode = expectedJsonNode.get("subject");

        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create(expectedContextNode.get("source").asText()));
        cdEvent.setSubjectId(expectedSubjectNode.get("id").asText());

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);
        JsonNode cdEventJsonNode = objectMapper.readTree(cdEventJson);
        JsonNode cdEventContextNode = cdEventJsonNode.get("context");
        JsonNode cdEventSubjectNode = cdEventJsonNode.get("subject");

        //validates CDEvent against schema
        assertTrue(CDEvents.validateCDEvent(cdEvent));

        //assert context and subject mandatory fields
        assertThat(cdEventContextNode.get("type").asText()).isEqualTo(expectedContextNode.get("type").asText());
        assertThat(cdEventContextNode.get("source").asText()).isEqualTo(expectedContextNode.get("source").asText());
        assertEquals(expectedSubjectNode, cdEventSubjectNode);
        assertThat(cdEventSubjectNode.get("id").asText()).isEqualTo(expectedSubjectNode.get("id").asText());
        assertThat(cdEventSubjectNode.get("type").asText()).isEqualTo(expectedSubjectNode.get("type").asText());

        //assert Optional field Subject Source, Content pipelineName, url, outcome, errors are set to null
        assertThat(cdEventSubjectNode.get("source")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("pipelineName")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("url")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("outcome")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("errors")).isEqualTo(null);

    }

    @Test
    void testInvalidPipelineRunFinishedEventWithNoSubject() {
        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();
        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
    @Test
    void createArtifactPackagedEventAsCloudEvent() {

        ArtifactPackagedCDEvent cdEvent =  new ArtifactPackagedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        cdEvent.setSubjectChangeId("test-feature");
        cdEvent.setSubjectChangeSource(URI.create("/github.com/test-repo").toString());

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidArtifactPackagedEventWithNoSubject() {
        ArtifactPackagedCDEvent cdEvent =  new ArtifactPackagedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createArtifactPublishedEventAsCloudEvent() {
        ArtifactPublishedCDEvent cdEvent = new ArtifactPublishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testInvalidArtifactPublishedEventWithNoSubject() {
        ArtifactPublishedCDEvent cdEvent =  new ArtifactPublishedCDEvent();

        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
}
