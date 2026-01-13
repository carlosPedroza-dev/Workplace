package com.files.Workspace.Mappers;


import com.files.Workspace.DTOs.EmployeeDTO;

public class EmployeeMapper {
public static EmployeeDTO toDTO(EmployeeDTO employee){
    if(employee == null){
        return null;
    }
    return EmployeeDTO.builder()
            .id(employee.getId())
            .name(employee.getName())
            .email(employee.getEmail())
            .status(employee.getStatus())
            .build();
}
}
