package dev.cdevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.PipelineRunFinishedCDEvent;
import dev.cdevents.events.PipelineRunQueuedCDEvent;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CDEventsTest {

    @Test
    void createPipelineRunFinishedEventAsCloudEvent() {

        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("http://dev/pipeline/run/subject"));
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
        cdEvent.setSubjectSource(URI.create("http://dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-name");
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
    void testPipelineRunQueuedEventWithCustomData() throws JsonProcessingException {
        PipelineRunQueuedCDEvent cdEvent =  new PipelineRunQueuedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("http://dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("test-pipeline-name");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));

        String customDataJson ="{\"key1\": \"value1\",\"key2\" : {\"test\": \"customData\" }}";
        cdEvent.setCustomData(customDataJson);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

}
