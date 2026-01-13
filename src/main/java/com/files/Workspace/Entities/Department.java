package com.files.Workspace.Entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long departmentId;

    @Column(name = "department_name",unique = true,nullable = false)
    private String departmentName;

    @Column(name = "department_count",nullable = false)
    private int departmentCount = 0;
}
