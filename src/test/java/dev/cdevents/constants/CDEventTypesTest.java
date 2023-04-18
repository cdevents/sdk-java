package dev.cdevents.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import dev.cdevents.constants.CDEventConstants.CDEventTypes;

public class CDEventTypesTest {
	@Test
	void allEventTypeNamesMatchExpectedPattern() {
		assertThat(CDEventTypes.values()).extracting(CDEventTypes::getEventType)
				.allMatch(type -> type.matches("dev\\.cdevents\\.[a-z]+\\.[a-z]+\\.\\d+\\.\\d+\\.\\d+"));
	}
}
