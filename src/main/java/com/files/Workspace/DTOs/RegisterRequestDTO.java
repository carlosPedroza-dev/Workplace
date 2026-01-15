package com.files.Workspace.DTOs;

import com.files.Workspace.Entities.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Role role;
}
