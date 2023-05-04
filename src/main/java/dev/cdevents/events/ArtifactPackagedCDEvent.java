package dev.cdevents.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.packageurl.PackageURL;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.ArtifactPackagedSubject;
import dev.cdevents.models.CDEvent;

import java.net.URI;

public class ArtifactPackagedCDEvent extends CDEvent {

    private static final String CDEVENT_VERSION = "0.1.0";
    @JsonProperty(required = true)
    private ArtifactPackagedSubject subject;

    /**
     * Constructor to init CDEvent and set the Subject for {@link ArtifactPackagedCDEvent}.
     */
    public ArtifactPackagedCDEvent() {
        initCDEvent(currentCDEventType());
        setSubject(new ArtifactPackagedSubject(CDEventConstants.SubjectType.ARTIFACT));
    }

    /**
     * @return subject
     */
    public ArtifactPackagedSubject getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(ArtifactPackagedSubject subject) {
        this.subject = subject;
    }

    /**
     * @return the current CDEvent type
     */
    @Override
    public String currentCDEventType() {
        return CDEventConstants.CDEventTypes.ArtifactPackagedEvent.getEventType().concat(CDEVENT_VERSION);
    }

    /**
     * @return the artifact-packaged-event schema URL
     */
    @Override
    public String schemaURL() {
        return String.format("https://cdevents.dev/%s/schema/artifact-packaged-event", CDEventConstants.CDEVENTS_SPEC_VERSION);
    }

    /**
     * @return the artifact-packaged-event schema Json
     */
    @Override
    public String eventSchema() {
        return "{\n" +
                "  \"$schema\": \"https://json-schema.org/draft/2020-12/schema\",\n" +
                "  \"$id\": \"https://cdevents.dev/0.1.2/schema/artifact-packaged-event\",\n" +
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
                "            \"dev.cdevents.artifact.packaged.0.1.0\"\n" +
                "          ],\n" +
                "          \"default\": \"dev.cdevents.artifact.packaged.0.1.0\"\n" +
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
                "            \"change\": {\n" +
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
                "          \"type\": \"object\",\n" +
                "          \"required\": [\n" +
                "            \"change\"\n" +
                "          ]\n" +
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
     * sets the subject Id in the PURL format
     */
    public void setSubjectId(PackageURL subjectId) {
        getSubject().setId(subjectId.toString());
    }

    /**
     * @param subjectSource
     * sets the subject source
     */
    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource);
    }

    /**
     * @param changeId
     * sets The changeId that this artifact belongs to
     */
    public void setSubjectChangeId(String changeId) {
        getSubject().getContent().getChange().setId(changeId);

    }

    /**
     * @param changeSource
     * sets The changeSource that this artifact belongs to
     */
    public void setSubjectChangeSource(URI changeSource) {
        getSubject().getContent().getChange().setSource(changeSource);
    }

}
