package dev.cdevents;

import dev.cdevents.events.CustomTypeEvent;
import io.cloudevents.CloudEvent;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class QuotaExceededCustomEvent {

    @Test
    void testQuotaExceededCustomEvent() {

        CustomTypeEvent cdEvent = new CustomTypeEvent();
        // Set the event type in the format dev.cdeventsx.<tool-name>-<subject-name>.<predicate-name>.<major.minor.patch>
        cdEvent.setType("dev.cdeventsx.myregistry-quota.exceeded.0.1.0");

        // Set the required context fields
        cdEvent.setSource(URI.create("http://myregistry/region/staging"));
        cdEvent.setSubjectId("quotaRule123");

        // Set the subject type in the format <tool-name>-<subject-name>
        cdEvent.setSubjectType("myregistry-quota");

        //define a map with the content properties
        Map<String, Object> contentQuota = new HashMap<>();
        contentQuota.put("user", "heavy_user");
        contentQuota.put("limit", "50Tb");
        contentQuota.put("current", 90);
        contentQuota.put("threshold", 85);
        contentQuota.put("level", "WARNING");

        // Set the required subject content
        cdEvent.setSubjectContentProperty(contentQuota);

        // If we host a schema for the overall custom CDEvent, we can add it
        // to the event so that the receiver may validate custom fields like
        // the event type and subject content
        cdEvent.setContextSchemaUri(URI.create("https://myregistry.dev/schemas/cdevents/quota-exceeded/0_1_0"));

        // Create event as JSON to print
        String eventJson = CDEvents.cdEventAsJson(cdEvent);
        System.out.println(eventJson);

        // Create event as CloudEvent, validates event against official spec/custom/schema.json
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        // This ceEvent can be sent using HTTP Protocol Binding
        // Refer : https://cloudevents.github.io/sdk-java/http-basic.html

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(eventJson);

    }
}
