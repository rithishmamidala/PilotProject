package com.ust.assessment.repository;

import com.ust.assessment.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Option,Integer> {
}
