package dev.cdevents.generator;

import java.util.List;

public class SchemaData {

    private String subject;
    private String predicate;

    private String capitalizedSubject;

    private String capitalizedPredicate;
    private String version;
    private String upperCaseSubject;
    private String schemaFileName;

    private String schemaURL;

    private String baseURI;

    private List<ContentField> contentFields;
    private List<ContentObjectField> contentObjectFields;
    private List<ContentObject> contentObjects;

    private boolean isCustomEvent;

    /**
     * Default constructor.
     */
    public SchemaData() {
    }

    /**
     * @return the subject of an event
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the predicate of an event
     */
    public String getPredicate() {
        return predicate;
    }

    /**
     * @param predicate
     */
    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    /**
     * @return the Capitalized Subject of an event
     */
    public String getCapitalizedSubject() {
        return capitalizedSubject;
    }

    /**
     * @param capitalizedSubject
     */
    public void setCapitalizedSubject(String capitalizedSubject) {
        this.capitalizedSubject = capitalizedSubject;
    }

    /**
     * @return the Capitalized predicate of an event
     */
    public String getCapitalizedPredicate() {
        return capitalizedPredicate;
    }

    /**
     * @param capitalizedPredicate
     */
    public void setCapitalizedPredicate(String capitalizedPredicate) {
        this.capitalizedPredicate = capitalizedPredicate;
    }
    /**
     * @return the version of an event
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the Uppercase Subject of an event
     */
    public String getUpperCaseSubject() {
        return upperCaseSubject;
    }

    /**
     * @param upperCaseSubject
     */
    public void setUpperCaseSubject(String upperCaseSubject) {
        this.upperCaseSubject = upperCaseSubject;
    }

    /**
     * @return the Schema file name of an event
     */
    public String getSchemaFileName() {
        return schemaFileName;
    }

    /**
     * @param schemaFileName
     */
    public void setSchemaFileName(String schemaFileName) {
        this.schemaFileName = schemaFileName;
    }

    /**
     * @return schemaURL
     */
    public String getSchemaURL() {
        return schemaURL;
    }

    /**
     * @param schemaURL
     */
    public void setSchemaURL(String schemaURL) {
        this.schemaURL = schemaURL;
    }

    /**
     *
     * @return baseURI
     */
    public String getBaseURI() {
        return baseURI;
    }

    /**
     *
     * @param baseURI
     */
    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    /**
     * @return the Content fields of an event
     */
    public List<ContentField> getContentFields() {
        return contentFields;
    }

    /**
     * @param contentFields
     */
    public void setContentFields(List<ContentField> contentFields) {
        this.contentFields = contentFields;
    }

    /**
     * @return the Content Object fields of an event
     */
    public List<ContentObjectField> getContentObjectFields() {
        return contentObjectFields;
    }


    /**
     * @param contentObjectFields
     */
    public void setContentObjectFields(List<ContentObjectField> contentObjectFields) {
        this.contentObjectFields = contentObjectFields;
    }

    /**
     * @return list of contentObjects
     */
    public List<ContentObject> getContentObjects() {
        return contentObjects;
    }

    /**
     * @param contentObjects
     */
    public void setContentObjects(List<ContentObject> contentObjects) {
        this.contentObjects = contentObjects;
    }

    /**
     *
     * @return true if Custom event
     */
    public boolean isCustomEvent() {
        return isCustomEvent;
    }

    /**
     *
     * @param customEvent
     */
    public void setCustomEvent(boolean customEvent) {
        isCustomEvent = customEvent;
    }

    public static class ContentField {
        private String fieldName;
        private String capitalizedFieldName;
        private String dataType;

        /**
         * @return the Field name of an event content
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * @param fieldName
         */
        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        /**
         * @return the Capitalized Field name of an event content
         */
        public String getCapitalizedFieldName() {
            return capitalizedFieldName;
        }

        /**
         * @param capitalizedFieldName
         */
        public void setCapitalizedFieldName(String capitalizedFieldName) {
            this.capitalizedFieldName = capitalizedFieldName;
        }

        /**
         * @return the dataType of an event content
         */
        public String getDataType() {
            return dataType;
        }

        /**
         * @param dataType
         */
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        /**
         * @param fieldName
         * @param capitalizedFieldName
         * @param dataType
         */
        public ContentField(String fieldName, String capitalizedFieldName, String dataType) {
            this.fieldName = fieldName;
            this.capitalizedFieldName = capitalizedFieldName;
            this.dataType = dataType;
        }
    }

    public static class ContentObjectField {
        private String fieldName;
        private String capitalizedFieldName;
        private String objectName;
        private String capitalizedObjectName;
        private String dataType;

        /**
         * @return the Field name of an event contentObject
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * @param fieldName
         */
        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        /**
         * @return the Capitalized Field name of an event contentObject
         */
        public String getCapitalizedFieldName() {
            return capitalizedFieldName;
        }

        /**
         * @param capitalizedFieldName
         */
        public void setCapitalizedFieldName(String capitalizedFieldName) {
            this.capitalizedFieldName = capitalizedFieldName;
        }

        /**
         * @return the Object name of an event contentObject
         */
        public String getObjectName() {
            return objectName;
        }

        /**
         * @param objectName
         */
        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        /**
         * @return the Capitalized Object name of an event contentObject
         */
        public String getCapitalizedObjectName() {
            return capitalizedObjectName;
        }

        /**
         * @param capitalizedObjectName
         */
        public void setCapitalizedObjectName(String capitalizedObjectName) {
            this.capitalizedObjectName = capitalizedObjectName;
        }

        /**
         * @return the dataType of an event contentObject
         */
        public String getDataType() {
            return dataType;
        }

        /**
         * @param dataType
         */
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        /**
         * @param fieldName
         * @param capitalizedFieldName
         * @param objectName
         * @param capitalizedObjectName
         * @param dataType
         */
        public ContentObjectField(String fieldName, String capitalizedFieldName, String objectName, String capitalizedObjectName, String dataType) {
            this.fieldName = fieldName;
            this.capitalizedFieldName = capitalizedFieldName;
            this.objectName = objectName;
            this.capitalizedObjectName = capitalizedObjectName;
            this.dataType = dataType;
        }
    }

    public static class ContentObject {
        private String capitalizedObjectName;

        /**
         * @return capitalizedObjectName
         */
        public String getCapitalizedObjectName() {
            return capitalizedObjectName;
        }

        /**
         * @param capitalizedObjectName
         */
        public void setCapitalizedObjectName(String capitalizedObjectName) {
            this.capitalizedObjectName = capitalizedObjectName;
        }

        /**
         * @param capitalizedObjectName
         */
        public ContentObject(String capitalizedObjectName) {
            this.capitalizedObjectName = capitalizedObjectName;
        }
    }
}
