package com.ust.Assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;
    private String questionText;



    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Answer> answers;
}
