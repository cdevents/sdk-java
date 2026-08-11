# Custom CDEvents
If a tool wants to emit events that are not supported by the CDEvents specification,
they can do so via [custom events](https://github.com/cdevents/spec/tree/main/custom).

Custom events follow the CDEvents format and can be defined via the
`CustomTypeEvent` class, available since v0.4.

Let's consider the following scenario: a tool called "MyRegistry" has a concept of "Quota"
which can be "exceeded" by users of the system. We want to use events to notify when that
happens, but CDEvents does not define any quota related subject.

## Steps involved to create a custom CDEvent

### Add SDK dependency to your project

```xml
<dependency>
  <groupId>dev.cdevents</groupId>
  <artifactId>cdevents-sdk-java</artifactId>
  <version>${cdevents.version}</version>
</dependency>
```
### Create a Custom CDEvent
In this example, we will create a custom event for our tool utilizing the new `CustomTypeEvent`

```java
public class QuotaExceededCustomEvent {

    public static void main(String[] args) {

        CustomTypeEvent cdEvent = new CustomTypeEvent();
        // Set the event type in the format dev.cdeventsx.<tool-name>-<subject-name>.<predicate-name>.<major.minor.patch>
        cdEvent.setType("dev.cdeventsx.myregistry-quota.exceeded.0.1.0");

        // Set the required context fields
        cdEvent.setSource(URI.create("http://myregistry/region/staging"));
        cdEvent.setSubjectId("quotaRule123");

        // Set the subject type in the format <tool-name>-<subject-name>
        cdEvent.setSubjectType("myregistry-quota");

        // Define a map with the content properties
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

        // Create event as CloudEvent, this validates event against official spec/custom/schema.json
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);
        // This ceEvent can be sent using HTTP Protocol Binding
        // Refer : https://cloudevents.github.io/sdk-java/http-basic.html
    }
}

```
The resulting CDEvents JSON will look like:

````json
{"context":{"version":"0.4.1","id":"587b646c-5dd5-4347-aa70-7a624a05120c","source":"http://myregistry/region/staging","type":"dev.cdeventsx.myregistry-quota.exceeded.0.1.0","timestamp":"2024-07-16T16:00:28Z","schemaUri":"https://myregistry.dev/schemas/cdevents/quota-exceeded/0_1_0","links":[]},"subject":{"id":"quotaRule123","type":"myregistry-quota","content":{"current":90,"level":"WARNING","limit":"50Tb","threshold":85,"user":"heavy_user"}},"customData":{},"customDataContentType":"application/json"}

````

The test code is available at [QuotaExceededCustomEvent.java](../sdk/src/test/java/dev/cdevents/QuotaExceededCustomEvent.java)