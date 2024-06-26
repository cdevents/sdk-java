// Code generated by dev.cdevents.generator.CDEventsGenerator. DO NOT EDIT.

/*
Copyright 2023 The CDEvents Authors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

SPDX-License-Identifier: Apache-2.0
*/

package dev.cdevents.events;


import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.testsuiterun.started.*;

import java.net.URI;
import java.util.Date;
import java.util.UUID;
import java.util.List;


public class TestsuiterunStartedCDEvent extends Testsuiterunstarted implements CDEvent {


    /**
    * Constructor to init CDEvent and set the Subject for {@link TestsuiterunStartedCDEvent}.
    */

    public TestsuiterunStartedCDEvent() {
        initCDEvent();
    }


    /**
    * Initialize the CDEvent with the context values.
    */

    @Override
    public void initCDEvent() {
        setContext(new Context());
        setSubject(new Subject());
        setCustomData(new Object());
        setCustomDataContentType("application/json");
        Context context = getContext();
        context.setId(UUID.randomUUID().toString());
        context.setTimestamp(new Date());
        context.setVersion(CDEventConstants.CDEVENTS_SPEC_VERSION);
        getSubject().setContent(new Content());
        getSubject().getContent().setTrigger(new Trigger());
        getSubject().getContent().setEnvironment(new Environment());
        getSubject().getContent().setTestSuite(new TestSuite());
        getSubject().setType(Subject.Type.TEST_SUITE_RUN);
    }

    /**
    * @return the event source
    */

    @Override
    public String eventSource() {
        return getContext().getSource();
    }


    /**
    * @return the current CDEvent type
    */

    @Override
    public String currentCDEventType() {
        return getContext().getType().value();
    }


    /**
    * @return the testsuiterunstarted.json schema URL
    */

    @Override
    public String schemaURL() {
        return "https://cdevents.dev/0.4.1/schema/test-suite-run-started-event";
    }

    /**
    * @return the base URI of the schema
    */

    @Override
    public String baseURI() {
        return "https://cdevents.dev/0.4.1/schema/";
    }


    /**
    * @return the CDEvent's schema file name
    */

    @Override
    public String schemaFileName() {
        return "testsuiterunstarted.json";
    }

    /**
    *
    * @return custom schema URI
    */
    @Override
    public URI customSchemaUri(){
        return getContext().getSchemaUri();
    }


    /**
    * @param source
    * Sets the {@link Context} source value
    */

    public void setSource(URI source) {
        getContext().setSource(source.toString());
    }

    /**
     * @param chainId
     * Sets the {@link Context} chainId value
     */

    public void setChainId(String chainId) {
        getContext().setChainId(chainId);
    }

    /**
     * @param schemaUri
     * Sets the {@link Context} custom schemaUri value
     */

    public void setCustomSchemaUri(URI schemaUri) {
        getContext().setSchemaUri(schemaUri);
    }

    /**
    * @param subjectId
    * sets the subject Id
    */

    public void setSubjectId(String subjectId) {
        getSubject().setId(subjectId);
    }


    /**
    * @param subjectSource
    * sets the subject source
    */

    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource.toString());
    }

    //getContentFields starts


    //getContentObjectFields starts

    /**
    * @param type
    */
    public void setSubjectTriggerType(Trigger.Type type) {
        getSubject().getContent().getTrigger().setType(type);
    }
    /**
    * @param uri
    */
    public void setSubjectTriggerUri(URI uri) {
        getSubject().getContent().getTrigger().setUri(uri);
    }
    /**
    * @param id
    */
    public void setSubjectEnvironmentId(String id) {
        getSubject().getContent().getEnvironment().setId(id);
    }
    /**
    * @param source
    */
    public void setSubjectEnvironmentSource(String source) {
        getSubject().getContent().getEnvironment().setSource(source);
    }
    /**
    * @param id
    */
    public void setSubjectTestSuiteId(String id) {
        getSubject().getContent().getTestSuite().setId(id);
    }
    /**
    * @param version
    */
    public void setSubjectTestSuiteVersion(String version) {
        getSubject().getContent().getTestSuite().setVersion(version);
    }
    /**
    * @param name
    */
    public void setSubjectTestSuiteName(String name) {
        getSubject().getContent().getTestSuite().setName(name);
    }
    /**
    * @param uri
    */
    public void setSubjectTestSuiteUri(URI uri) {
        getSubject().getContent().getTestSuite().setUri(uri);
    }

}
