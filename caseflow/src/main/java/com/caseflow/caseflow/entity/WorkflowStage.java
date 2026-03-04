package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="workflow_stage")
@Data
public class WorkflowStage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer stageId;
    private Integer caseId;
    private Integer sequenceNumber;
    private String roleResponsible;
    private Integer sla_Days;
}
