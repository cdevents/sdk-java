package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class EnvironmentCreatedSubject extends Subject{

    @JsonProperty(required = true)
    private  EnvironmentCreatedSubjectContent content;



    /**
     * @return the EnvironmentCreated subject's content
     */
    public EnvironmentCreatedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(EnvironmentCreatedSubjectContent content) {
        this.content = content;
    }

    /**
     * Constructor to set the Subject Type.
     *
     * @param subjectType
     */
    public EnvironmentCreatedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new EnvironmentCreatedSubjectContent());
    }


    public class EnvironmentCreatedSubjectContent {
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
