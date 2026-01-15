package com.files.Workspace.Services;

import com.files.Workspace.DTOs.RegisterRequestDTO;
import com.files.Workspace.DTOs.UserDTO;
import com.files.Workspace.Entities.Role;
import com.files.Workspace.Entities.User;
import com.files.Workspace.Exceptions.BadRequestException;
import com.files.Workspace.Exceptions.NotFoundException;
import com.files.Workspace.Mappers.UserMapper;
import com.files.Workspace.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder encoder,UserRepository userRepository){
        this.passwordEncoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDTO addUser(RegisterRequestDTO requestDTO) {

        User user = User.builder()
                .userPassword(passwordEncoder.encode(requestDTO.getPassword()))
                .userEmail(requestDTO.getEmail())
                .userPhone(requestDTO.getPhone())
                .userRole(Role.USER)
                .build();

        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(String email,RegisterRequestDTO requestDTO) {
        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new NotFoundException("user not found"));

        boolean update = false;

        if(requestDTO.getEmail() != null && !requestDTO.getEmail().equals(user.getUserEmail()) && userRepository.existByUserEmail(requestDTO.getEmail())){
            throw new BadRequestException("Email already on use");
        }

        if(requestDTO.getName() != null){
            user.setUserName(requestDTO.getName());
            update = true;
        }
        if (requestDTO.getPassword() != null){
            user.setUserPassword(passwordEncoder.encode(requestDTO.getPassword()));
            update = true;
        }
        if(requestDTO.getEmail() != null){
            user.setUserEmail(requestDTO.getEmail());
            update = true;
        }
        if(requestDTO.getPhone() != null){
            if (requestDTO.getPhone().matches("\\d{10}")) {
                user.setUserPhone(requestDTO.getPhone());
                update = true;
            }
        }
        if(requestDTO.getRole() != null){
            user.setUserRole(requestDTO.getRole());
            update = true;
        }
        if (!update){
            throw new BadRequestException("No fields provided to update");
        }
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(String email) {
User user = userRepository.findByUserEmail(email)
        .orElseThrow(() -> new NotFoundException("User not found"));

userRepository.delete(user);
    }
}
