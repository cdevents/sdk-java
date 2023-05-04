package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.packageurl.PackageURL;
import dev.cdevents.constants.CDEventConstants;
import java.net.URI;

public class ServiceDeployedSubject extends Subject{

    @JsonProperty(required = true)
    private ServiceDeployedSubjectContent content;

    /**
     * @return the Service Deployed subject's Content
     */
    public ServiceDeployedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(ServiceDeployedSubjectContent content) {
        this.content = content;
    }

    public ServiceDeployedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new ServiceDeployedSubjectContent());
    }

    public class ServiceDeployedSubjectContent {

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
