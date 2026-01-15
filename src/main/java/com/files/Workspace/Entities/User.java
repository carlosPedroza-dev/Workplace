package com.files.Workspace.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",unique = true)
    private Long userId;
    @Column(name = "user_name",nullable = false)
    private String userName;
    @JsonIgnore
    @Column(name = "user_password",nullable = false)
    private String userPassword;
    @Column(name = "user_email",nullable = false)
    private String userEmail;
    @Column(name = "user_phone",nullable = false)
    private String userPhone;
    @Column(name = "user_role",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role userRole;
}
