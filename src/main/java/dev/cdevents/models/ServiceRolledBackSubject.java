package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.packageurl.PackageURL;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class ServiceRolledBackSubject extends Subject{

    @JsonProperty(required = true)
    private ServiceRolledBackSubjectContent content;

    /**
     * @return the Service RolledBack subject's Content
     */
    public ServiceRolledBackSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(ServiceRolledBackSubjectContent content) {
        this.content = content;
    }

    public ServiceRolledBackSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new ServiceRolledBackSubjectContent());
    }

    public class ServiceRolledBackSubjectContent {

        @JsonProperty
        private Environment environment = new Environment();
        @JsonProperty
        private String artifactId;

        public Environment getEnvironment() {
            return environment;
        }

        public void setEnvironment(Environment environment) {
            this.environment = environment;
        }

        public String getArtifactId() {
            return artifactId;
        }

        public void setArtifactId(String artifactId) {
            this.artifactId = artifactId;
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
