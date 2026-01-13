package com.files.Workspace.Services;

import com.files.Workspace.DTOs.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDTO> showDepartments();
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(Long id,DepartmentDTO departmentDTO);
    void deleteDepartment(Long id);
}
