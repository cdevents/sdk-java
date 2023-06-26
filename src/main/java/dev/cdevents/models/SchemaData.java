package dev.cdevents.models;

import java.util.List;

public class SchemaData {

    private String subject;
    private String predicate;

    private String capitalizedSubject;

    private String capitalizedPredicate;

    private String objectName;
    private String capitalizedObjectName;
    private String version;
    private String upperCaseSubject;
    private String schemaFileName;

    private List<ContentField> contentFields;

    private List<ContentObjectField> contentObjectFields;

    public SchemaData(){

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpperCaseSubject() {
        return upperCaseSubject;
    }

    public void setUpperCaseSubject(String upperCaseSubject) {
        this.upperCaseSubject = upperCaseSubject;
    }

    public String getCapitalizedSubject() {
        return capitalizedSubject;
    }

    public void setCapitalizedSubject(String capitalizedSubject) {
        this.capitalizedSubject = capitalizedSubject;
    }

    public String getCapitalizedPredicate() {
        return capitalizedPredicate;
    }

    public void setCapitalizedPredicate(String capitalizedPredicate) {
        this.capitalizedPredicate = capitalizedPredicate;
    }

    public String getSchemaFileName() {
        return schemaFileName;
    }

    public void setSchemaFileName(String schemaFileName) {
        this.schemaFileName = schemaFileName;
    }

    public List<ContentField> getContentFields() {
        return contentFields;
    }

    public void setContentFields(List<ContentField> contentFields) {
        this.contentFields = contentFields;
    }

    public List<ContentObjectField> getContentObjectFields() {
        return contentObjectFields;
    }

    public void setContentObjectFields(List<ContentObjectField> contentObjectFields) {
        this.contentObjectFields = contentObjectFields;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getCapitalizedObjectName() {
        return capitalizedObjectName;
    }

    public void setCapitalizedObjectName(String capitalizedObjectName) {
        this.capitalizedObjectName = capitalizedObjectName;
    }

    public SchemaData(String subject, String predicate, String version, String upperCaseSubject, String schemaFileName) {
        this.subject = subject;
        this.predicate = predicate;
        this.version = version;
        this.upperCaseSubject = upperCaseSubject;
        this.schemaFileName = schemaFileName;
    }

    public static class ContentField {
        private String fieldName;
        private String capitalizedFieldName;
        private String dataType;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getCapitalizedFieldName() {
            return capitalizedFieldName;
        }

        public void setCapitalizedFieldName(String capitalizedFieldName) {
            this.capitalizedFieldName = capitalizedFieldName;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

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

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getCapitalizedFieldName() {
            return capitalizedFieldName;
        }

        public void setCapitalizedFieldName(String capitalizedFieldName) {
            this.capitalizedFieldName = capitalizedFieldName;
        }

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getCapitalizedObjectName() {
            return capitalizedObjectName;
        }

        public void setCapitalizedObjectName(String capitalizedObjectName) {
            this.capitalizedObjectName = capitalizedObjectName;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public ContentObjectField(String fieldName, String capitalizedFieldName, String objectName, String capitalizedObjectName, String dataType) {
            this.fieldName = fieldName;
            this.capitalizedFieldName = capitalizedFieldName;
            this.objectName = objectName;
            this.capitalizedObjectName = capitalizedObjectName;
            this.dataType = dataType;
        }
    }
}
