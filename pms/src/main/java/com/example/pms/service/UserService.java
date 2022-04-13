package com.example.pms.service;

import com.example.pms.dto.UserDTO;
import com.example.pms.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO updateUsers(UserDTO userDTO);

    public User getUserByName(String name);
}
