package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CDEventsTest {

    private static ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createPipelineRunFinishedEventAsCloudEvent() throws IOException {
        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("Name-pipeline");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));
        cdEvent.setSubjectErrors("errors to place");
        cdEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void createPipelineRunFinishedEventOptionalFieldsUnset() throws IOException {

        InputStream inputStream = getClass().getResourceAsStream("/pipelinerun_finished_optional.json");
        PipelineRunFinishedCDEvent expectedCDEvent = objectMapper.readValue(inputStream, PipelineRunFinishedCDEvent.class);

        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        //assert cdEvent with the expected optional test data
        assertThat(cdEvent.getContext().getType()).isEqualTo(expectedCDEvent.getContext().getType());
        assertThat(cdEvent.getContext().getSource()).isEqualTo(expectedCDEvent.getContext().getSource());
        assertTrue(cdEvent.getSubject().equals(expectedCDEvent.getSubject()));
        assertTrue(cdEvent.getSubject().getContent().equals(expectedCDEvent.getSubject().getContent()));

        //assert cdEvent with the CloudEvent binding
        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

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
    void createPipelineRunQueuedEventAsCloudEvent() {

        PipelineRunQueuedCDEvent cdEvent =  new PipelineRunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-queued");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testInvalidPipelineRunQueuedEventWithNoSubject() {
        PipelineRunQueuedCDEvent cdEvent =  new PipelineRunQueuedCDEvent();
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
        PipelineRunQueuedCDEvent expectedCDEvent = objectMapper.readValue(inputStream, PipelineRunQueuedCDEvent.class);

        PipelineRunQueuedCDEvent cdEvent =  new PipelineRunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        //assert cdEvent with the expected optional test data
        assertThat(cdEvent.getContext().getType()).isEqualTo(expectedCDEvent.getContext().getType());
        assertThat(cdEvent.getContext().getSource()).isEqualTo(expectedCDEvent.getContext().getSource());
        assertTrue(cdEvent.getSubject().equals(expectedCDEvent.getSubject()));
        assertTrue(cdEvent.getSubject().getContent().equals(expectedCDEvent.getSubject().getContent()));

        //assert cdEvent with the CloudEvent binding
        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testPipelineRunQueuedEventWithCustomData() throws JsonProcessingException {
        PipelineRunQueuedCDEvent cdEvent =  new PipelineRunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-queued");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));

        String customDataJson = "{\"key1\": \"value1\",\"key2\" : {\"test\": \"customData\" }}";
        cdEvent.setCustomData(customDataJson);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createPipelineRunStartedEventAsCloudEvent() {

        PipelineRunStartedCDEvent cdEvent =  new PipelineRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-started");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void testInvalidPipelineRunStartedEventWithNoSubject() {
        PipelineRunStartedCDEvent cdEvent =  new PipelineRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createPipelineRunStartedEventWithOptionalFieldsUnset() throws IOException {

        InputStream inputStream = getClass().getResourceAsStream("/pipelinerun_started_optional.json");
        PipelineRunStartedCDEvent expectedCDEvent = objectMapper.readValue(inputStream, PipelineRunStartedCDEvent.class);

        PipelineRunStartedCDEvent cdEvent =  new PipelineRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectPipelineName("test-pipeline-started");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        //assert cdEvent with the expected optional test data
        assertThat(cdEvent.getContext().getType()).isEqualTo(expectedCDEvent.getContext().getType());
        assertThat(cdEvent.getContext().getSource()).isEqualTo(expectedCDEvent.getContext().getSource());
        assertTrue(cdEvent.getSubject().equals(expectedCDEvent.getSubject()));
        assertTrue(cdEvent.getSubject().getContent().equals(expectedCDEvent.getSubject().getContent()));

        //assert cdEvent with the CloudEvent binding
        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }


    @Test
    void createTaskRunStartedEventAsCloudEvent() {

        TaskRunStartedCDEvent cdEvent =  new TaskRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/task/run/subject"));
        cdEvent.setSubjectTaskName("test-task-started");
        cdEvent.setSubjectUrl(URI.create("http://dev/task/url"));
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");
        cdEvent.setSubjectPipelineRunSource(URI.create("http://dev/pipeline/run/subject"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTaskRunStartedEventWithNoSubject() {
        TaskRunStartedCDEvent cdEvent =  new TaskRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTaskRunStartedEventWithOptionalFieldsUnset() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/taskrun_started_optional.json");
        TaskRunStartedCDEvent expectedCDEvent = objectMapper.readValue(inputStream, TaskRunStartedCDEvent.class);

        TaskRunStartedCDEvent cdEvent =  new TaskRunStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        //assert cdEvent with the expected optional test data
        assertThat(cdEvent.getContext().getType()).isEqualTo(expectedCDEvent.getContext().getType());
        assertThat(cdEvent.getContext().getSource()).isEqualTo(expectedCDEvent.getContext().getSource());
        assertTrue(cdEvent.getSubject().equals(expectedCDEvent.getSubject()));
        assertTrue(cdEvent.getSubject().getContent().equals(expectedCDEvent.getSubject().getContent()));

        //assert cdEvent with the CloudEvent binding
        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createTaskRunFinishedEventAsCloudEvent() {

        TaskRunFinishedCDEvent cdEvent =  new TaskRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/task/run/subject"));
        cdEvent.setSubjectTaskName("test-task-finished");
        cdEvent.setSubjectUrl(URI.create("http://dev/task/url"));
        cdEvent.setSubjectErrors("errors to place");
        cdEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS);
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");
        cdEvent.setSubjectPipelineRunSource(URI.create("http://dev/pipeline/run/subject"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createTaskRunFinishedEventWithOptionalFieldsUnset() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/taskrun_finished_optional.json");
        TaskRunFinishedCDEvent expectedCDEvent = objectMapper.readValue(inputStream, TaskRunFinishedCDEvent.class);

        TaskRunFinishedCDEvent cdEvent =  new TaskRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/task/run/subject");
        cdEvent.setSubjectPipelineRunId("/dev/pipeline/run/subject");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        //assert cdEvent with the expected optional test data
        assertThat(cdEvent.getContext().getType()).isEqualTo(expectedCDEvent.getContext().getType());
        assertThat(cdEvent.getContext().getSource()).isEqualTo(expectedCDEvent.getContext().getSource());
        assertTrue(cdEvent.getSubject().equals(expectedCDEvent.getSubject()));
        assertTrue(cdEvent.getSubject().getContent().equals(expectedCDEvent.getSubject().getContent()));

        //assert cdEvent with the CloudEvent binding
        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTaskRunFinishedEventWithNoSubject() {
        TaskRunFinishedCDEvent cdEvent =  new TaskRunFinishedCDEvent();
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
        cdEvent.setSubjectUrl(URI.create("git://github.com/test-org/test-repo"));
        cdEvent.setSubjectViewUrl(URI.create("http://github.com/test-org/test-repo/view"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectUrl(URI.create("git://github.com/test-org/test-repo"));
        cdEvent.setSubjectViewUrl(URI.create("http://github.com/test-org/test-repo/view"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectUrl(URI.create("git://github.com/test-org/test-repo"));
        cdEvent.setSubjectViewUrl(URI.create("http://github.com/test-org/test-repo/view"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectRepositorySource(URI.create("http://github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectArtifactId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        TestCaseQueuedCDEvent cdEvent =  new TestCaseQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseQueuedEventWithNoSubject() {
        TestCaseQueuedCDEvent cdEvent =  new TestCaseQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
    @Test
    void createTestCaseStartedEventAsCloudEvent() {

        TestCaseStartedCDEvent cdEvent =  new TestCaseStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseStartedEventWithNoSubject() {
        TestCaseStartedCDEvent cdEvent =  new TestCaseStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestCaseFinishedEventAsCloudEvent() {

        TestCaseFinishedCDEvent cdEvent =  new TestCaseFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-case-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-case"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestCaseFinishedEventWithNoSubject() {
        TestCaseFinishedCDEvent cdEvent =  new TestCaseFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestSuiteStartedEventAsCloudEvent() {

        TestSuiteStartedCDEvent cdEvent =  new TestSuiteStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-suite-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-suite"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestSuiteStartedEventWithNoSubject() {
        TestSuiteStartedCDEvent cdEvent =  new TestSuiteStartedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTestSuiteFinishedEventAsCloudEvent() {

        TestSuiteFinishedCDEvent cdEvent =  new TestSuiteFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("test-suite-1");
        cdEvent.setSubjectSource(URI.create("/dev/test-suite"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTestSuiteFinishedEventWithNoSubject() {
        TestSuiteFinishedCDEvent cdEvent =  new TestSuiteFinishedCDEvent();
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

        cdEvent.setSubjectId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b"));
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        cdEvent.setSubjectChangeId("test-feature");
        cdEvent.setSubjectChangeSource(URI.create("/github.com/test-repo"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        cdEvent.setSubjectId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b"));
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectEnvironmentSource(URI.create("dev/environment/run/subject"));
        cdEvent.setSubjectArtifactId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectEnvironmentSource(URI.create("dev/environment/run/subject"));
        cdEvent.setSubjectArtifactId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        ServiceRolledBackCDEvent cdEvent = new ServiceRolledBackCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectEnvironmentId("dev/environment/run/subject");
        cdEvent.setSubjectEnvironmentSource(URI.create("dev/environment/run/subject"));
        cdEvent.setSubjectArtifactId(new PackageURL("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidServiceRolledBackEventWithNoSubject() {
        ServiceRolledBackCDEvent cdEvent = new ServiceRolledBackCDEvent();
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
        cdEvent.setSubjectEnvironmentSource(URI.create("dev/environment/run/subject"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
        cdEvent.setSubjectEnvironmentSource(URI.create("dev/environment/run/subject"));

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
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
