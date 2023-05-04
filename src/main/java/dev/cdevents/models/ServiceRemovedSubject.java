package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class ServiceRemovedSubject extends Subject{

    @JsonProperty(required = true)
    private ServiceRemovedSubjectContent content;

    /**
     * @return the Service Removed subject's Content
     */
    public ServiceRemovedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(ServiceRemovedSubjectContent content) {
        this.content = content;
    }

    public ServiceRemovedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new ServiceRemovedSubjectContent());
    }

    public class ServiceRemovedSubjectContent {

        @JsonProperty
        private Environment environment = new Environment();

        public Environment getEnvironment() {
            return environment;
        }

        public void setEnvironment(Environment environment) {
            this.environment = environment;
        }

        public class Environment {
            private String id;
            private URI source;

            /**
             * @return id
             */
            public String getId() {
                return id;
            }

            /**
             * @param id
             */
            public void setId(String id) {
                this.id = id;
            }

            /**
             * @return source
             */
            public URI getSource() {
                return source;
            }

            /**
             * @param source
             */
            public void setSource(URI source) {
                this.source = source;
            }

        }
    }
}
