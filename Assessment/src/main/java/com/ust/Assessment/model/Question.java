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
    private String questionId;
    private String questionText;

    @ManyToOne
    private SetInfo set;

    @OneToMany
    private List<Answer> answers;
}
