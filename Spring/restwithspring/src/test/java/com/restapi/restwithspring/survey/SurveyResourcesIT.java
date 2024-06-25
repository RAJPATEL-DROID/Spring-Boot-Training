package com.restapi.restwithspring.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyResourcesIT {

    String str = """
                {
                        "id": "Question2",
                        "description": "Fastest Growing Cloud Platform",
                        "correctAnswer": "Google Cloud",
                        "options": [
                            "AWS",
                            "Azure",
                            "Google Cloud",
                            "Oracle Cloud"
                        ]
                    }
            """;

    private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question2";

    private static String GENERIC_QUESTION_URL = "/surveys/Survey1/questions";
    @Autowired
    TestRestTemplate template = new TestRestTemplate();

    @Test
    void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
        ResponseEntity<String> responseEntity =    template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

        String expected =
                """
                {"id": "Question2","description": "Fastest Growing Cloud Platform","correctAnswer": "Google Cloud"} 
                """;

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        assertEquals( "application/json",responseEntity.getHeaders().get("Content-Type").get(0));

        JSONAssert.assertEquals(expected,responseEntity.getBody(),false);

    }

    @Test
    void retrieveAllSurveyQuestion_basicScenario() throws JSONException {
        ResponseEntity<String> responseEntity =    template.getForEntity(GENERIC_QUESTION_URL, String.class);

        String expected =
                """
                [
                         {
                         "id": "Question1"
                         },
                         {
                         "id": "Question2"
                         },
                         {
                         "id": "Question3"
                         }
                ]     
                """;

        System.out.println(responseEntity.getBody());

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        assertEquals( "application/json",responseEntity.getHeaders().get("Content-Type").get(0));

        JSONAssert.assertEquals(expected,responseEntity.getBody(),false);
    }





}