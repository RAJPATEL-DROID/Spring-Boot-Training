package com.restapi.restwithspring.survey;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    public List<Survey> retrieveAllSurveys() {
            return surveys;
    }

    public Survey retrieveSurveyById(String id) {

        Optional<Survey> optionalSurvey =  surveys.stream().filter(survey -> survey.getId().equalsIgnoreCase(id)).findFirst();

        return optionalSurvey.orElse(null);

    }

    public List<Question> retrieveAllSurveyQuestions(String id) {

        Survey survey = retrieveSurveyById(id);
        if(survey == null) {
            return null;
        }
        return survey.getQuestions();
    }

    public Question retrieveSpecificSurveyQuestion(String id,String questionId) {

        Survey survey = retrieveSurveyById(id);

        if(survey == null) {

            return null;

        }

        List<Question> questions = survey.getQuestions();

        return questions.stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
    }


    public String addNewSurveyQuestion(String id, Question question) {
        List<Question> questions = retrieveAllSurveyQuestions(id);

        question.setId(generateRandomId());

        questions.add(question);

        return question.getId();

    }

    private static String generateRandomId() {
        SecureRandom secureRandom = new SecureRandom();

        String randomId = new BigInteger(32, secureRandom).toString();

        return randomId;
    }

    public String deleteSurveyQuestion(String id, String questionId) {

        List<Question> questions = retrieveAllSurveyQuestions(id);

        boolean removed= questions.removeIf(question -> question.getId().equalsIgnoreCase(questionId));

        if(!removed) {
            return null;
        }

        return questionId;

    }

    public void updateSurveyQuestion(String id, String questionId, Question question) {

        List<Question> questions = retrieveAllSurveyQuestions(id);

        questions.removeIf(q-> q.getId().equalsIgnoreCase(questionId));

        questions.add(question);

    }
}
