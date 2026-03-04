package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name="audit_log")
@Data
public class AuditLog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer auditId;
    private Integer userId;
    private String action;
    private String resource;
    private LocalDateTime timestamp;
}
