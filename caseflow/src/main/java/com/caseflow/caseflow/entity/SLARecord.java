package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="sla_record")
@Data
public class SLARecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slaRecordId;
    private Integer caseId;
    private Integer stageId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
