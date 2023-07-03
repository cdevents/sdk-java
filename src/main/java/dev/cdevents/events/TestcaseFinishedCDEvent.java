// Code generated by dev.cdevents.CDEventsGenerator. DO NOT EDIT.

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
import dev.cdevents.exception.CDEventsException;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.testcase.finished.*;

import java.net.URI;
import java.util.Date;
import java.util.UUID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestcaseFinishedCDEvent extends Testcasefinished implements CDEvent {


    /**
    * Constructor to init CDEvent and set the Subject for {@link TestcaseFinishedCDEvent}.
    */

    public TestcaseFinishedCDEvent() {
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
        getSubject().setType(CDEventConstants.SubjectType.TESTCASE.getSubjectType());
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
    * @return the testcasefinished.json schema URL
    */

    @Override
    public String schemaURL() {
        return "https://cdevents.dev/0.1.2/schema/test-case-finished-event";
    }


    /**
    * @return the testcasefinished.json schema Json
    */

    @Override
    public String eventSchema() {
        try {
            return Files.readString(Paths.get(CDEventConstants.SCHEMA_FOLDER + "/testcasefinished.json"));
        } catch (IOException e) {
            throw new CDEventsException("Exception while reading Event JsonSchema file ", e);
        }
    }


    /**
    * @param source
    * Sets the {@link Context} source value
    */

    public void setSource(URI source) {
        getContext().setSource(source.toString());
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




}
