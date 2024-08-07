package com.ust.Assessment.service;

import com.ust.Assessment.dto.ResponseAnswerDto;
import com.ust.Assessment.dto.ResponseQuestionDto;
import com.ust.Assessment.dto.ResponseSetDto;
import com.ust.Assessment.dto.SetDto;
import com.ust.Assessment.exception.QuestionIdNotFoundException;
import com.ust.Assessment.exception.SetIdNotFoundException;
import com.ust.Assessment.exception.SetNameNotFoundException;
import com.ust.Assessment.model.Answer;
import com.ust.Assessment.model.Question;
import com.ust.Assessment.model.SetInfo;
import com.ust.Assessment.repository.AnswerRepository;
import com.ust.Assessment.repository.QuestionRepository;
import com.ust.Assessment.repository.SetInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AssessmentService {

    @Autowired
    private SetInfoRepository setInfoRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    private ResponseAnswerDto mapAnswerToDto(Answer answer, Integer questionId) {
        ResponseAnswerDto responseAnswerDto = new ResponseAnswerDto();
        responseAnswerDto.setQuestionId(questionId);
        responseAnswerDto.setAnswerId(answer.getAnswerId());
        responseAnswerDto.setAnswer(answer.getAnswerText());
        responseAnswerDto.setSuggestion(answer.getSuggestion());
        return responseAnswerDto;
    }

    private ResponseQuestionDto mapQuestionToDto(Question question, Integer setId) {
        ResponseQuestionDto responseQuestionDto = new ResponseQuestionDto();
        responseQuestionDto.setSetId(setId);
        responseQuestionDto.setQuestionId(question.getQuestionId());
        responseQuestionDto.setQuestionText(question.getQuestionText());

        List<ResponseAnswerDto> responseAnswers = question.getAnswers().stream()
                .map(answer -> mapAnswerToDto(answer, question.getQuestionId()))
                .toList();

        responseQuestionDto.setAnswers(responseAnswers);
        return responseQuestionDto;
    }

    private ResponseSetDto mapSetInfoToDto(SetInfo setInfo) {
        ResponseSetDto responseSetDto = new ResponseSetDto();
        responseSetDto.setSetId(setInfo.getSetId());
        responseSetDto.setSetName(setInfo.getSetName());
        responseSetDto.setCreatedBy(setInfo.getCreatedBy());
        responseSetDto.setCreatedAt(setInfo.getCreatedAt());
        responseSetDto.setModifiedAt(setInfo.getModifiedAt());
        responseSetDto.setDomain(setInfo.getDomain());
        responseSetDto.setStatus(setInfo.getStatus());

        List<ResponseQuestionDto> responseQuestions = setInfo.getQuestions().stream()
                .map(question -> mapQuestionToDto(question, setInfo.getSetId()))
                .toList();

        responseSetDto.setQuestions(responseQuestions);
        return responseSetDto;
    }

    public ResponseSetDto getSetBySetName(String setname)  {
        Optional<SetInfo> setInfos = setInfoRepository.findBySetName(setname);

        if (setInfos.isPresent()) {
            SetInfo setInfo = setInfos.get();
            ResponseSetDto responseSetDto = mapSetInfoToDto(setInfo);

            return responseSetDto;

        }
        else {
            throw new SetNameNotFoundException(setname);
        }
    }
    public ResponseSetDto saveSetInfo(SetInfo setInfo) {
        for (Question question : setInfo.getQuestions()) {
            for (Answer answer : question.getAnswers()) {
                answerRepository.save(answer);
            }
            questionRepository.save(question);
        }
        setInfoRepository.save(setInfo);

        return mapSetInfoToDto(setInfo);
    }



    public List<SetDto> getAllSet() {

        return mapSetInfoListToSetDtoList(setInfoRepository.findAll());
    }

    public List<SetDto> mapSetInfoListToSetDtoList(List<SetInfo> setInfoList) {
        return setInfoList.stream()
                .map(this::mapSetInfoToSetDto)
                .toList();
    }

    private SetDto mapSetInfoToSetDto(SetInfo setInfo) {
        return new SetDto(
                setInfo.getSetId(),
                setInfo.getSetName(),
                setInfo.getCreatedBy(),
                setInfo.getDomain(),
                setInfo.getStatus()
        );
    }

    public ResponseQuestionDto modifySetQuestionInfo(Integer setId, Integer questionId, Question question) {

        Optional<SetInfo> setInfo = setInfoRepository.findById(setId);
        Optional<Question> currentQuestion = questionRepository.findById(questionId);
        if (currentQuestion.isPresent() && setInfo.isPresent()){
            question.setQuestionId(questionId);
            questionRepository.save(question);
            ResponseQuestionDto questionDto ;
            questionDto = mapQuestionToDto(question,setInfo.get().getSetId());
            return questionDto;

        }
        else if (setInfo.isEmpty()) {
            throw new SetIdNotFoundException(setId);
        } else {
            throw new QuestionIdNotFoundException(questionId);
        }
    }

    public void deleteQuestionFromAssessment(Integer setId, Integer questionId) {
        Optional<SetInfo> setInfo = setInfoRepository.findById(setId);
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent() && setInfo.isPresent()){
            questionRepository.deleteById(questionId);
        } else if (setInfo.isEmpty()) {
            throw new SetIdNotFoundException(setId);
        } else {
            throw new QuestionIdNotFoundException(questionId);
        }

    }
}