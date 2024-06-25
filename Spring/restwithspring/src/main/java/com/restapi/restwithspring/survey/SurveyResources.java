package com.restapi.restwithspring.survey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyResources {

    private SurveyService surveyService;

    public SurveyResources(SurveyService surveyService) {
        this.surveyService = surveyService;

    }

    @RequestMapping("/surveys")
    public List<Survey> getAllSurveys() {
        return surveyService.retrieveAllSurveys();
    }

    @RequestMapping("/surveys/{id}")
    public Survey getSurveyById(@PathVariable String id) {
        Survey survey = surveyService.retrieveSurveyById(id);
        if(survey == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping("/surveys/{id}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String id) {

        List<Question> questions = surveyService.retrieveAllSurveyQuestions(id);

        if(questions == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return questions;
    }

    @RequestMapping("/surveys/{id}/questions/{questionId}")
    public Question retrieveSpecificSurveyQuestion(@PathVariable String id, @PathVariable String questionId) {

        Question question = surveyService.retrieveSpecificSurveyQuestion(id,questionId);

        if(question== null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        return question;
    }

    @RequestMapping(value = "/surveys/{id}/questions",method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String id, @RequestBody Question question) {

       String questionId = surveyService.addNewSurveyQuestion(id, question);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();

       return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/surveys/{id}/questions/{questionId}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String id, @PathVariable String questionId) {

        surveyService.deleteSurveyQuestion(id,questionId);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/surveys/{id}/questions/{questionId}",method = RequestMethod.PUT)
    public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String id, @PathVariable String questionId, @RequestBody Question question) {

        surveyService.updateSurveyQuestion(id,questionId,question);

        return ResponseEntity.noContent().build();
    }


}
