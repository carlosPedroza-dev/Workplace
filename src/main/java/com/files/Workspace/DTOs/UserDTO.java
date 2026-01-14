package com.files.Workspace.DTOs;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private String name;
    private String password;
}
