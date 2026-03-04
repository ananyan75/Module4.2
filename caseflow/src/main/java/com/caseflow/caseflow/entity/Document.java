package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name="document")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer documentId;
    private Integer caseId;
    private String title;
    private String type;
    private String uri;
    private LocalDateTime uploadedDate;
    private String verificationStatus;
}
