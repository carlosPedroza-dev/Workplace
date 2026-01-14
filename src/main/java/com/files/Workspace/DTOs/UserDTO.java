package com.files.Workspace.DTOs;

import com.files.Workspace.Entities.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private int phone;
    private Role role;
}
