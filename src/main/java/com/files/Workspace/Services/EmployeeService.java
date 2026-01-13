package com.files.Workspace.Services;

import com.files.Workspace.DTOs.EmployeeDTO;
import com.files.Workspace.Entities.Employee;
import com.files.Workspace.Exceptions.NotFoundException;
import com.files.Workspace.Mappers.DepartmentMapper;
import com.files.Workspace.Mappers.EmployeeMapper;
import com.files.Workspace.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDTO> showEmployees() {
       return employeeRepository.findAll().stream().map(EmployeeMapper::toDTO).toList();
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
      Employee employee = Employee.builder()
              .employeeId(employeeDTO.getId())
              .employeeName(employeeDTO.getName())
              .employeeEmail(employeeDTO.getEmail())
              .employeeDepartment(DepartmentMapper.toEntity(employeeDTO.getDepartment()))
              .employeeStatus(employeeDTO.getStatus())
                .build();

        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found"));

        employee.setEmployeeId(employeeDTO.getId());
        employee.setEmployeeName(employeeDTO.getName());
        employee.setEmployeeEmail(employeeDTO.getEmail());
        employee.setEmployeeDepartment(DepartmentMapper.toEntity(employeeDTO.getDepartment()));
        employee.setEmployeeStatus(employeeDTO.getStatus());

        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)){
            throw new NotFoundException("employee not found");
        }
        employeeRepository.deleteById(id);
    }
}
