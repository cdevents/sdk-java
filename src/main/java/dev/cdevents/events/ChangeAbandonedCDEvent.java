package dev.cdevents.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.ChangeSubject;

import java.net.URI;

public class ChangeAbandonedCDEvent extends CDEvent {

    private static final String CDEVENT_VERSION = "0.1.1";
    @JsonProperty(required = true)
    private ChangeSubject subject;

    /**
     * Constructor to init CDEvent and set the Subject for {@link ChangeAbandonedCDEvent}.
     */
    public ChangeAbandonedCDEvent() {
        initCDEvent(currentCDEventType());
        setSubject(new ChangeSubject(CDEventConstants.SubjectType.CHANGE));
    }

    /**
     * @return subject
     */
    public ChangeSubject getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(ChangeSubject subject) {
        this.subject = subject;
    }

    /**
     * @return the current CDEvent type
     */
    @Override
    public String currentCDEventType() {
        return CDEventConstants.CDEventTypes.ChangeAbandonedEvent.getEventType().concat(CDEVENT_VERSION);
    }

    /**
     * @return the change-abandoned-event schema URL
     */
    @Override
    public String schemaURL() {
        return String.format("https://cdevents.dev/%s/schema/change-abandoned-event", CDEventConstants.CDEVENTS_SPEC_VERSION);
    }

    /**
     * @return the change-abandoned-event schema Json
     */
    @Override
    public String eventSchema() {
        return "{\n" +
                "  \"$schema\": \"https://json-schema.org/draft/2020-12/schema\",\n" +
                "  \"$id\": \"https://cdevents.dev/0.1.2/schema/change-abandoned-event\",\n" +
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
                "            \"dev.cdevents.change.abandoned.0.1.1\"\n" +
                "          ],\n" +
                "          \"default\": \"dev.cdevents.change.abandoned.0.1.1\"\n" +
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
                "          \"properties\": {\n" +
                "            \"repository\": {\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\",\n" +
                "                  \"minLength\": 1\n" +
                "                },\n" +
                "                \"source\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"additionalProperties\": false,\n" +
                "              \"type\": \"object\",\n" +
                "              \"required\": [\n" +
                "                \"id\"\n" +
                "              ]\n" +
                "            }\n" +
                "          },\n" +
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
     * sets the change branch source
     */
    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource);
    }

    /**
     * @param repositoryId
     * sets the id of the repository
     */
    public void setSubjectRepositoryId(String repositoryId) {
        getSubject().getContent().getRepository().setId(repositoryId);
    }

    /**
     * @param repositorySource
     * sets the source of the repository.
     */
    public void setSubjectRepositorySource(URI repositorySource) {
        getSubject().getContent().getRepository().setSource(repositorySource);
    }
}
