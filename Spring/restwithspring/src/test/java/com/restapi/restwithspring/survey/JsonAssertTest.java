package com.restapi.restwithspring.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    @Test
    void JsonAssert_learningBasics() throws JSONException {
        String expectedResponse =
                """
                {"id":"Question2","description":"Fastest Growing Cloud Platform","correctAnswer":"Google Cloud"}        
                """;

        String expectedResponse2 =
                """
                {"id":"Question2","description":"Fastest Growing Cloud Platform","correctAnswer":"Google Cloud","options":["AWS","Azure","Google Cloud","Oracle Cloud"]}
                """;

        JSONAssert.assertEquals(expectedResponse,expectedResponse2,false);
    }

}
