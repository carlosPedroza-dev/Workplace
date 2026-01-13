package com.files.Workspace.Mappers;

import com.files.Workspace.DTOs.DepartmentDTO;

public class DepartmentMapper {
    public static DepartmentDTO toDTO(DepartmentDTO department){
        if(department == null){
            return null;
        }
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .employeeCount(department.getEmployeeCount())
                .build();

    }
}
