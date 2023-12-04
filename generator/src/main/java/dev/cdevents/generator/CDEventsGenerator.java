package dev.cdevents.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CDEventsGenerator {

    private CDEventsGenerator() {
    }

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(CDEventsGenerator.class);

    private static final int SUBJECT_INDEX = 2;
    private static final int PREDICATE_INDEX = 3;
    private static final int VERSION_INDEX = 4;
    private static final int SUBSTRING_PIPELINE_INDEX = 8;

    private static final String TARGET_PACKAGE = "src/main/java/dev/cdevents/events";

    /**
     * Event JsonSchema files location.
     */
    private static final String RESOURCES_DIR = "src/main/resources/";
    /**
     * Mustache generic event template file.
     */
    private static final String EVENT_TEMPLATE_MUSTACHE = RESOURCES_DIR + "template/event-template.mustache";

    /**
     * Main method to generate CDEvents from Json schema files.
     * @param args [0] - base directory for the cdevents-java-sdk-generator module
     *             [1] - base directory for the cdevents-java-sdk module
     */
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Insufficient arguments passed to CDEventsGenerator");
        }
        String generatorBaseDir = args[0];
        String sdkBaseDir = args[1];
        String parentBaseDir = args[2];
        String targetPackageDir = sdkBaseDir + File.separator + "src/main/java/dev/cdevents/events";
        File folder = new File(parentBaseDir + File.separator + "spec" + File.separator + "schemas");
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
            if (files != null) {
                //Create Mustache factory and compile event-template.mustache template
                MustacheFactory mf = new DefaultMustacheFactory();
                Mustache mustache = mf.compile(generatorBaseDir + File.separator + EVENT_TEMPLATE_MUSTACHE);

                //Generate a class file for each Json schema file using a mustache template

                for (File file : files) {
                    SchemaData schemaData = buildCDEventDataFromJsonSchema(file);
                    generateClassFileFromSchemaData(mustache, schemaData, targetPackageDir);
                }
            } else {
                log.error("No schema files found in the specified directory {}", folder.getAbsolutePath());
            }
        } else {
            log.error("No schema directory found in the specified directory {}", folder.getAbsolutePath());
        }
    }

    private static void generateClassFileFromSchemaData(Mustache mustache, SchemaData schemaData, String targetPackageDir) {
        String classFileName = StringUtils.join(new String[]{schemaData.getCapitalizedSubject(), schemaData.getCapitalizedPredicate(), "CDEvent", ".java"});
        File classFile = new File(targetPackageDir, classFileName);
        try {
            FileWriter fileWriter = new FileWriter(classFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            mustache.execute(bufferedWriter, schemaData).flush();
            fileWriter.close();
        } catch (IOException e) {
            log.error("Exception occurred while generating class file from Json schema {}", e.getMessage());
            throw new IllegalStateException("Exception occurred while generating class file from Json schema ", e);
        }
        log.info("Rendered event-template has been written to file - {}", classFile.getAbsolutePath());
    }

    private static SchemaData buildCDEventDataFromJsonSchema(File file) {
        SchemaData schemaData = new SchemaData();

        log.info("Processing event JsonSchema file: {}", file.getAbsolutePath());
        try {
            JsonNode rootNode = objectMapper.readTree(file);
            JsonNode contextNode = rootNode.get("properties").get("context").get("properties");
            JsonNode subjectNode = rootNode.get("properties").get("subject").get("properties");
            String schemaURL = rootNode.get("$id").asText();

            String subjectType = subjectNode.get("type").get("enum").get(0).asText();
            String eventType = contextNode.get("type").get("enum").get(0).asText();
            log.info("eventType: {} subjectType: {}", eventType, subjectType);
            String[] type = eventType.split("\\.");
            String subject = type[SUBJECT_INDEX];
            String predicate = type[PREDICATE_INDEX];
            String capitalizedSubject = StringUtils.capitalize(subject);
            String capitalizedPredicate = StringUtils.capitalize(predicate);
            String version = type[VERSION_INDEX];

            String upperCaseSubject = getUpperCaseSubjectType(subjectType);
            //set the Schema JsonNode required values to schemaData
            schemaData.setSchemaURL(schemaURL);
            schemaData.setSubject(subject);
            schemaData.setPredicate(predicate);
            schemaData.setCapitalizedSubject(capitalizedSubject);
            schemaData.setCapitalizedPredicate(capitalizedPredicate);
            schemaData.setSchemaFileName(file.getName());
            schemaData.setUpperCaseSubject(upperCaseSubject);
            schemaData.setVersion(version);

            JsonNode subjectContentNode = subjectNode.get("content").get("properties");
            updateSubjectContentProperties(schemaData, subjectContentNode);
        } catch (IOException e) {
            log.error("Exception occurred while building schema data from Json schema {}", e.getMessage());
            throw new IllegalStateException("Exception occurred while building schema data from Json schema ", e);
        }
        return schemaData;
    }

    private static String getUpperCaseSubjectType(String subjectType) {
        StringBuilder sb = new StringBuilder();
        subjectType.chars().forEachOrdered(c -> {
            char currentChar = (char) c;
            if (Character.isUpperCase(currentChar)) {
                sb.append('_');
            }
            sb.append(currentChar);
        });
        return sb.toString().toUpperCase();
    }

    private static void updateSubjectContentProperties(SchemaData schemaData, JsonNode subjectContentNode) {
        Iterator<Map.Entry<String, JsonNode>> contentProps = subjectContentNode.fields();
        List<SchemaData.ContentField> contentFields = new ArrayList<>();
        List<SchemaData.ContentObjectField> contentObjectFields = new ArrayList<>();
        List<SchemaData.ContentObject> contentObjects = new ArrayList<>();
        while (contentProps.hasNext()) {
            Map.Entry<String, JsonNode> contentMap = contentProps.next();
            String contentField = contentMap.getKey();
            String capitalizedContentField = StringUtils.capitalize(contentField);
            JsonNode contentNode = contentMap.getValue();
            String dataType = "";
            if (!contentNode.get("type").asText().equals("object")) {
                if (contentNode.get("format") != null && contentNode.get("format").asText().equalsIgnoreCase("uri")) {
                    dataType = "URI";
                } else if (contentNode.get("enum") != null) {
                    dataType = "Content." + capitalizedContentField;
                } else {
                  dataType = "String";
                }
                contentFields.add(new SchemaData.ContentField(contentField, capitalizedContentField, dataType));
            } else {
                contentObjects.add(new SchemaData.ContentObject(capitalizedContentField));
                JsonNode contentObjectNode = contentNode.get("properties");
                Iterator<String> contentObjectProps = contentObjectNode.fieldNames();
                while (contentObjectProps.hasNext()) {

                    String contentObjField = contentObjectProps.next();
                    String capitalizedContentObjField = StringUtils.capitalize(contentObjField);
                    JsonNode fieldNode = contentObjectNode.get(contentObjField);
                    if (fieldNode.get("format") != null && fieldNode.get("format").asText().equalsIgnoreCase("uri")) {
                        dataType = "URI";
                    } else if (fieldNode.get("enum") != null) {
                        dataType = capitalizedContentField + "." + capitalizedContentObjField;
                    } else {
                        dataType = "String";
                    }

                    contentObjectFields.add(new SchemaData.ContentObjectField(contentObjField,
                            capitalizedContentObjField, contentField, capitalizedContentField, dataType));
                }
            }
        }
        schemaData.setContentFields(contentFields);
        schemaData.setContentObjects(contentObjects);
        schemaData.setContentObjectFields(contentObjectFields);
    }

    private static String getFieldsDataType(String fieldName) {
        if (fieldName.equalsIgnoreCase("url")) {
            return "URI";
        } else {
            return "String";
        }
    }
}
