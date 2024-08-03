package com.ust.Assessment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    private Integer setId;
    private String setName;

    private String createdBy;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date modifiedAt;

    @OneToMany
    @JoinColumn(name = "set_id")
    private List<Question> questions;

}
