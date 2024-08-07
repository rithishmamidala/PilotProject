package com.ust.Assessment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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

    private String domain;

    private String status;
    @OneToMany
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "set_id")
    private List<Question> questions;

}
