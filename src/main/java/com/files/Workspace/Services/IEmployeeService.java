package com.files.Workspace.Services;

import com.files.Workspace.DTOs.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> showEmployees();
    EmployeeDTO addEmployee (EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO);
    void deleteEmployee (Long id);
}
