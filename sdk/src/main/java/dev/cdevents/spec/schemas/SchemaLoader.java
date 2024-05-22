package dev.cdevents.spec.schemas;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import dev.cdevents.CDEvents;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.exception.CDEventsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The purpose of this class is to serve as a resource anchor for loading event schemas.
 */
public final class SchemaLoader {
    private static Logger log = LoggerFactory.getLogger(SchemaLoader.class);

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
        StringBuilder stringBuilder = new StringBuilder();
        String eventSchema = loadSchema(schema, "dev/cdevents/spec/schemas/", CDEventConstants.SCHEMA_FOLDER);
        stringBuilder.append(eventSchema);
        stringBuilder.append(System.lineSeparator());

        /*String embeddedLinksArray = loadSchema("embeddedlinksarray.json", "dev/cdevents/spec/schemas/links/", CDEventConstants.SCHEMA_LINKS_FOLDER);
        stringBuilder.append(embeddedLinksArray);
        stringBuilder.append(System.lineSeparator());

        String embeddedLinkEnd = loadSchema("embeddedlinkend.json", "dev/cdevents/spec/schemas/links/", CDEventConstants.SCHEMA_LINKS_FOLDER);
        stringBuilder.append(embeddedLinkEnd);
        stringBuilder.append(System.lineSeparator());

        String embeddedLinkPath = loadSchema("embeddedlinkpath.json", "dev/cdevents/spec/schemas/links/", CDEventConstants.SCHEMA_LINKS_FOLDER);
        stringBuilder.append(embeddedLinkPath);
        stringBuilder.append(System.lineSeparator());

        String embeddedLinkRelation = loadSchema("embeddedlinkrelation.json", "dev/cdevents/spec/schemas/links/", CDEventConstants.SCHEMA_LINKS_FOLDER);
        stringBuilder.append(embeddedLinkRelation);
        stringBuilder.append(System.lineSeparator());*/

        return stringBuilder.toString();
    }

    private static String loadSchema(String schema, String classPath, String fileSystemPath){
        try {
            // load schema from classpath first
            InputStream inputStream = SchemaLoader.class.getClassLoader()
                    .getResourceAsStream(classPath + schema);
            if (null != inputStream) {
                log.info("loadSchema from classPath -> " +classPath);
                return new BufferedReader(new InputStreamReader(inputStream))
                        .lines().collect(Collectors.joining("\n"));
            }

            // load from filesystem next
            try (Stream<String> lines = Files.lines(Paths.get(fileSystemPath + "/" + schema))) {
                log.info("loadSchema from fileSystemPath -> " +fileSystemPath);
                return lines.collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            throw new CDEventsException("Exception while reading Event JsonSchema file ", e);
        }
    }
}

