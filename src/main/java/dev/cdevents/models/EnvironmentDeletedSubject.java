package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

public class EnvironmentDeletedSubject extends Subject {

    @JsonProperty(required = true)
    private  EnvironmentDeletedSubjectContent content;



    /**
     * @return the EnvironmentDeleted subject's content
     */
    public EnvironmentDeletedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(EnvironmentDeletedSubjectContent content) {
        this.content = content;
    }

    /**
     * Constructor to set the Subject Type.
     *
     * @param subjectType
     */
    public EnvironmentDeletedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new EnvironmentDeletedSubjectContent());
    }


    public class EnvironmentDeletedSubjectContent {
        @JsonProperty
        private String name;

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

    }
}
