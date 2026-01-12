package com.files.Workspace.Entities;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name="employee_name",nullable = false,unique = true)
    private String employeeName;

    @Column(name = "employee_email",nullable = false,unique = true)
    private String employeeEmail;

    @Column(name = "employee_department",nullable = false)
    private Department employeeDepartment;

    @Column(name = "employee_role",nullable = false)
    private String employeeRole;

    @Column(name = "employee_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;
}
