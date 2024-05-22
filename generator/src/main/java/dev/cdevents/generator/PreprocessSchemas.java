package dev.cdevents.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PreprocessSchemas {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(PreprocessSchemas.class);

    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 1) {
            System.err.println("Usage: PreprocessSchemas <schema_directory_path>");
            throw new IllegalArgumentException("Schema directory path arguments not passed to PreprocessSchemas");
        }
        String parentBaseDir = args[0];
        String specSchemaDir = parentBaseDir + File.separator + "spec" + File.separator + "schemas";
        Files.walk(Paths.get(specSchemaDir))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".json"))
                .forEach(PreprocessSchemas::processFile);
    }

    private static void processFile(Path filePath) {
        log.info("processing schema file {} to update $ref path with json extension.", filePath.getFileName());
        try {
            JsonNode rootNode = objectMapper.readTree(filePath.toFile());
            updateRefs(rootNode);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(filePath.toFile(), rootNode);
        } catch (IOException e) {
            log.error("Exception occurred while process schema file to update ref {}", e.getMessage());
            throw new IllegalStateException("Exception occurred while process schema file to update ref ", e);
        }
    }

    private static void updateRefs(JsonNode node) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            Iterator<String> fieldNames = objectNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode childNode = objectNode.get(fieldName);
                if ("$ref".equals(fieldName) && !childNode.asText().endsWith(".json")) {
                    objectNode.put(fieldName, childNode.asText() + ".json");
                } else {
                    updateRefs(childNode);
                }
            }
        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                updateRefs(arrayItem);
            }
        }
    }
}
