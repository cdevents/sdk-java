package dev.cdevents;

import dev.cdevents.process.ProcessSchemas;
import dev.cdevents.process.ProcessSchemasImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Adapts incoming schemas to a format that jsonschema2pojo.
 */
public final class PreprocessSchemas {

    private static Logger log = LoggerFactory.getLogger(PreprocessSchemas.class);
    private PreprocessSchemas() {
    }
    /**
     * Main method to update schema files.
     * @param args [0] - spec schemas directory for the cdevents-sdk-java.
     */
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            log.error("Usage: PreprocessSchemas <spec_schemas_directory_path>");
            throw new IllegalArgumentException("spec schemas directory path argument not passed to PreprocessSchemas");
        }
        String specSchemasDir = args[0];
        ProcessSchemas processSchemas = new ProcessSchemasImpl();
        processSchemas.updateSchemas(specSchemasDir);
        processSchemas.updateSchemas(specSchemasDir + "/../custom/schema.json");

        // copy links to the spec/custom folder for jsonschema2pojo to generate classes
        String targetDir = specSchemasDir + "/../custom/links/";
        createTargetDir(targetDir);
        try {
            Files.walk(Paths.get(specSchemasDir + "/links/"))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(path -> {
                        try {
                            log.info("copying {} to targetDir {} ", path, targetDir);
                            Files.copy(path, Paths.get(targetDir + path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            log.error("Exception occurred while copying links to  custom directory {}", e.getMessage());
                            throw new IllegalStateException("Exception occurred while copying links to  custom directory", e);
                        }
                    });
        } catch (IOException e) {
            log.error("Exception occurred while processing links directory {}", e.getMessage());
            throw new IllegalStateException("Exception occurred while processing links directory", e);
        }
    }

    private static void createTargetDir(String targetDir) {
        try {
            Files.createDirectory(Paths.get(targetDir));
        } catch (FileAlreadyExistsException e) {
            log.info("Ignore if the targetDir {} is already created ", targetDir);
        } catch (IOException e) {
            log.error("Exception occurred while creating {} directory", targetDir);
            throw new IllegalStateException("Exception occurred while processing links directory", e);
        }
    }
}
