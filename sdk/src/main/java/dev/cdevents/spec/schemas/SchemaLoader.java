package dev.cdevents.spec.schemas;

import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.exception.CDEventsException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The purpose of this class is to serve as a resource anchor for loading event schemas.
 */
public final class SchemaLoader {
    private SchemaLoader() {

    }

    /**
     * Loads a schema file.
     * First, it tries to load the schema s a classpath resource,
     * falling back to filesystem access.
     *
     * @param schema the name of the schema file
     * @return schema contents
     */
    public static String loadSchema(String schema) {
        try {
            // load schema from classpath first
            InputStream inputStream = SchemaLoader.class.getClassLoader()
                .getResourceAsStream("dev/cdevents/spec/schemas/" + schema);
            if (null != inputStream) {
                return new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            }

            // load from filesystem next
            try (Stream<String> lines = Files.lines(Paths.get(CDEventConstants.SCHEMA_FOLDER + "/" + schema))) {
                return lines.collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            throw new CDEventsException("Exception while reading Event JsonSchema file ", e);
        }
    }
}
