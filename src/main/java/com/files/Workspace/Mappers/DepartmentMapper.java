package com.files.Workspace.Mappers;

import com.files.Workspace.DTOs.DepartmentDTO;
import com.files.Workspace.Entities.Department;

public class DepartmentMapper {
    public static DepartmentDTO toDTO(Department department){
        if(department == null){
            return null;
        }
        return DepartmentDTO.builder()
                .id(department.getDepartmentId())
                .name(department.getDepartmentName())
                .employeeCount(department.getDepartmentCount())
                .build();

    }

    public static Department toEntity(DepartmentDTO dto){
        if(dto == null){
            return null;
        }
        return Department.builder()
                .departmentId(dto.getId())
                .departmentName(dto.getName())
                .departmentCount(dto.getEmployeeCount())
                .build();
    }
}
