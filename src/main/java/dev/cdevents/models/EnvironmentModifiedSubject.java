package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class EnvironmentModifiedSubject extends Subject {

    @JsonProperty(required = true)
    private  EnvironmentModifiedSubjectContent content;



    /**
     * @return the EnvironmentModified subject's content
     */
    public EnvironmentModifiedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(EnvironmentModifiedSubjectContent content) {
        this.content = content;
    }

    /**
     * Constructor to set the Subject Type.
     *
     * @param subjectType
     */
    public EnvironmentModifiedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new EnvironmentModifiedSubjectContent());
    }


    public class EnvironmentModifiedSubjectContent {
        @JsonProperty
        private String name;

        @JsonProperty
        private String url;

        /**
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @param url
         */
        public void setUrl(String url) {
            this.url = url;
        }
    }
}
