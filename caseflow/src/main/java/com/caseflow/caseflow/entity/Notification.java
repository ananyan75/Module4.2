package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name="notification")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    private Integer userId;
    private Integer caseId;
    private String message;
    private String category;
    private String status;
    private LocalDateTime createdDate;
}
