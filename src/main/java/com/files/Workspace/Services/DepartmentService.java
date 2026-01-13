package com.files.Workspace.Services;

import com.files.Workspace.DTOs.DepartmentDTO;
import com.files.Workspace.Entities.Department;
import com.files.Workspace.Exceptions.NotFoundException;
import com.files.Workspace.Mappers.DepartmentMapper;
import com.files.Workspace.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> showDepartments() {
        return departmentRepository.findAll().stream().map(DepartmentMapper::toDTO).toList();
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .departmentId(departmentDTO.getId())
                .departmentName(departmentDTO.getName())
                .departmentCount(departmentDTO.getEmployeeCount())
                .build();

        return DepartmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department not found"));

        department.setDepartmentId(departmentDTO.getId());
        department.setDepartmentName(departmentDTO.getName());
        department.setDepartmentCount(departmentDTO.getEmployeeCount());

        return DepartmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new NotFoundException("Department not found");
        }
        departmentRepository.deleteById(id);
    }
}
