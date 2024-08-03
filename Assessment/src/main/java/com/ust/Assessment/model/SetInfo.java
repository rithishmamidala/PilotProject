package com.ust.Assessment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String setId;
    private String setName;

    private String createdBy;
    @CreatedDate
    private Date createdAt;
    @UpdateTimestamp
    private Date modifiedAt;

    @OneToMany
    private List<Question> questions;

}
