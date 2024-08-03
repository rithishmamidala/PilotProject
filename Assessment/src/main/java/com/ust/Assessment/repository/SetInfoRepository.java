package com.ust.Assessment.repository;

import com.ust.Assessment.model.SetInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SetInfoRepository extends JpaRepository<SetInfo,Integer> {
    List<SetInfo> findAllBySetName(String setname);

    Optional<SetInfo> findBySetName(String setName);
}
