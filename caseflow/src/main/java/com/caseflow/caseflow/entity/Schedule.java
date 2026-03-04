package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Table(name="schedule")
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer scheduleId;
    private Integer judgeId;
    private LocalDate date;
    private String timeSlot;
    private Boolean availability;
}
