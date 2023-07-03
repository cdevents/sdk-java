package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.packageurl.MalformedPackageURLException;
import com.github.packageurl.PackageURL;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.*;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CDEventsTest {

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createPipelineRunFinishedEventAsCloudEvent() throws IOException {
        PipelinerunFinishedCDEvent cdEvent =  new PipelinerunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("Name-pipeline");
        cdEvent.setSubjectUrl("http://dev/pipeline/url");
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

        PipelinerunFinishedCDEvent cdEvent =  new PipelinerunFinishedCDEvent();
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
        PipelinerunFinishedCDEvent cdEvent =  new PipelinerunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();
        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createPipelineRunQueuedEventAsCloudEvent() {

        PipelinerunQueuedCDEvent cdEvent =  new PipelinerunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-queued");
        cdEvent.setSubjectUrl("http://dev/pipeline/url");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testInvalidPipelineRunQueuedEventWithNoSubject() {
        PipelinerunQueuedCDEvent cdEvent =  new PipelinerunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createPipelineRunQueuedEventWithOptionalFieldsUnset() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/pipelinerun_queued_optional.json");

        JsonNode expectedJsonNode = objectMapper.readTree(inputStream);
        JsonNode expectedContextNode = expectedJsonNode.get("context");
        JsonNode expectedSubjectNode = expectedJsonNode.get("subject");

        PipelinerunQueuedCDEvent cdEvent =  new PipelinerunQueuedCDEvent();
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

        //assert Optional field Subject Source, pipelineName, url is set to null
        assertThat(cdEventSubjectNode.get("source")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("pipelineName")).isEqualTo(null);
        assertThat(expectedSubjectNode.get("content").get("url")).isEqualTo(null);


    }

    @Test
    void testPipelineRunQueuedEventWithCustomData() throws JsonProcessingException {
        PipelinerunQueuedCDEvent cdEvent =  new PipelinerunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-queued");
        cdEvent.setSubjectUrl("http://dev/pipeline/url");

        String customDataJson = "{\"key1\": \"value1\",\"key2\" : {\"test\": \"customData\" }}";
        cdEvent.setCustomData(customDataJson);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createPipelineRunStartedEventAsCloudEvent() {

        PipelinerunStartedCDEvent cdEvent =  new PipelinerunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-started");
        cdEvent.setSubjectUrl("http://dev/pipeline/url");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testInvalidPipelineRunStartedEventWithNoSubject() {
        PipelinerunStartedCDEvent cdEvent =  new PipelinerunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createPipelineRunStartedJsonEventWithOptionalFieldsUnset() throws IOException {

        InputStream inputStream = getClass().getResourceAsStream("/pipelinerun_started_optional.json");

        JsonNode expectedJsonNode = objectMapper.readTree(inputStream);
        JsonNode expectedContextNode = expectedJsonNode.get("context");
        JsonNode expectedSubjectNode = expectedJsonNode.get("subject");

        PipelinerunStartedCDEvent cdEvent =  new PipelinerunStartedCDEvent();
        cdEvent.setSource(URI.create(expectedContextNode.get("source").asText()));

        cdEvent.setSubjectId(expectedSubjectNode.get("id").asText());
        cdEvent.setSubjectPipelineName(expectedSubjectNode.get("content").get("pipelineName").asText());
        cdEvent.setSubjectUrl(expectedSubjectNode.get("content").get("url").asText());

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
        assertThat(cdEventSubjectNode.get("content").get("pipelineName").asText()).isEqualTo(expectedSubjectNode.get("content").get("pipelineName").asText());
        assertThat(cdEventSubjectNode.get("content").get("url").asText()).isEqualTo(expectedSubjectNode.get("content").get("url").asText());

        //assert Optional field Subject Source is set to null
        assertThat(cdEventSubjectNode.get("source")).isEqualTo(null);

    }


    @Test
    void createTaskRunStartedEventAsCloudEvent() {

        TaskrunStartedCDEvent cdEvent =  new TaskrunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/task/run/subject"));
        cdEvent.setSubjectTaskName("test-task-started");
        cdEvent.setSubjectUrl("http://dev/task/url");
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");
        cdEvent.setSubjectPipelineRunSource("http://dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTaskRunStartedEventWithNoSubject() {
        TaskrunStartedCDEvent cdEvent =  new TaskrunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTaskRunStartedEventJsonWithOptionalFieldsUnset() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/taskrun_started_optional.json");

        JsonNode expectedJsonNode = objectMapper.readTree(inputStream);
        JsonNode expectedContextNode = expectedJsonNode.get("context");
        JsonNode expectedSubjectNode = expectedJsonNode.get("subject");

        TaskrunStartedCDEvent cdEvent =  new TaskrunStartedCDEvent();
        cdEvent.setSource(URI.create(expectedContextNode.get("source").asText()));

        cdEvent.setSubjectId(expectedSubjectNode.get("id").asText());
        cdEvent.setSubjectPipelineRunId(expectedSubjectNode.get("content").get("pipelineRun").get("id").asText());

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
        assertThat(cdEventSubjectNode.get("content").get("pipelineRun").get("id").asText()).isEqualTo(expectedSubjectNode.get("content").get("pipelineRun").get("id").asText());

        //assert Optional fields Subject Source, Content taskName, URL and pipelineRun Source are set to null
        assertThat(cdEventSubjectNode.get("source")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("taskName")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("url")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("pipelineRun").get("source")).isEqualTo(null);

    }

    @Test
    void createTaskRunFinishedEventAsCloudEvent() {

        TaskrunFinishedCDEvent cdEvent =  new TaskrunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/task/run/subject"));
        cdEvent.setSubjectTaskName("test-task-finished");
        cdEvent.setSubjectUrl("http://dev/task/url");
        cdEvent.setSubjectErrors("errors to place");
        cdEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS.getOutcome());
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");
        cdEvent.setSubjectPipelineRunSource("http://dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createTaskRunFinishedEventJsonWithOptionalFieldsUnset() throws IOException {

        InputStream inputStream = getClass().getResourceAsStream("/taskrun_finished_optional.json");

        JsonNode expectedJsonNode = objectMapper.readTree(inputStream);
        JsonNode expectedContextNode = expectedJsonNode.get("context");
        JsonNode expectedSubjectNode = expectedJsonNode.get("subject");

        TaskrunFinishedCDEvent cdEvent =  new TaskrunFinishedCDEvent();
        cdEvent.setSource(URI.create(expectedContextNode.get("source").asText()));
        cdEvent.setSubjectId(expectedSubjectNode.get("id").asText());
        cdEvent.setSubjectPipelineRunId(expectedSubjectNode.get("content").get("pipelineRun").get("id").asText());

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
        assertThat(cdEventSubjectNode.get("content").get("pipelineRun").get("id").asText()).isEqualTo(expectedSubjectNode.get("content").get("pipelineRun").get("id").asText());

        //assert Optional fields Subject Source, Content taskName, URL, outcome, errors and pipelineRun Source are set to null
        assertThat(cdEventSubjectNode.get("source")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("taskName")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("url")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("outcome")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("errors")).isEqualTo(null);
        assertThat(cdEventSubjectNode.get("content").get("pipelineRun").get("source")).isEqualTo(null);
    }

    @Test
    void testInvalidTaskRunFinishedEventWithNoSubject() {
        TaskrunFinishedCDEvent cdEvent =  new TaskrunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createRepositoryCreatedEventAsCloudEvent() {

        RepositoryCreatedCDEvent cdEvent =  new RepositoryCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/github.com/test-repo");
        cdEvent.setSubjectSource(URI.create("/github.com/test-repo"));
        cdEvent.setSubjectName("test-repo");
        cdEvent.setSubjectOwner("test-user");
        cdEvent.setSubjectUrl("git://github.com/test-org/test-repo");
        cdEvent.setSubjectViewUrl("http://github.com/test-org/test-repo/view");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidRepositoryCreatedEventWithNoSubject() {
        RepositoryCreatedCDEvent cdEvent =  new RepositoryCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createRepositoryModifiedEventAsCloudEvent() {

        RepositoryModifiedCDEvent cdEvent =  new RepositoryModifiedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/github.com/test-repo");
        cdEvent.setSubjectSource(URI.create("/github.com/test-repo"));
        cdEvent.setSubjectName("test-repo");
        cdEvent.setSubjectOwner("test-user");
        cdEvent.setSubjectUrl("git://github.com/test-org/test-repo");
        cdEvent.setSubjectViewUrl("http://github.com/test-org/test-repo/view");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidRepositoryModifiedEventWithNoSubject() {
        RepositoryModifiedCDEvent cdEvent =  new RepositoryModifiedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createRepositoryDeletedEventAsCloudEvent() {

        RepositoryDeletedCDEvent cdEvent =  new RepositoryDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/github.com/test-repo");
        cdEvent.setSubjectSource(URI.create("/github.com/test-repo"));
        cdEvent.setSubjectName("test-repo");
        cdEvent.setSubjectOwner("test-user");
        cdEvent.setSubjectUrl("git://github.com/test-org/test-repo");
        cdEvent.setSubjectViewUrl("http://github.com/test-org/test-repo/view");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidRepositoryDeletedEventWithNoSubject() {
        RepositoryDeletedCDEvent cdEvent =  new RepositoryDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createBranchCreatedEventAsCloudEvent() {

        BranchCreatedCDEvent cdEvent =  new BranchCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidBranchCreatedEventWithNoSubject() {
        BranchCreatedCDEvent cdEvent =  new BranchCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createBranchDeletedEventAsCloudEvent() {

        BranchDeletedCDEvent cdEvent =  new BranchDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidBranchDeletedEventWithNoSubject() {
        BranchDeletedCDEvent cdEvent =  new BranchDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createChangeCreatedEventAsCloudEvent() {

        ChangeCreatedCDEvent cdEvent =  new ChangeCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidChangeCreatedEventWithNoSubject() {
        ChangeCreatedCDEvent cdEvent =  new ChangeCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createChangeReviewedEventAsCloudEvent() {

        ChangeReviewedCDEvent cdEvent =  new ChangeReviewedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidChangeReviewedEventWithNoSubject() {
        ChangeReviewedCDEvent cdEvent =  new ChangeReviewedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createChangeMergedEventAsCloudEvent() {

        ChangeMergedCDEvent cdEvent =  new ChangeMergedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidChangeMergedEventWithNoSubject() {
        ChangeMergedCDEvent cdEvent =  new ChangeMergedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createChangeAbandonedEventAsCloudEvent() {

        ChangeAbandonedCDEvent cdEvent =  new ChangeAbandonedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidChangeAbandonedEventWithNoSubject() {
        ChangeAbandonedCDEvent cdEvent =  new ChangeAbandonedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
    @Test
    void createChangeUpdatedEventAsCloudEvent() {

        ChangeUpdatedCDEvent cdEvent =  new ChangeUpdatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-branch");
        cdEvent.setSubjectSource(URI.create("/github.com/test-branch"));
        cdEvent.setSubjectRepositoryId("/github.com/test-repo");
        cdEvent.setSubjectRepositorySource("http://github.com/test-repo");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidChangeUpdatedEventWithNoSubject() {
        ChangeUpdatedCDEvent cdEvent =  new ChangeUpdatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createBuildQueuedEventAsCloudEvent() {

        BuildQueuedCDEvent cdEvent =  new BuildQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-build");
        cdEvent.setSubjectSource(URI.create("/dev/builds/test-build"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidBuildQueuedEventWithNoSubject() {
        BuildQueuedCDEvent cdEvent =  new BuildQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createBuildStartedEventAsCloudEvent() {

        BuildStartedCDEvent cdEvent =  new BuildStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-build");
        cdEvent.setSubjectSource(URI.create("/dev/builds/test-build"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidBuildStartedEventWithNoSubject() {
        BuildStartedCDEvent cdEvent =  new BuildStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createBuildFinishedAsCloudEvent() throws MalformedPackageURLException {

        BuildFinishedCDEvent cdEvent =  new BuildFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-build");
        cdEvent.setSubjectSource(URI.create("/dev/builds/test-build"));
        cdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidBuildFinishedEventWithNoSubject() {
        BuildFinishedCDEvent cdEvent =  new BuildFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestCaseQueuedEventAsCloudEvent() {

        TestcaseQueuedCDEvent cdEvent =  new TestcaseQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseQueuedEventWithNoSubject() {
        TestcaseQueuedCDEvent cdEvent =  new TestcaseQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
    @Test
    void createTestCaseStartedEventAsCloudEvent() {

        TestcaseStartedCDEvent cdEvent =  new TestcaseStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseStartedEventWithNoSubject() {
        TestcaseStartedCDEvent cdEvent =  new TestcaseStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestCaseFinishedEventAsCloudEvent() {

        TestcaseFinishedCDEvent cdEvent =  new TestcaseFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseFinishedEventWithNoSubject() {
        TestcaseFinishedCDEvent cdEvent =  new TestcaseFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestSuiteStartedEventAsCloudEvent() {

        TestsuiteStartedCDEvent cdEvent =  new TestsuiteStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-suite-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-suite"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestSuiteStartedEventWithNoSubject() {
        TestsuiteStartedCDEvent cdEvent =  new TestsuiteStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestSuiteFinishedEventAsCloudEvent() {

        TestsuiteFinishedCDEvent cdEvent =  new TestsuiteFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-suite-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-suite"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestSuiteFinishedEventWithNoSubject() {
        TestsuiteFinishedCDEvent cdEvent =  new TestsuiteFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createArtifactPackagedEventAsCloudEvent() throws MalformedPackageURLException {

        ArtifactPackagedCDEvent cdEvent =  new ArtifactPackagedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        cdEvent.setSubjectChangeId("test-feature");
        cdEvent.setSubjectChangeSource("/github.com/test-repo");

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
    void createArtifactPublishedEventAsCloudEvent() throws MalformedPackageURLException {
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

    @Test
    void createEnvironmentCreatedEventAsCloudEvent() {
        EnvironmentCreatedCDEvent cdEvent = new EnvironmentCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/environment/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/environment/run/subject"));
        cdEvent.setSubjectName("Name");
        cdEvent.setSubjectUrl("http://dev/environment/url");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidEnvironmentCreatedEventWithNoSubject() {
        EnvironmentCreatedCDEvent cdEvent = new EnvironmentCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createEnvironmentModifiedEventAsCloudEvent() {
        EnvironmentModifiedCDEvent cdEvent = new EnvironmentModifiedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/environment/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/environment/run/subject"));
        cdEvent.setSubjectName("Name");
        cdEvent.setSubjectUrl("http://dev/environment/url");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidEnvironmentModifiedEventWithNoSubject() {
        EnvironmentModifiedCDEvent cdEvent = new EnvironmentModifiedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createEnvironmentDeletedEventAsCloudEvent() {
        EnvironmentDeletedCDEvent cdEvent = new EnvironmentDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/environment/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/environment/run/subject"));
        cdEvent.setSubjectName("Name");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidEnvironmentDeletedEventWithNoSubject() {
        EnvironmentDeletedCDEvent cdEvent = new EnvironmentDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createServiceDeployedEventAsCloudEvent() throws MalformedPackageURLException {
        ServiceDeployedCDEvent cdEvent = new ServiceDeployedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource("dev/environment/run/subject");
        cdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServiceDeployedEventWithNoSubject() {
        ServiceDeployedCDEvent cdEvent = new ServiceDeployedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createServiceUpgradedEventAsCloudEvent() throws MalformedPackageURLException {
        ServiceUpgradedCDEvent cdEvent = new ServiceUpgradedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource("dev/environment/run/subject");
        cdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServiceUpgradedEventWithNoSubject() {
        ServiceUpgradedCDEvent cdEvent = new ServiceUpgradedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createServiceRolledBackEventAsCloudEvent() throws MalformedPackageURLException {
        ServiceRolledbackCDEvent cdEvent = new ServiceRolledbackCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource("dev/environment/run/subject");
        cdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServiceRolledBackEventWithNoSubject() {
        ServiceRolledbackCDEvent cdEvent = new ServiceRolledbackCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createServiceRemovedEventAsCloudEvent() {
        ServiceRemovedCDEvent cdEvent = new ServiceRemovedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource("dev/environment/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServiceRemovedEventWithNoSubject() {
        ServiceRemovedCDEvent cdEvent = new ServiceRemovedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createServicePublishedEventAsCloudEvent() {
        ServicePublishedCDEvent cdEvent = new ServicePublishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource("dev/environment/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServicePublishedEventWithNoSubject() {
        ServicePublishedCDEvent cdEvent = new ServicePublishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
}