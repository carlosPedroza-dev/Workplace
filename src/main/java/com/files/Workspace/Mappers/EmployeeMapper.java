package com.files.Workspace.Mappers;


import com.files.Workspace.DTOs.EmployeeDTO;
import com.files.Workspace.Entities.Employee;

public class EmployeeMapper {
public static EmployeeDTO toDTO(Employee employee){
    if(employee == null){
        return null;
    }
    return EmployeeDTO.builder()
            .id(employee.getEmployeeId())
            .name(employee.getEmployeeName())
            .email(employee.getEmployeeEmail())
            .department(DepartmentMapper.toDTO(employee.getEmployeeDepartment()))
            .status(employee.getEmployeeStatus())
            .build();
}}
