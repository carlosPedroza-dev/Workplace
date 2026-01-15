package com.files.Workspace.Mappers;

import com.files.Workspace.Entities.User;
import com.files.Workspace.DTOs.UserDTO;

public class UserMapper {
    public static UserDTO toDto(User user){
        if(user == null){
            return null;
        }
        return UserDTO.builder()
                .id(user.getUserId())
                .name(user.getUserName())
                .email(user.getUserEmail())
                .phone(user.getUserPhone())
                .role(user.getUserRole())
                .build();
    }
}
