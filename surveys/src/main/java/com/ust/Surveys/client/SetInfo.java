package com.ust.Surveys.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetInfo {
    private Integer setId;
    private String setName;

    private String createdBy;

    private Date createdAt;
    
    private Date modifiedAt;
}
