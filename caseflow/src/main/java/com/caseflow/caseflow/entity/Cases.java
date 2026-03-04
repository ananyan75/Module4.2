package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name="cases")
@Data
public class Cases {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer caseId;
    private String title;
    private Integer litigantId;
    private Integer lawyerId;
    private LocalDateTime filedDate;
    private String status;
}
