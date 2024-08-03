package com.ust.Assessment.service;

import com.ust.Assessment.model.Answer;
import com.ust.Assessment.model.Question;
import com.ust.Assessment.model.SetInfo;
import com.ust.Assessment.repository.AnswerRepository;
import com.ust.Assessment.repository.QuestionRepository;
import com.ust.Assessment.repository.SetInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AssessmentService {

    @Autowired
    private SetInfoRepository setInfoRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public SetInfo createSetInfo(SetInfo setInfo) {

        createQuestion(setInfo.getQuestions());
        return setInfoRepository.save(setInfo);
    }

    public List<Question> createQuestion(List<Question> questions) {


        List<Question> savedQuestions = questions.stream()
                .map(question -> {
                    // Iterate through each answer in the question
                    List<Answer> savedAnswers = question.getAnswers().stream()
                            .map(answer -> createAnswer(answer)) // Save each answer
                            .collect(Collectors.toList());

                    // Set the saved answers back to the question
                    question.setAnswers(savedAnswers);

                    // Save the question
                    return questionRepository.save(question);
                })
                .collect(Collectors.toList());

        return savedQuestions;
    }
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<SetInfo> getSetInfo() {
        return setInfoRepository.findAll();
    }


}
