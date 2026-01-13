package com.files.Workspace.DTOs;

import com.files.Workspace.Entities.EmployeeStatus;

import lombok.Builder;
import lombok.Data;
import java.util.List;


@Builder
@Data
public class EmployeeDTO{
    private Long id;
    private String name;
    private String email;
    private DepartmentDTO department;
    private EmployeeStatus status;
}
