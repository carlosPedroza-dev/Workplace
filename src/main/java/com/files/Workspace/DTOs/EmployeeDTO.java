package com.files.Workspace.DTOs;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String status;
}
