package com.caseflow.caseflow.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private  String name;
    private String role;
    @Column(unique=true)
    private String email;
    private String phone;
    private String status;
}
