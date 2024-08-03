package com.ust.Assessment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer answerId;
    private String answer;
    private String suggestion;


}
