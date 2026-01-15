package com.files.Workspace.Services;

import com.files.Workspace.DTOs.RegisterRequestDTO;
import com.files.Workspace.DTOs.UserDTO;
import java.util.List;

public interface IUserService {
    List<UserDTO> findAllUsers();
    UserDTO addUser(RegisterRequestDTO requestDTO);
    UserDTO updateUser(String email,RegisterRequestDTO requestDTO);
    void deleteUser(String email);
}
