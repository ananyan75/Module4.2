package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="hearing")
@Data
public class Hearing {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer hearingId;
    private Integer caseId;
    private Integer judgeId;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
