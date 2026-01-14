package com.files.Workspace.Services;

import com.files.Workspace.DTOs.UserDTO;
import java.util.List;

public interface IUserService {
    List<UserDTO> showUser();
    UserDTO addUser(UserDTO userDTO);
    UserDTO updateUser(Long id,UserDTO userDTO);
    void deleteUser(Long id);
}
