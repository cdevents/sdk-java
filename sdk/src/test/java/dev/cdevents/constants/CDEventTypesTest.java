package dev.cdevents.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import dev.cdevents.constants.CDEventConstants.CDEventTypes;

public class CDEventTypesTest {
	@Test
	void eventTypeNamesAreUnique() {
		assertThat(CDEventTypes.values()).extracting(CDEventTypes::getEventType).doesNotHaveDuplicates();
	}
}