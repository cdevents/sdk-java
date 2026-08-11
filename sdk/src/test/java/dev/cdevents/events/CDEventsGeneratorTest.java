package dev.cdevents.events;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CDEventsGeneratorTest {

    private static final int SUBJECT_INDEX = 2;
    private static final int PREDICATE_INDEX = 3;

    private static final String EVENTS_PACKAGE = "src/main/java/dev/cdevents/events";

    @Test
    void testCDEventClassGeneratedForEachSchemaFile() throws IOException {
        File eventsFolder = new File(EVENTS_PACKAGE);
        File[] eventFiles = eventsFolder.listFiles((dir, name) -> !name.equals("package-info.java") && name.endsWith(".java"));
        List<String> schemaClassFileList = getSchemaClassFileList();

        // adding custom event class explicitly to the list
        schemaClassFileList.add("CustomTypeEvent.java");

        assertThat(eventFiles).extracting(File::getName).hasSameElementsAs(schemaClassFileList);
        assertThat(eventFiles.length).isEqualTo(schemaClassFileList.size());
    }

    private List<String> getSchemaClassFileList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File schemaFolder = new File(CDEventConstants.SCHEMA_FOLDER);
        List<String> schemaClassFileList = new ArrayList<>();
        if (schemaFolder.isDirectory()) {
            File[] files = schemaFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
            if (files != null) {
                for (File file : files) {
                    JsonNode rootNode = objectMapper.readTree(file);
                    JsonNode contextNode = rootNode.get("properties").get("context").get("properties");
                    String eventType = contextNode.get("type").get("enum").get(0).asText();
                    String[] type = eventType.split("\\.");
                    String subject = type[SUBJECT_INDEX];
                    String predicate = type[PREDICATE_INDEX];
                    String capitalizedSubject = StringUtils.capitalize(subject);
                    String capitalizedPredicate = StringUtils.capitalize(predicate);
                    String classFileName = StringUtils.join(capitalizedSubject, capitalizedPredicate, "CDEvent", ".java");
                    schemaClassFileList.add(classFileName);
                }
            }
        }
        return schemaClassFileList;
    }
}
