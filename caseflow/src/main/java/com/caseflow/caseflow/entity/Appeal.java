package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="appeal")
@Data
public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appealId;
    private Integer caseId;
    private LocalDate filedDate;
    private String reason;
    private String status;
}