package com.spring.jwt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee_farmer_survey",
        indexes = {
                @Index(name = "idx_emp_survey_form_number", columnList = "formNumber"),
                @Index(name = "idx_emp_survey_mobile", columnList = "farmerMobile"),
                @Index(name = "idx_emp_survey_employee_id", columnList = "employee_id"),
                @Index(name = "idx_emp_survey_district", columnList = "district")
        }
)
public class EmployeeFarmerSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;

    @Column(unique = true)
    private String formNumber;

    private String farmerName;

    private String farmerMobile;

    private String landArea;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String taluka;

    private String district;

    private Boolean sampleCollected = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private User employee;

    private LocalDateTime createdAt = LocalDateTime.now();
}