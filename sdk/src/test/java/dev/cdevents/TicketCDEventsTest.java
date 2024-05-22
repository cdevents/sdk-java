package dev.cdevents;

import dev.cdevents.events.*;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketCDEventsTest {

    @Test
    void createTicketClosedEventAsCloudEvent() {
        TicketClosedCDEvent cdEvent = new TicketClosedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectUri("https://example.issues.com/ticket123");
        cdEvent.setSubjectResolution("Resolved");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTicketClosedEventWithNoSubject() {
        TicketClosedCDEvent cdEvent =  new TicketClosedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();
        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTicketCreatedEventAsCloudEvent() {
        TicketCreatedCDEvent cdEvent = new TicketCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectUri("https://example.issues.com/ticket123");
        cdEvent.setSubjectSummary("New Ticket CVE-123 created");
        cdEvent.setSubjectCreator("Bob");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTicketCreatedEventWithNoSubject() {
        TicketCreatedCDEvent cdEvent =  new TicketCreatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();
        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void createTicketUpdatedEventAsCloudEvent() {
        TicketUpdatedCDEvent cdEvent = new TicketUpdatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("/dev/service/run/subject");
        cdEvent.setSubjectSource(URI.create("dev/service/run/subject"));
        cdEvent.setSubjectUri("https://example.issues.com/ticket123");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidTicketUpdatedEventWithNoSubject() {
        TicketUpdatedCDEvent cdEvent =  new TicketUpdatedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();
        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
}
