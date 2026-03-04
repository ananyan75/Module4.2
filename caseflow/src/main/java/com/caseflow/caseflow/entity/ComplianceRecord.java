package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="compliance_record")
@Data
public class ComplianceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complianceId;
    private Integer caseId;
    private String type;
    private String result;
    private LocalDate date;
    private String notes;
}
