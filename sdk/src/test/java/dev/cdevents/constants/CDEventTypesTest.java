package dev.cdevents.constants;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.constants.CDEventConstants.CDEventTypes;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CDEventTypesTest {
	@Test
	void eventTypeNamesAreUnique() {
		assertThat(CDEventTypes.values()).extracting(CDEventTypes::getEventType).doesNotHaveDuplicates();
	}

	@Test
	void eventTypesMatchesWithSchemaContextTypes() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File folder = new File(CDEventConstants.SCHEMA_FOLDER);
		List<String> eventTypeList = new ArrayList<>();
		if (folder.isDirectory()) {
			File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
			if (files != null) {
				for (File file : files) {
					JsonNode rootNode = objectMapper.readTree(file);
					JsonNode contextNode = rootNode.get("properties").get("context").get("properties");
					String eventType = contextNode.get("type").get("enum").get(0).asText();
					eventTypeList.add(eventType.split("\\d+\\.\\d+\\.\\d+")[0]);
				}
			}
		}
		// adding custom event type explicitly to the list
		eventTypeList.add(CDEventConstants.CUSTOM_EVENT_PREFIX);
		assertThat(CDEventTypes.values()).extracting(CDEventTypes::getEventType).hasSameElementsAs(eventTypeList);
	}
}