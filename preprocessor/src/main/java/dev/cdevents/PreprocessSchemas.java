package dev.cdevents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.cdevents.process.ProcessSchemas;
import dev.cdevents.process.ProcessSchemasImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Adapts incoming schemas to a format that jsonschema2pojo
 */
public final class PreprocessSchemas {

    private PreprocessSchemas() {
    }
    /**
     *
     * Main method to update schema files.
     * @param args [0] - spec schemas directory for the cdevents-sdk-java
     */
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("Usage: PreprocessSchemas <spec_schemas_directory_path>");
            throw new IllegalArgumentException("spec schemas directory path argument not passed to PreprocessSchemas");
        }
        String specSchemasDir = args[0];
        ProcessSchemas processSchemas = new ProcessSchemasImpl();
        processSchemas.updateSchemas(specSchemasDir);
    }
}
