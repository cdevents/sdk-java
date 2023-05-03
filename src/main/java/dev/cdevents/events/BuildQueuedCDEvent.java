package dev.cdevents.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.BuildQueuedSubject;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.PipelineRunFinishedSubject;

import java.net.URI;

public class BuildQueuedCDEvent extends CDEvent {

    private static final String CDEVENT_VERSION = "0.1.0";
    @JsonProperty(required = true)
    private BuildQueuedSubject subject;

    /**
     * Constructor to init CDEvent and set the Subject for {@link BuildQueuedCDEvent}.
     */
    public BuildQueuedCDEvent() {
        initCDEvent(currentCDEventType());
        setSubject(new BuildQueuedSubject(CDEventConstants.SubjectType.BUILD));
    }

    /**
     * @return subject
     */
    public BuildQueuedSubject getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(BuildQueuedSubject subject) {
        this.subject = subject;
    }

    /**
     * @return the current CDEvent type
     */
    @Override
    public String currentCDEventType() {
        return CDEventConstants.CDEventTypes.BuildQueuedEvent.getEventType().concat(CDEVENT_VERSION);
    }

    /**
     * @return the build-queued-event schema URL
     */
    @Override
    public String schemaURL() {
        return String.format("https://cdevents.dev/%s/schema/build-queued-event", CDEventConstants.CDEVENTS_SPEC_VERSION);
    }

    /**
     * @return the build-queued-event schema Json
     */
    @Override
    public String eventSchema() {
        return "{\n" +
                "  \"$schema\": \"https://json-schema.org/draft/2020-12/schema\",\n" +
                "  \"$id\": \"https://cdevents.dev/0.1.2/schema/build-queued-event\",\n" +
                "  \"properties\": {\n" +
                "    \"context\": {\n" +
                "      \"properties\": {\n" +
                "        \"version\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"minLength\": 1\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"minLength\": 1\n" +
                "        },\n" +
                "        \"source\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"minLength\": 1\n" +
                "        },\n" +
                "        \"type\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"enum\": [\n" +
                "            \"dev.cdevents.build.queued.0.1.0\"\n" +
                "          ],\n" +
                "          \"default\": \"dev.cdevents.build.queued.0.1.0\"\n" +
                "        },\n" +
                "        \"timestamp\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"format\": \"date-time\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"additionalProperties\": false,\n" +
                "      \"type\": \"object\",\n" +
                "      \"required\": [\n" +
                "        \"version\",\n" +
                "        \"id\",\n" +
                "        \"source\",\n" +
                "        \"type\",\n" +
                "        \"timestamp\"\n" +
                "      ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "      \"properties\": {\n" +
                "        \"id\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"minLength\": 1\n" +
                "        },\n" +
                "        \"source\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"type\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"minLength\": 1\n" +
                "        },\n" +
                "        \"content\": {\n" +
                "          \"properties\": {},\n" +
                "          \"additionalProperties\": false,\n" +
                "          \"type\": \"object\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"additionalProperties\": false,\n" +
                "      \"type\": \"object\",\n" +
                "      \"required\": [\n" +
                "        \"id\",\n" +
                "        \"type\",\n" +
                "        \"content\"\n" +
                "      ]\n" +
                "    },\n" +
                "    \"customData\": {\n" +
                "      \"oneOf\": [\n" +
                "        {\n" +
                "          \"type\": \"object\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"type\": \"string\",\n" +
                "          \"contentEncoding\": \"base64\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"customDataContentType\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"additionalProperties\": false,\n" +
                "  \"type\": \"object\",\n" +
                "  \"required\": [\n" +
                "    \"context\",\n" +
                "    \"subject\"\n" +
                "  ]\n" +
                "}";
    }

    /**
     * @param subjectId
     * sets the subject Id
     */
    public void setSubjectId(String subjectId) {
        getSubject().setId(subjectId);
    }

    /**
     * @param subjectSource
     * sets the subject source
     */
    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource);
    }

}
