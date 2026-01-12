package com.files.Workspace.DTOs;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DepartmentDTO {
    private Long id;
    private String name;
   private int employeeCount;
}
