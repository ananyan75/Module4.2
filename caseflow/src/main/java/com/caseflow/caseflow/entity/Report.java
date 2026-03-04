package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="report")
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;
    private String scope;
    private String metrics;
    @Column(name="GeneratedDate")
    private LocalDate generatedDate;
}
