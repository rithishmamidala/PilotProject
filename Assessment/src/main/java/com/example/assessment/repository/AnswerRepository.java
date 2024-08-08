package com.example.assessment.repository;

import com.example.assessment.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Option,Integer> {
}
