package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="audit")
@Data
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditId;
    private Integer adminId;
    private String scope;
    private String findings;
    private LocalDate date;
    private String status;
}
