package com.ust.Assessment.dto;

import com.ust.Assessment.model.Question;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseSetDto {
    private Integer setId;
    private String setName;

    private String createdBy;
    private Date createdAt;
    private Date modifiedAt;

    private String domain;

    private String status;

    private List<ResponseQuestionDto> questions;
}
